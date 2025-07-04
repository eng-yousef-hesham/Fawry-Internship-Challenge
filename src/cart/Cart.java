package cart;

import java.util.List;
import java.util.ArrayList;
import product_info.Product;



public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product.isExpired()) {
            throw new IllegalStateException(product.getName() + " is expired.");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.product.getPrice() * item.quantity;
        }
        return subtotal;
    }

    public List<Product> getShippableItems() {
        List<Product> shippable = new ArrayList<>();
        for (CartItem item : items) {
            if (item.product.requiresShipping()) {
                shippable.add(item.product);
            }
        }
        return shippable;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }
}
