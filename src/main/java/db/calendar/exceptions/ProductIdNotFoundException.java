package db.calendar.exceptions;

public class ProductIdNotFoundException extends RuntimeException {

    public ProductIdNotFoundException(String message) {
        super(message);
    }
}
