import java.util.Scanner;
import java.util.Random;

/**
 * Trieda obsahujuca hru a kompletnu logiku celej hry
 */
public class Lodicky {

    private Hrac[] hraci = new Hrac[2];
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private final char ZNAK_LODIEK = 'X';
    private final int POCET_LODICIEK = 10;


    /**
     * Samotna hra a logika hry lodicky
     *
     * Zaciatok:
     *  - zadavanie riadkov a stlpcov (kymkolvek, ci uz hrac1 alebo 2)
     *
     *  - vytvorenie "profilov" hracov - zadanie mien hraca 1/2
     *
     *  - vygenerovanie lodiciek do pola (lodky nikto neuvidi)
     *
     *  - nasledny zaciatok hry, postupne striedanie sa hracov
     *    az kym jeden z hracov neznici vsetky lodicky druheho hraca
     */
    public Lodicky() {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~ zadavanie riadkov ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        boolean velkostRiadky = false;
        int pocetRiadkov;
        do {
            System.out.println("Prosim zadajte pocet riadkov hracej plochy: (5 - 9)");

            pocetRiadkov = scanner.nextInt();

            // nie je dorieseny scaling pri moc velkych hracich poliach
            if (pocetRiadkov < 5 || pocetRiadkov > 9) {
                System.out.println("Velkost plochy musi byt minimalne 5 a maximalne 9...");
                continue;
            }

            velkostRiadky = true;
        } while (!velkostRiadky);


        // ~~~~~~~~~~~~~~~~~~~~~~~~~~ zadavanie stlpcov ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        boolean velkostPolaStlpce = false;
        int pocetStlpcov;
        do {
            System.out.println("Prosim zadajte pocet stlpcov hracej plochy: (5 - 9)");

            pocetStlpcov = scanner.nextInt();

            // nie je dorieseny scaling pri moc velkych hracich poliach
            if (pocetStlpcov < 5 || pocetStlpcov > 9) {
                System.out.println("Velkost plochy musi byt minimalne 5 a maximalne 9...");
                continue;
            }

            velkostPolaStlpce = true;
        } while (!velkostPolaStlpce);


        final int VELKOST_POLI_RIADKY = pocetRiadkov + 1;
        final int VELKOST_POLI_STLPCE = pocetStlpcov + 1;


        // ~~~~~~~~~~~~~~~~~~~~~~~~~~ vytvorenie hracov (mena) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        this.scanner.nextLine();
        this.hraci = new Hrac[2]; // Len dvaja hraci
        for (int i = 0; i < hraci.length; i++) {
            this.scanner.reset();

            // zadavanie mena hraca
            String menoHraca;
            System.out.println("Zadajte meno " + (i+1) + ". hraca s ktorym bude nasledne hrat: ");

            menoHraca = this.scanner.nextLine();

            this.hraci[i] = new Hrac(menoHraca);
            this.hraci[i].setHraciePole(new HraciePole(VELKOST_POLI_RIADKY, VELKOST_POLI_STLPCE));
        }

        System.out.println("Momentalni hraci: ");

        for (int i = 0; i < this.hraci.length; i++) {
            System.out.println((i+1) + ". " + this.hraci[i].toString());
        }

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ SET UP lodiek ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // nahodne rozmiestnenie lodiciek
        for (Hrac hrac : this.hraci) {
            Policko[][] policka = hrac.getHraciePole().getHraciePole();
            for (int j = 0; j < this.POCET_LODICIEK; j++) {
                int nahodnyRiadok = this.random.nextInt(hrac.getHraciePole().getRiadky()-1);
                int nahodnyStlpec = this.random.nextInt(hrac.getHraciePole().getStlpce()-1);

                if (policka[nahodnyRiadok][nahodnyStlpec].vypis() == ' ') {
                    policka[nahodnyRiadok][nahodnyStlpec].setZnak(this.ZNAK_LODIEK);
                } else {
                    j--;
                }
            }
        }

        // DEBUG - vypis lodiciek
//        for (int i = 0; i < this.hraci.length; i++) {
//            System.out.println((i+1) + ". " + this.hraci[i].toString());
//            this.hraci[i].getHraciePole().vypis();
//        }

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Zaciatok hry ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        System.out.println("\fZaciatok hry Lodicky!");

        // postupne tahy hracov
        boolean koniec = false;
        while (!koniec) {

            for (int i = 0; i < this.hraci.length; i++) {
                System.out.println("Na tahu je hrac: " + this.hraci[i].getMeno());

                this.hraci[(i+1)%2].getHraciePole().vypis();

                int[] suradniceZasahu = vyberRiadkuAStlpca(this.hraci[(i+1)%2].getHraciePole());

                // ten druhy hrac


                    Policko[][] hraciePole = this.hraci[(i+1)%2].getHraciePole().getHraciePole();

                    int riadok = suradniceZasahu[0];
                    int stlpec = suradniceZasahu[1];

                    char znak = this.hraci[(i+1)%2].getHraciePole().getHraciePole()[riadok][stlpec].getZnak();

                    if (znak == ZNAK_LODIEK && !hraciePole[riadok][stlpec].isZasiahnute()) {
                        hraciePole[riadok][stlpec].zasiahni();
                        System.out.println("Zasah!");
                        i--;
                        continue;
                    } else if (hraciePole[riadok][stlpec].isOdhalene()) {
                        System.out.println("Toto miesto uz bolo zasiahnute!");
                        i--;
                        continue;
                    } else {
                        hraciePole[riadok][stlpec].odhal();
                        System.out.println("Tesne...");
                    }



                this.hraci[(i+1)%2].getHraciePole().vypis();
            }

            System.out.println("--------------------------------- DALSIE KOLO ---------------------------------");

            for (Hrac hrac : this.hraci) {
                if (kontrolaCiHracDohral(hrac)) {
                    System.out.println("Hrac " + hrac.getMeno() + " prehral! stratil vsetky lode!");
                    koniec = true;
                }
            }
        }


    }


