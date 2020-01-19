import java.sql.SQLOutput;
import java.util.Scanner;

public class Piskvorky {

    private HraciePole hraciePole;
    private Scanner scanner = new Scanner(System.in);
    private Hrac[] hraci;
    private Hrac vitaz;

    public Piskvorky() {

        // ---------------------------------------- ZADAVANIE RIADKOV ----------------------------------------
        boolean velkostRiadky = false;
        int pocetRiadkov;
        do {
            System.out.println("Prosim zadajte pocet riadkov hracej plochy: (5 - 99)");

            pocetRiadkov = scanner.nextInt();

            // do 100 pretoze formatovanie vypisu je spravene len do 99 :D
            // nie je dorieseny scaling pri moc velkych hracich poliach
            if (pocetRiadkov < 5 || pocetRiadkov > 99) {
                System.out.println("Velkost plochy musi byt minimalne 5 a maximalne 99...");
                continue;
            }

            velkostRiadky = true;
        } while (!velkostRiadky);


        //  ------------------------------------- ZADAVANIE STLPCOV -------------------------------------------
        boolean velkostPolaStlpce = false;
        int pocetStlpcov;
        do {
            System.out.println("Prosim zadajte pocet stlpcov hracej plochy: (5 - 99)");

            pocetStlpcov = scanner.nextInt();

            // do 100 pretoze formatovanie vypisu je spravene len do 99 :D
            // nie je dorieseny scaling pri moc velkych hracich poliach
            if (pocetStlpcov < 5 || pocetStlpcov > 99) {
                System.out.println("Velkost plochy musi byt minimalne 5 a maximalne 99...");
                continue;
            }

            velkostPolaStlpce = true;
        } while (!velkostPolaStlpce);

        // VYTVORENIE hraciehoPola

        this.hraciePole = new HraciePole(pocetRiadkov, pocetStlpcov);


        //  -------------------------------------- VYTVARANIE HRACOV -------------------------------------------


        this.scanner.nextLine();
        this.hraci = new Hrac[2]; // Len dvaja hraci
        for (int i = 0; i < hraci.length; i++) {
            this.scanner.reset();

            // zadavanie mena hraca
            String menoHraca;
            System.out.println("Zadajte meno " + (i+1) + ". hraca s ktorym bude nasledne hrat: ");

            menoHraca = this.scanner.nextLine();


            // zadavanie znaku hraca
            char znakHraca;
            System.out.println("Zadajte znak " + (i+1) + ". hraca s ktorym bude nasledne hrat: ");

            // TODO opravit zadavanie medzery a inych neplatnych znakov...
            znakHraca = this.scanner.nextLine().charAt(0);



            this.hraci[i] = new Hrac(znakHraca, menoHraca);
        }

        System.out.println("Momentalni hraci: ");

        for (int i = 0; i < hraci.length; i++) {
            System.out.println((i+1) + ". " + this.hraci[i].toString());
        }



        //  ------------------------------------------ START HRY -----------------------------------------------

        //System.out.println("\f"); // blueJ STUFF
        System.out.println("Hra je pripravena, stlacte ENTER pre zacatie hry, zacina hrac: " + this.hraci[0].getMeno());

        this.scanner.nextLine();
        this.scanner.reset();

        boolean koniec = false;

        // zaciatok hry, resp. prveho kola,
        while (!koniec) {
            // kontrola ci uz sa nahodou nedohralo...
            if (kontrola()) {
                koniec = true;
                break;
            }

            this.hraciePole.vypis();
            System.out.println();
            int[] prvyHrac = new int[2];
            // prvyHrac[0] == riadok prveho hraca
            // prvyHrac[1] == stlpec prveho hraca
            int[] druhyHrac = new int[2];
            // druhyHrac[0] == riadok druheho hraca
            // druhyHrac[1] == stlpec druheho hraca


            // --------------------------- prvy hrac vybera riadok a stlpec ----------------------------
            boolean prvyHracKoniec = false;
            System.out.println(this.hraci[0].toString());

            // zaciatok tahu prveho hraca
            do {

                // zadavanie riadku prveho hraca
                boolean riadok = false;
                do {
                    System.out.println("Zadajte riadok: (1 - " + (this.hraciePole.getPocetRiadkov() - 1) + ")");

                    prvyHrac[0] = this.scanner.nextInt();

                    // kontrola ci hrac zadal spravny riadok, ak nie, ide naspat na zadavanie riadku
                    if (prvyHrac[0] < 1 || prvyHrac[0] >= this.hraciePole.getPocetRiadkov()) {
                        System.out.println("Prosim zadajte riadok z daneho rozsahu...");
                        continue;
                    }

                    riadok = true;
                } while (!riadok);


                // zadavanie stlpca prveho hraca
                boolean stlpec = false;
                do {
                    System.out.println("Zadajte stlpec: (1 - " + (this.hraciePole.getPocetStlpcov() - 1) + ")");

                    prvyHrac[1] = this.scanner.nextInt();

                    // kontrola ci hrac zadal spravny stlpec, ak nie, ide naspat na zadavanie stlpca
                    if (prvyHrac[1] < 1 || prvyHrac[1] >= this.hraciePole.getPocetStlpcov()) {
                        System.out.println("Prosim zadajte stlpec z daneho rozsahu...");
                        continue;
                    }

                    stlpec = true;
                } while (!stlpec);


                // kontrola ci uz sa na danom policku nieco nenachadza
                if (this.hraciePole.getPolicko(prvyHrac[0] -1, prvyHrac[1] - 1).getZnak() != ' ') {
                    System.out.println("Na danom policku sa uz nieco nachadza! Prosim zadajte nove...");
                    prvyHrac[0] = -1;
                    prvyHrac[1] = -1;
                    continue;
                }

                // nastavenie vybraneho policka znakom prveho hraca
                this.hraciePole.setPolicko(prvyHrac[0] - 1, prvyHrac[1] - 1, this.hraci[0].getZnak());

                prvyHracKoniec = true;
            } while(!prvyHracKoniec);


            // kontrola ci uz niekto vyhral, trebalo ju aj medzi tahmi hracov...
            if (kontrola()) {
                koniec = true;
                break;
            }

            this.hraciePole.vypis();

            // --------------------------- druhy hrac vybera riadok a stlpec ---------------------------
            boolean druhyHracKoniec = false;
            System.out.println();
            System.out.println(this.hraci[1].toString());

            // zaciatok tahu druheho hraca
            do {
                this.scanner.nextLine();
                this.scanner.reset();

                // vyberanie riadku druheho hraca
                boolean riadok = false;
                do {
                    System.out.println("Zadajte riadok: (1 - " + (this.hraciePole.getPocetRiadkov() - 1) + ")");

                    druhyHrac[0] = this.scanner.nextInt();

                    // kontrola ci hrac zadal spravny riadok, ak nie, ide naspat na zadavanie riadok
                    if (druhyHrac[0] < 1 || druhyHrac[0] >= this.hraciePole.getPocetRiadkov()) {
                        System.out.println("Prosim zadajte riadok z daneho rozsahu...");
                        continue;
                    }

                    riadok = true;
                } while (!riadok);


                // vyberanie stlpca druheho hraca
                boolean stlpec = false;
                do {
                    System.out.println("Zadajte stlpec: (1 - " + (this.hraciePole.getPocetStlpcov() - 1) + ")");

                    druhyHrac[1] = this.scanner.nextInt();

                    // kontrola ci hrac zadal spravny stlpec, ak nie, ide naspat na zadavanie stlpca
                    if (druhyHrac[1] < 1 || druhyHrac[1] >= this.hraciePole.getPocetStlpcov()) {
                        System.out.println("Prosim zadajte stlpec z daneho rozsahu...");
                        continue;
                    }

                    stlpec = true;
                } while (!stlpec);


                // kontrola ci nie je retardovany a nevybral nahodou rovnaku poziciu ako prvy hrac
                if ((prvyHrac[0] == druhyHrac[0] && prvyHrac[1] == druhyHrac[1])) {
                    System.out.println("Prosim vyberte inu poziciu ako je pozicia predosleho hraca...");
                }


                // kontrola ci uz sa nieco nenachadza na danom policku...
                // ak ano, vynuluje sa riadok a stlpec a hrac zadava nanovo
                if (this.hraciePole.getPolicko(druhyHrac[0] - 1, druhyHrac[1] - 1).getZnak() != ' ') {
                    System.out.println("Na danom policku sa uz nieco nachadza! Prosim zadajte nove...");
                    druhyHrac[0] = -1;
                    druhyHrac[1] = -1;
                    continue;
                }

                // nastavenie znaku po uspesnom zadani riadku a stlpca
                this.hraciePole.setPolicko(druhyHrac[0] - 1, druhyHrac[1] - 1, this.hraci[1].getZnak());

                druhyHracKoniec = true;
            } while(!druhyHracKoniec);
        }

        // akonahle kontrola vyhodnoti ze niekto vyhral, hra konci a vypise sa finalne hracie pole + vitaz
        System.out.println("\n");
        this.hraciePole.vypis();
        System.out.println("\nVitazom sa stava: " + this.vitaz.getMeno() + "!");
        System.out.println("Gratulujem!");
    }


