public class Bankomat3 {

    int suma = 0;

    public Bankomat3(double suma) {
        this.suma = (int) Math.round(suma*100);
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
        int pocet0_5 = 0;
        int pocet0_2 = 0;
        int pocet0_1 = 0;
        int pocet0_05 = 0;
        int pocet0_02 = 0;
        int pocet0_01 = 0;

        while (suma >= 50000) {
            pocet500++;
            suma -= 50000;
        }

        while (suma >= 20000) {
            pocet200++;
            suma -= 20000;
        }

        while (suma >= 10000) {
            pocet100++;
            suma -= 10000;
        }

        while (suma >= 5000) {
            pocet50++;
            suma -= 5000;
        }

        while (suma >= 2000) {
            pocet20++;
            suma -= 2000;
        }

        while (suma >= 1000) {
            pocet10++;
            suma -= 1000;
        }

        while (suma >= 500) {
            pocet5++;
            suma -= 500;
        }

        while (suma >= 200) {
            pocet2++;
            suma -= 200;
        }

        while (suma >= 100) {
            pocet1++;
            suma -= 100;
        }

        while (suma >= 50) {
            pocet0_5++;
            suma -= 50;
        }

        while (suma >= 20) {
            pocet0_2++;
            suma -= 20;
        }

        while (suma >= 10) {
            pocet0_1++;
            suma -= 10;
        }

        while (suma >= 5) {
            pocet0_05++;
            suma -= 5;
        }

        while (suma >= 2) {
            pocet0_02++;
            suma -= 2;
        }

        while (suma >= 1) {
            pocet0_01++;
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
                        "\nPocet 1€: \t\t" + pocet1 +
                        "\nPocet 0,50€: \t" + pocet0_5 +
                        "\nPocet 0,20€: \t" + pocet0_2 +
                        "\nPocet 0,10€: \t" + pocet0_1 +
                        "\nPocet 0,05€: \t" + pocet0_05 +
                        "\nPocet 0,02€: \t" + pocet0_02 +
                        "\nPocet 0,01€: \t" + pocet0_01
        );
    }

    public int getSuma() {
        return suma;
    }
}
