package exceptions;

/**
 * Vynimka, ktora sa vyhadzuje vzdy, ked je zadany zly parameter.
 */
public class ZlyParameterException extends Exception {
    public ZlyParameterException(String sprava) {
        super(sprava);
    }
}