package product_info;

import java.time.LocalDate;

public class Expirable implements Expiration{
    private final LocalDate expiryDate;

    public Expirable(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
