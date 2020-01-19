import java.util.Scanner;

public class Piskvorky {

    private int pocetHracov;
    private Hrac[] hraci;
    private HraciePole hraciePole;
    private Scanner scanner = new Scanner(System.in);

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

        //  ------------------------------------- ZADAVANIE POCTU HRACOV ---------------------------------------
        boolean zadatHracov = false;
        int pocetHracov = 2;
        do {
            if ((this.hraciePole.getHraciePole().length/5)+1 == 2) {
                System.out.println("Hracie pole je prilis male pre viac ako dvoch hracov, " +
                                   "\n preto bude nastaveny pocet hracov na 2." );
            } else {
                System.out.println("Prosim zadajte pocet hracov: (2 - " + ((this.hraciePole.getHraciePole().length/5)+1) + ")");
                pocetHracov = scanner.nextInt();
            }


            if (pocetHracov < 2 || pocetHracov > (this.hraciePole.getHraciePole().length/5)+1) {
                System.out.println("Zly pocet hracov, je potreba aspon dvoch hracov a nanajvys " + ((this.hraciePole.getHraciePole().length/5)+1) );
                continue;
            }

            zadatHracov = true;
        } while (!zadatHracov);


        //  -------------------------------------- VYTVARANIE HRACOV -------------------------------------------


        this.scanner.nextLine();
        this.hraci = new Hrac[pocetHracov];
        for (int i = 0; i < pocetHracov; i++) {
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

        for (int i = 0; i < pocetHracov; i++) {
            System.out.println((i+1) + ". " + this.hraci[i].toString());
        }



        //  ------------------------------------------ START HRY -----------------------------------------------

        //System.out.println("\f"); // blueJ STUFF
        System.out.println("Hra je pripravena, stlacte ENTER pre zacatie hry, zacina prvy zadany hrac");

        this.scanner.nextLine();
        this.scanner.reset();

        this.hraciePole.vypis();




    }


    // kontrola ci uz je dohrate
    public boolean koniecHry () {


        // kontrola po stlpcoch
        for (int i = 0; i < this.hraci.length; i++) {
            int pocetZnakovZaSebou = 0;
            for (int j = 0; j < this.hraciePole.getPocetStlpcov(); j++) {
                for (int k = 0; k < this.hraciePole.getPocetRiadkov(); k++) {
                    if (this.hraci[i].getZnakHraca() == this.hraciePole.getPolicko(j, k).getZnak()) {
                        pocetZnakovZaSebou++;
                        if (pocetZnakovZaSebou == 5) {
                            return true;
                        }
                    } else {
                        pocetZnakovZaSebou = 0;
                    }
                }
            }
        }

        // kontrola po riadkoch
        for (int i = 0; i < this.hraci.length; i++) {
            int pocetZnakovZaSebou = 0;
            for (int j = 0; j < this.hraciePole.getPocetRiadkov(); j++) {
                for (int k = 0; k < this.hraciePole.getPocetStlpcov(); k++) {
                    if (this.hraci[i].getZnakHraca() == this.hraciePole.getPolicko(j, k).getZnak()) {
                        pocetZnakovZaSebou++;
                        if (pocetZnakovZaSebou == 5) {
                            return true;
                        }
                    } else {
                        pocetZnakovZaSebou = 0;
                    }
                }
            }
        }

        // TODO kontrola po diagnolach v oboch smeroch
        // kontrola po diagonalach
        for (int i = 0; i < this.hraci.length; i++) {
            int pocetZnakovZaSebou = 0;
            for (int j = 0; j < this.hraciePole.getPocetRiadkov(); j++) {
                for (int k = 0; k < this.hraciePole.getPocetStlpcov(); k++) {
                    if (this.hraci[i].getZnakHraca() == this.hraciePole.getPolicko(j, k).getZnak()) {
                        pocetZnakovZaSebou++;
                        if (pocetZnakovZaSebou == 5) {
                            return true;
                        }
                    } else {
                        pocetZnakovZaSebou = 0;
                    }
                }
            }
        }


        return false;
    }
}
