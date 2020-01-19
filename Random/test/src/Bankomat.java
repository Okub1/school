public class Bankomat {

    int suma = 0;

    /**
     * Zadajte sumu bez centov, iba cele eura.
     * @param suma suma v eurach, bez centov...
     */
    public Bankomat(int suma) {
        this.suma = suma;
    }

    public void roztriedSumu() {
        int pocet500 = 0;
        int pocet200 = 0;
        int pocet100 = 0;
        int pocet50 = 0;
        int pocet20 = 0;
        int pocet10 = 0;
        int pocet5 = 0;
        int pocet2 = 0;
        int pocet1 = 0;

        while (suma >= 500) {
            pocet500++;
            suma -= 500;
        }

        while (suma >= 200) {
            pocet200++;
            suma -= 200;
        }

        while (suma >= 100) {
            pocet100++;
            suma -= 100;
        }

        while (suma >= 50) {
            pocet50++;
            suma -= 50;
        }

        while (suma >= 20) {
            pocet20++;
            suma -= 20;
        }

        while (suma >= 10) {
            pocet10++;
            suma -= 10;
        }

        while (suma >= 5) {
            pocet5++;
            suma -= 5;
        }

        while (suma >= 2) {
            pocet2++;
            suma -= 2;
        }

        while (suma >= 1) {
            pocet1++;
            suma -= 1;
        }

        System.out.println(
                "\nPocet 500€: \t" + pocet500 +
                "\nPocet 200€: \t" + pocet200 +
                "\nPocet 100€: \t" + pocet100 +
                "\nPocet 50€: \t\t" + pocet50 +
                "\nPocet 20€: \t\t" + pocet20 +
                "\nPocet 10€: \t\t" + pocet10 +
                "\nPocet 5€: \t\t" + pocet5 +
                "\nPocet 2€: \t\t" + pocet2 +
                "\nPocet 1€: \t\t" + pocet1
        );
    }

    public int getSuma() {
        return suma;
    }
}
