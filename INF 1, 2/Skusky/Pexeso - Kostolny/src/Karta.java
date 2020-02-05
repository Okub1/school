public class Karta {
    private char znacka;
    private int riadok;
    private int stlpec;
    private boolean otocena = false;
    private final char RUB = '#';


    public Karta(char znacka, int riadok, int stlpec) {
        this.znacka = znacka;
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    public void otoc() {
        this.otocena = !this.otocena;
    }

    public boolean tvoriPar(Karta druha) {
        return this.znacka == druha.znacka;
    }

    public boolean jeRub() {
        return !this.otocena;
    }

    public String naformatuj() {
        String pom = "";

        if (this.otocena) {
            pom = String.valueOf(this.znacka);
        } else {
            pom = String.valueOf(this.RUB);
        }

        return pom;
    }

    public int getRiadok() {
        return this.riadok;
    }

    public int getStlpec() {
        return this.stlpec;
    }
}
