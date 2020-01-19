import java.util.Scanner;

public class Pexeso {

    private HraciePole hraciePole;
    private Scanner scanner = new Scanner(System.in);

    public Pexeso() {

        boolean koniec = false;
        int riadky;
        int stlpce;

        System.out.println("\fZadajte velkost pexesa.");
        do {
            System.out.println("Podmienky: aspon jeden paramter parny, a obidva parametre vacsie ako nula...");
            System.out.println("\nZadajte riadky: ");
            riadky = this.scanner.nextInt();
            System.out.println("Zadajte stlpce: ");
            stlpce = this.scanner.nextInt();

            if ((riadky * stlpce)% 2 == 0 && (riadky*stlpce) > 0) {
                koniec = true;
            }

        } while (!koniec);

        System.out.println("Pocet riadkov: " + riadky);
        System.out.println("Pocet stlpcov: " + stlpce);

        this.hraciePole = new HraciePole(riadky, stlpce);

        this.hraciePole.vypisPole();


        // tu bude zaciatok cyklu

        // v cykle bude hned na zaciatku kontrola ci je hraciePole prazdne (vyriesene)

        while (!this.hraciePole.jeHraciePolePrazdne()) {

            // vyber prvej karty:
            boolean prvaKartaSpravna = false;
            int[] prvaKarta;
            do {
                System.out.println("\nVyberte prvu kartu: ");
                prvaKarta = vyberRiadkuAStlpca(riadky, stlpce);

                if (this.hraciePole.getKarta(prvaKarta[0], prvaKarta[1]).getZnak() == ' ') {
                    System.out.println("Vyberte kartu, ktora nie je prazdna...");
                    System.out.println();
                    this.hraciePole.vypisPole();
                    System.out.println();
                    continue;
                }

                prvaKartaSpravna = true;
                this.hraciePole.getKarta(prvaKarta[0], prvaKarta[1]).otocKartu();
            } while (!prvaKartaSpravna);


            System.out.println();
            this.hraciePole.vypisPole();
            System.out.println();


            // vyber druhej karty:

            int[] druhaKarta;

            // kontrola zhody s prvou kartou, ci uzivatel nevybral tu istu ako prvu (tie iste pozicie)
            boolean druhaKartaKoniec = false;
            do {
                System.out.println("Vyberte druhu kartu: ");
                druhaKarta = vyberRiadkuAStlpca(riadky, stlpce);

                if (druhaKarta[0] == prvaKarta[0] && druhaKarta[1] == prvaKarta[1] ) {
                    System.out.println("Vyber druhej karty sa zhoduje s prvou.");
                    continue;
                }

                if (this.hraciePole.getKarta(druhaKarta[0], druhaKarta[1]).getZnak() == ' ') {
                    System.out.println("Vyberte kartu, ktora nie je prazdna...");
                    System.out.println();
                    this.hraciePole.vypisPole();
                    System.out.println();
                    continue;
                }


                druhaKartaKoniec = true;
            } while (!druhaKartaKoniec);
            this.hraciePole.getKarta(druhaKarta[0], druhaKarta[1]).otocKartu();


            System.out.println();
            this.hraciePole.vypisPole();
            System.out.println();



            // logika hry

            Karta karta1 = this.hraciePole.getKarta(prvaKarta[0], prvaKarta[1]);
            Karta karta2 = this.hraciePole.getKarta(druhaKarta[0], druhaKarta[1]);


            if (karta1.tvoriPar(karta2)) {
                System.out.println("Zhoda!");
                karta1.setZnak(' ');
                karta2.setZnak(' ');
            } else {
                System.out.println("Nezhoda...");
                karta1.otocKartu();
                karta2.otocKartu();
            }


            this.hraciePole.vypisPole();
        }

        System.out.println("\n\n Gratulujem k vyhre! :)");

        // kontrola ci tvoria par


//        System.out.println(riadok);
//        System.out.println(stlpec);
    }

    private int[] vyberRiadkuAStlpca(int riadky, int stlpce) {
        int[] riadkyAStlpce = new int[2];

        boolean koniec = false;

        int riadok = -1;
        int stlpec = -1;

        do {
            System.out.println("Zadajte riadok: " + "(1 - " + riadky + ")");
            riadok = this.scanner.nextInt();

            if (riadok > riadky || riadok < 1) {
                continue;
            }

            System.out.println("Zadajte stlpec: " + "(1 - " + stlpce + ")");
            stlpec = this.scanner.nextInt();

            if (stlpec > stlpce || stlpec < 1) {
                continue;
            }

            riadkyAStlpce[0] = riadok - 1;
            riadkyAStlpce[1] = stlpec - 1;

            koniec = true;
        } while (!koniec);

        return riadkyAStlpce;
    }
}
