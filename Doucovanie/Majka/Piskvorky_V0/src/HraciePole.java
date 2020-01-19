public class HraciePole {

    private Policko[][] policka;
    private int pocetRiadkov;
    private int pocetStlpcov;

    public HraciePole(int pocetRiadkov, int pocetStlpcov) {

        this.pocetRiadkov = pocetRiadkov + 1;
        this.pocetStlpcov = pocetStlpcov + 1;

        this.policka = new Policko[this.pocetRiadkov][this.pocetStlpcov];

        // naplni hracie pole medzerami (prazdne znaky)
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < this.pocetStlpcov; j++) {
                this.policka[i][j] = new Policko(' ');
            }
        }
    }


    // ziska policko na danom riadku a stlpci
    public Policko getPolicko(int riadok, int stlpec) {
        return this.policka[riadok][stlpec];
    }

    // nastavi dany znak policku na danom riadku a stlpci
    public void setPolicko(int riadok, int stlpec, char znak) {
        this.policka[riadok][stlpec].setZnak(znak);
    }


    // DEBUG ---------
    public void napln() {
        int a = 65;

        for (int i = 0; i < pocetRiadkov; i++) {
            for (int j = 0; j < pocetStlpcov - 1; j++) {
                this.policka[i][j].setZnak((char) a);
                a++;
            }
        }
    }

    public int getPocetRiadkov() {
        return pocetRiadkov;
    }

    public int getPocetStlpcov() {
        return pocetStlpcov;
    }

    // vypise cele hracie pole (vsetky policka)
    // (mega komplikovany vypis hracieho pola piskvoriek)
    public void vypis() {

        System.out.println();
        for (int i = 1; i <= this.pocetStlpcov ; i++) {
            System.out.print(i-1 + " | ");
        }

        System.out.println();
        for (int i = 0; i < this.pocetRiadkov; i++) {


            if (i == 0) {
                continue;
            }

            for (int j = 0; j < this.pocetStlpcov; j++) {
                System.out.print("--+-");
                if (j >= 9) {
                    System.out.print("-");
                }
            }
            System.out.println();

            System.out.print(i);

            for (int j = 0; j < this.pocetStlpcov; j++) {

                if (i < 10) {
                    System.out.print(" | ");
                } else {
                    System.out.print("|  ");
                }

                if (j >= 9) {
                    System.out.print(" ");
                }
                System.out.print(this.policka[i-1][j].getZnak());
            }
            System.out.println();
        }

        for (int j = 0; j < this.pocetStlpcov; j++) {
            System.out.print("--+-");
            if (j >= 9) {
                System.out.print("-");
            }
        }

        System.out.println();
    }
}
