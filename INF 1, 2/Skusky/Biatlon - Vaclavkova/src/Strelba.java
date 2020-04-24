import java.util.Arrays;

public class Strelba {
    private int pocetVsetkychTercov;
    private int pocetZasahov;
    private char[] terce;
    private final char ZASAH = 'X';
    private final char VEDLA = '-';

    public Strelba(int paPocetVsetkychTercov) {
        this.pocetVsetkychTercov = paPocetVsetkychTercov;
        this.terce = new char[paPocetVsetkychTercov];

        Arrays.fill(this.terce, this.VEDLA);
    }

    public int dajPocetTercov() {
        return this.pocetVsetkychTercov;
    }

    public int dajPocetZasahov() {
        return this.pocetZasahov;
    }

    public int dajPocetNetrafenych() {
        return this.pocetVsetkychTercov - this.pocetZasahov;
    }

    public boolean vlozZasah(int paPozicia) {
        paPozicia -= 1;
        if (this.terce[paPozicia] == this.ZASAH) {
            return false;
        } else {
            this.terce[paPozicia] = this.ZASAH;
            return true;
        }
    }

    public String toString() {
        String pom = "";

        for (int i = 0; i < this.terce.length; i++) {
            pom += terce[i] + " ";
        }

        return "Hodnoty: " + pom;
    }
}
