public class Pexeso {
    private HraciePole hraciePole;
    private boolean prva = true;
    private Karta[] karty;

    public Pexeso() {
        this.hraciePole = new HraciePole();
        karty = new Karta[2];
    }

    public void otocKartu(int riadok, int stlpec) {
        if (riadok > 7 || stlpec > 7) {
            System.out.println("Zla pozicia");
            return;
        }

        if (this.hraciePole.getKarta(riadok, stlpec) != null && this.hraciePole.getKarta(riadok, stlpec).jeRub()) {
            if (this.prva) {
                System.out.println("Prva karta");

                this.karty[0] = this.hraciePole.getKarta(riadok, stlpec);
                this.hraciePole.getKarta(riadok, stlpec).otoc();

                System.out.println(this.hraciePole.getKarta(riadok, stlpec).naformatuj());

                this.prva = false;
            } else {
                this.karty[1] = this.hraciePole.getKarta(riadok, stlpec);

                if (this.karty[0] == this.karty[1]) {
                    System.out.println("Chyba");
                    this.karty[0].otoc();
                    this.karty[1].otoc();

                    this.karty[0] = null;
                    this.karty[1] = null;
                    return;
                }

                this.hraciePole.getKarta(riadok, stlpec).otoc();
                System.out.println(this.hraciePole.getKarta(riadok, stlpec).naformatuj());

                if (this.karty[0].tvoriPar(this.karty[1])) {
                    System.out.println("Uspech");
                    this.hraciePole.odstran(this.karty);
                    this.karty[0] = null;
                    this.karty[1] = null;
                } else {
                    System.out.println("Neuspech");
                    this.karty[0].otoc();
                    this.karty[1].otoc();

                    this.karty[0] = null;
                    this.karty[1] = null;
                }

                this.prva = true;
            }
            if (this.hraciePole.jePrazdne()) {
                System.out.println("Hracie Pole je prazdne, YOU WIN!");
                System.exit(0);
            }

            this.hraciePole.vypis();
        } else {
            System.out.println("Chyba. (karta je otočená alebo ostranena");
        }
    }
}
