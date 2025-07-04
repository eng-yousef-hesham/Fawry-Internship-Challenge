package product_info;

public class Product {
    private final String name;
    private final double price;
    private int quantity;
    private final Expiration expiration;
    private final Shipping shipping;

    public Product(String name, double price, int quantity,
                   Expiration expiration,
                   Shipping shipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiration = expiration;
        this.shipping = shipping;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        }
    }

    public boolean isExpired() {
        return expiration.isExpired();
    }

    public boolean requiresShipping() {
        return shipping.needShipping();
    }

    public double getWeight() {
        return shipping.getWeight();
    }
}
