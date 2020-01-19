public class Hrac {
    char znakHraca;
    String meno;

    public Hrac(char znakHraca, String meno) {
        this.znakHraca = znakHraca;
        this.meno = meno;
    }

    public char getZnakHraca() {
        return znakHraca;
    }

    public void setZnakHraca(char znakHraca) {
        this.znakHraca = znakHraca;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String toString() {
        return "Hrac: \n\tMeno: " + this.meno + "\n\tznak: " + this.znakHraca;
    }
}
