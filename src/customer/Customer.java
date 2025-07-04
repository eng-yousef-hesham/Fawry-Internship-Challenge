package customer;

import java.util.List;

import cart.Cart;
import cart.CartItem;
import product_info.Product;
import service.ShippingService;



public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void checkout(Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty!");
        }

        double subtotal = cart.getSubtotal();
        double shippingFee = calculateShippingFee(cart.getShippableItems());
        double total = subtotal + shippingFee;

        if (balance < total) {
            throw new IllegalStateException("Insufficient balance.");
        }

        if (!cart.getShippableItems().isEmpty()) {
            ShippingService.ship(cart);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.print( item.getQuantity()+"x "+ item.getProduct().getName()+"\t"+
                    item.getProduct().getPrice() * item.getQuantity()+"\n");
        }
        System.out.println("----------------------");
        System.out.print("Subtotal\t"+ subtotal+" \n");
        System.out.print("Shipping\t"+ shippingFee+" \n");
        System.out.print("Amount\t\t"+ total+ " \n");

        balance -= total;
        System.out.print("Customer balance after payment: "+ balance+ " \n");

        for (CartItem item : cart.getItems()) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }
    }

    private double calculateShippingFee(List<Product> shippableItems) {
        double weight = 0;
        for (Product product : shippableItems) {
            weight += product.getWeight();
        }
        return weight > 0 ? 30 : 0;
    }

    public double getBalance() {
        return balance;
    }
}
