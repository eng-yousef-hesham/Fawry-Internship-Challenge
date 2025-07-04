import cart.Cart;
import customer.Customer;
import product_info.NonExpirable;
import product_info.NonShippable;
import product_info.Product;
import product_info.Shippable;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {



        Product cheese = new Product("cheese",100.0,10, new NonExpirable(),new NonShippable());
        Product tv = new Product("tv",100.0,10, new NonExpirable(),new Shippable(755));
        Product scratchCard = new Product("scratchCard",100.0,10, new NonExpirable(),new NonShippable());

        Customer customer = new Customer("yousef", 1000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);
        customer.checkout(cart);


    }
}