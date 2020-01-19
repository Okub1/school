package osoby;


/**
 * Enum, ktory nam definuje pohlavie osob.
 * Mozu byt len dve pohlavia:
 * Pohlavie.MUZ a Pohlavie.ZENA.
 */
public enum Pohlavie {
    MUZ("muz"),
    ZENA("zena");

    private String pohlavie;

    /**
     * Kontruktor na vytvorenie pohlavia.
     *
     * @param pohlavie typ pohlavia.
     */
    Pohlavie(String pohlavie) {
        this.pohlavie = pohlavie;
    }
    /**
     * Metoda na vypisanie pohlavia osoby v textovom retazci.
     *
     * @return vrati stav v textovom retazci.
     */
    public String toString() {
        return this.pohlavie;
    }
}
