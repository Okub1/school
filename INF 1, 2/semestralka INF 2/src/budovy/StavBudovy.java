package budovy;

/**
 * Enum ktory nam definuje stav budovy, ci hori, alebo nehori, alebo je uz zhorena.
 */
public enum StavBudovy {
    NEHORI("nehori"),
    HORI("hori"),
    ZHORENA("zhorena");

    private String stav;

    /**
     * Konstruktor na vytvorenie stavu budovy.
     *
     * @param stav stav budovy.
     */
    StavBudovy(String stav) {
        this.stav = stav;
    }

    /**
     * Metoda na vypisanie stavu budovy v textovom retazci.
     *
     * @return vrati stav v textovom retazci.
     */
    public String toString() {
        return this.stav;
    }
}
