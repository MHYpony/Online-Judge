package db.exception;


@SuppressWarnings("serial")
public class ExistenceException extends RuntimeException {

    public ExistenceException() {
        super();
    }

    public ExistenceException(String message) {
        super(message);
    }

}