    // TODO funguje len po riadkoch a stlpcoch
    public boolean kontrola() {

        // kontrola po stlpcoch
        for (int i = 0; i < this.hraci.length; i++) {
            int pocetZnakovZaSebou = 0;
            for (int j = 0; j < this.hraciePole.getPocetStlpcov(); j++) {
                for (int k = 0; k < this.hraciePole.getPocetRiadkov(); k++) {
                    if (this.hraci[i].getZnak() == this.hraciePole.getPolicko(j, k).getZnak()) {
                        pocetZnakovZaSebou++;
                        if (pocetZnakovZaSebou == 5) {
                            this.vitaz = this.hraci[i];
                            return true;
                        }
                    } else {
                        pocetZnakovZaSebou = 0;
                    }
                }
            }

            pocetZnakovZaSebou = 0;
            for (int j = 0; j < this.hraciePole.getPocetRiadkov(); j++) {
                for (int k = 0; k < this.hraciePole.getPocetStlpcov(); k++) {
                    if (this.hraci[i].getZnak() == this.hraciePole.getPolicko(j, k).getZnak()) {
                        pocetZnakovZaSebou++;
                        if (pocetZnakovZaSebou == 5) {
                            this.vitaz = this.hraci[i];
                            return true;
                        }
                    } else {
                        pocetZnakovZaSebou = 0;
                    }
                }
            }
        }


//        // TODO kontrola po diagnolach v oboch smeroch
//        // kontrola po diagonalach
//        for (int i = 0; i < this.hraci.length; i++) {
//            int pocetZnakovZaSebou = 0;
//            for (int j = 0; j < this.hraciePole.getPocetRiadkov(); j++) {
//                for (int k = 0; k < this.hraciePole.getPocetStlpcov(); k++) {
//                    if (this.hraci[i].getZnak() == this.hraciePole.getPolicko(j, k).getZnak()) {
//                        pocetZnakovZaSebou++;
//                        if (pocetZnakovZaSebou == 5) {
//                            this.vitaz = this.hraci[i];
//                            return true;
//                        }
//                    } else {
//                        pocetZnakovZaSebou = 0;
//                    }
//                }
//            }
//        }

        return false;
    }
}
