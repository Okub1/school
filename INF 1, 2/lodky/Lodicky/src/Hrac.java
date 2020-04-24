/**
 * Trieda umoznujuca nastavenie mena hracom a pridelenie
 * hracieho pola hracom
 */
public class Hrac {

    private String meno;
    private HraciePole hraciePole;

    /**
     * Konstruktor hraca, vytvorenie hraca s konkretnym menom.
     * @param meno - meno hraca
     */
    public Hrac(String meno) {
        this.meno = meno;
    }

    /**
     * Getter: jednoducha metoda na ziskavanie hracieho pola (this) hraca.
     * @return
     */
    public HraciePole getHraciePole() {
        return hraciePole;
    }

    /**
     * Setter sluziaci na pridelenie hracieho pola ku konkretnemu hracovi (this)
     * @param hraciePole
     */
    public void setHraciePole(HraciePole hraciePole) {
        this.hraciePole = hraciePole;
    }

    /**
     * Getter: jednodcha metoda na ziskavanie iba mena hraca.
     * @return
     */
    public String getMeno() {
        return meno;
    }

    /**
     * toString overrida metoda sluziaca na toString pomocny vypis mena hraca.
     * @return
     */
    @Override
    public String toString() {
        return "hrac: " + "\n\tmeno: " + meno;
    }
}
