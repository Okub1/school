package exceptions;

/**
 * Vynimka, ktora sa vyhadzuje vzdy, ked je miesto v garazi obsadene.
 */
public class MiestoJeObsadeneException extends Exception {
    public MiestoJeObsadeneException(String sprava) {
        super(sprava);
    }
}
