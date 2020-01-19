public class HraciePole {
    private Policko[][] hraciePole;
    private int pocetRiadkov;
    private int pocetStlpcov;

    public HraciePole(int pocetRiadkov, int pocetStlpcov) {
        this.pocetRiadkov = pocetRiadkov + 1;
        this.pocetStlpcov = pocetStlpcov + 1;

        this.hraciePole = new Policko[this.pocetRiadkov][this.pocetStlpcov];

        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < this.pocetStlpcov; j++) {
                this.hraciePole[i][j] = new Policko();
            }
        }
    }


    public Policko getPolicko(int riadok, int stlpec) {
        return this.hraciePole[riadok-1][stlpec-1];
    }



    // TODO OPRAVIT ZADAVANIE CISEL!!
    // ZADAVAT CISLA OD 1 DO POCET STLPCOV (vratane)
    public void setPolicko(int riadok, int stlpec, Hrac hrac) {
        this.hraciePole[riadok][stlpec].setZnak(hrac.getZnakHraca());
    }


    public Policko[][] getHraciePole() {
        return hraciePole;
    }

    public int getPocetRiadkov() {
        return pocetRiadkov;
    }

    public int getPocetStlpcov() {
        return pocetStlpcov;
    }

    // mega komplikovany vypis hracieho pola piskvoriek
    public void vypis() {

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
                System.out.print(this.hraciePole[i-1][j].getZnak());
            }
            System.out.println();
        }

        for (int j = 0; j < this.pocetStlpcov; j++) {
            System.out.print("--+-");
            if (j >= 9) {
                System.out.print("-");
            }
        }
    }
}
