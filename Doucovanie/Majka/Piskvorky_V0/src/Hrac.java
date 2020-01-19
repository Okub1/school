public class Hrac {
    private char znak;
    private String meno;

    public Hrac(char znak, String meno) {
        this.znak = znak;
        this.meno = meno;
    }

    public char getZnak() {
        return znak;
    }

    public void setZnak(char znak) {
        this.znak = znak;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    @Override
    public String toString() {
        return "Hrac: "
                + "\n\tMeno: " + this.meno
                + "\n\tZnak: " + this.znak;
    }
}
