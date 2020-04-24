/**
 * Pomocna trieda umoznujuca menit stavy policiek v hracom poli
 */
public class Policko {

    private char znak; //lod
    private boolean zasiahnute = false;
    private boolean odhalene = false;

    public Policko(char znak) {
        this.znak = znak;
    }

    /**
     * metoda umoznujuca rozne vypisy (return) podla stavu policka
     * v pripade ze je na tomto policku lodka, vypise sa
     * znak lodky,
     * ak nie je, vypise sa '-'
     * @return char
     */
    public char vypis() {

        if (this.odhalene) {
            return '-';
        } else if (this.zasiahnute) {
            return this.znak;
        } else {
            return ' ';
        }
    }

    /**
     * metoda sluziaca na ziskanie konkretneho znaku na
     * tomto policku. ak je tu lodicka, vrati jej znak
     * ak tu nie je lodicka, vrati medzeru ' '
     * @return
     */
    public char getZnak() {
        return this.znak;
    }

    /**
     * metoda sluziaca na overenie stavu - ci je
     * lodicka zasiahnuta
     * @return stav lodicky na policku
     */
    public boolean isZasiahnute() {
        return zasiahnute;
    }

    /**
     * metoda sluziaca na zmenu stavu zasiahnutia
     */
    public void zasiahni() {
        this.zasiahnute = true;
    }

    /**
     * metoda sluziaca na zistenie stavu odhalenia
     * policka.
     * @return odhalenie
     */
    public boolean isOdhalene() {
        return this.odhalene;
    }

    /**
     * metoda sluziaca na zmenu stavu odhalenia
     */
    public void odhal() {
        this.odhalene = true;
    }

    /**
     * Nastavi znak na znak lode (napriklad L)
     * @param znak zadavany znak reprezentujuci lod
     */
    public void setZnak(char znak) {
        this.znak = znak;
    }
}