    /**
     * Pomocna metoda na vyber riadku a stlpca pre setrenie miesta v cykle na spracovanie tahov hracov.
     *
     * @return pole int kde [0] = riadok a [1] = stlpec
     */
    private int[] vyberRiadkuAStlpca(HraciePole hraciePole) {
        int[] pozicia = new int[2];
        // pozicia[0] = vybraty riadok hracom
        // pozicia[0] = vybraty stlpec hracom


        // ~~~~~~~~~~~~~~~~~~~~~~~~~~ Vyber riadku ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        boolean velkostRiadky = false;
        int riadok;
        do {
            System.out.println("Vyberte riadok: (1 - " + (hraciePole.getRiadky() - 1) + ")");

            riadok = scanner.nextInt();

            // nie je dorieseny scaling pri moc velkych hracich poliach
            if (riadok < 1 || riadok > hraciePole.getRiadky() - 1) {
                System.out.println("Riadok moze byt len z rozsahu: minimalne 5 a maximalne " + (hraciePole.getStlpce() - 1) + "...");
                continue;
            }

            velkostRiadky = true;
        } while (!velkostRiadky);


        // ~~~~~~~~~~~~~~~~~~~~~~~~~~ Vyber stlpca ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        boolean velkostPolaStlpce = false;
        int stlpec;
        do {
            System.out.println("Vyberte stlpec: (1 - " + (hraciePole.getStlpce() - 1) + ")");

            stlpec = scanner.nextInt();

            // nie je dorieseny scaling pri moc velkych hracich poliach
            if (stlpec < 1 || stlpec > hraciePole.getStlpce() - 1) {
                System.out.println("Stlpec moze byt len z rozsahu: minimalne 1 a maximalne " + (hraciePole.getStlpce() - 1) + "...");
                continue;
            }

            velkostPolaStlpce = true;
        } while (!velkostPolaStlpce);

        // VYTVORENIE hraciehoPola

        pozicia[0] = riadok-1;
        pozicia[1] = stlpec-1;

        return pozicia;
    }


    /**
     * Jednoducha kontrola daneho hraca ci uz dohral alebo nie.
     *
     * Kontroluje hracie pole hraca, a pokial najde taku lodku,
     * pridava do pocitadla zasiahnutych lodiek, ak je pocet
     * zasiahnutych lodiek rovny celkovemu poctu lodiek,
     * algoritmus to vyhodnoti ako prehru, a vrati true.
     *
     * @param hrac - kontrolovany hrac
     * @return true ak prehral
     *         false ak este neprehral
     */
    private boolean kontrolaCiHracDohral(Hrac hrac) {
        Policko[][] hraciePole = hrac.getHraciePole().getHraciePole();
        int riadky = hrac.getHraciePole().getRiadky();
        int stlpce = hrac.getHraciePole().getStlpce();
        int zasiahnute = 0;

        for (int i = 0; i < riadky; i++) {
            for (int j = 0; j < stlpce; j++) {
                if (hraciePole[i][j].vypis() == ZNAK_LODIEK && hraciePole[i][j].isZasiahnute()) {
                    zasiahnute++;
                }
            }
        }

        return zasiahnute >= this.POCET_LODICIEK;
    }
}
