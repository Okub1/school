public class Karta {
    private char znak;
    private boolean otocena = false;

    public Karta(char znak) {
        this.znak = znak;
    }

    // vypise kartu
    // ak je karta otocena znakom hore, zobrazi znak
    // ak je karta otocena zadnou stranou, zobrazi #
    public char getZnak() {
        if (this.otocena) {
            return this.znak;
        } else {
            return '#';
        }
    }

    // nepotrebne, zatial
    public void setZnak(char znak) {
        this.znak = znak;
    }

    // test ci karty tvoria spolu par
    // vrati TRUE ak tvoria par
    // vrati FALSE ak netvoria par
    public boolean tvoriPar(Karta karta) {
        return this.znak == karta.getZnak();
    }

    // jednoducha negacia booleanu
    // ak je karta otocena, otoci ju na druhu stranu :D
    public void otocKartu() {
        this.otocena = !this.otocena;
    }
}
