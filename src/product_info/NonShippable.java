package product_info;

public class NonShippable implements Shipping {
    @Override
    public boolean needShipping() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0.0;
    }
}
