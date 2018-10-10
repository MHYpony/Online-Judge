package db.exception;

@SuppressWarnings("serial")
public class CRUDException extends RuntimeException {

    public CRUDException() {
        super();
    }

    public CRUDException(String message) {
        super(message);
    }

}
