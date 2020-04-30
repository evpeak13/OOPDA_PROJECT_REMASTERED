package v1;

/**
 * Custom Exception
 * The exception is thrown when an instance of a file already exists when trying to make a new one. The exception is thrown 
 * @author team Cyan
 *
 */
public class DuplicateFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuplicateFoundException(String username) {
        super("User: "+username+" already exists");

    }

}