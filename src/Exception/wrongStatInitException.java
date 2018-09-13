package Exception;

/**
 * Exception de mauvaise instantiation des caractéristiques du personnage
 */
public class wrongStatInitException extends Throwable {

    public wrongStatInitException(String s) {
        super(s);
    }

}
