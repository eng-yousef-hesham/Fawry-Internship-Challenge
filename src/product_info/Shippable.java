package product_info;

public class Shippable implements Shipping{
    private final double weight;

    public Shippable(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean needShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
