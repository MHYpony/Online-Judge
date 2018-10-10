package db.exception;

@SuppressWarnings("serial")
public class ExpiryException extends RuntimeException {

    public ExpiryException() {
        super();
    }

    public ExpiryException(String message) {
        super(message);
    }

}
