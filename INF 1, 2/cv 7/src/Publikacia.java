public class Publikacia {

    private String nazov;
    private int rok;

    public Publikacia(String nazov, int rok) {
    this.nazov = nazov;
    this.rok = rok;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String toString() {
        return "Publikacia\n\tNazov: " + this.nazov + "\n\tRok vydania: " + this.rok + "\n";
    }
}
