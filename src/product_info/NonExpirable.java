package product_info;

public class NonExpirable implements Expiration {

    @Override
    public boolean isExpired() {
        return false;
    }
}
