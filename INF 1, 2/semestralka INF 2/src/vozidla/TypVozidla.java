package vozidla;


/**
 * Enum, ktory definuje typ vozidla. (zatial len hasicske auto)
 */
public enum TypVozidla {
    AUTO("auto"),
    HASICSKEAUTO("hasicske auto");

    private String typ;

    /**
     * Kontruktor, na vytovrenie typu vozidla
     *
     * @param typ typ vozidla.
     */
    TypVozidla(String typ) {
        this.typ = typ;
    }

    /**
     * Metoda na vypisanie vsetkych informacii o type vozidla v retazci.
     *
     * @return vrati typ vozidla v retazci.
     */
    public String toString() {
        return this.typ;
    }
}
