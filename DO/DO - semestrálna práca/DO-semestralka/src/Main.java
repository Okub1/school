import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    /**
     * Atribut maximalnej kapacity zadany zadanim heuristiky.
     */
    private static final int kapacita = 15000;
    /**
     * Atribut maximalneho poctu predmetov zadany zadanim heuristiky.
     */
    private static final int pocetPredemtov = 300;
    /**
     * Ucelova funkcia (ceny) zadania, nacitana zo suboru H6_c.txt.
     */
    private static int[] ceny;
    /**
     * Strukturalne podmienky (hmotnosti) zadania, nacitana zo suboru H6_a.txt.
     */
    private static int[] hmot;
    /**
     * Pomocne pole riesenie, v ktorom sa definuje ci je alebo nie je predmet v batohu.
     */
    private static boolean[] ries;


    /**
     * Trieda main, ktora obsahuje takmer cely algoritmus heuristiky
     * @throws IOException - vyhodi vynimku v pripade ze subor neexistuje alebo nebol otvoreny spravne
     */
    public static void main(String[] args) throws IOException {

        //Nacitanie hodnot zo zadanych suborov cez pomocnu triedu na spracovanie suborov
        FileManager h6_ceny      = new FileManager("vstupne subory/H6_c.txt");
        FileManager h6_hmotnosti = new FileManager("vstupne subory/H6_a.txt");


        // pomocne vypisy v pripade debugu
        /*
         * ~~~~~~~~~~~~~~~~~~DEBUG~~~~~~~~~~~~~~~~~~
         */
//        h6_ceny.print();
//        System.out.println("\n" + h6_ceny.getMatrix().length);

//        h6_hmotnosti.print();
//        System.out.println("\n" + h6_hmotnosti.getMatrix().length);
        /*
          ~~~~~~~~~~~~~~~~~~DEBUG~~~~~~~~~~~~~~~~~~
         */


        //nacitane polia zo suborov premenovane na zrozumitelnejsi zapis v kode
        ceny = h6_ceny.getMatrix();
        hmot = h6_hmotnosti.getMatrix();


        //inicializacia pola koeficientov vyhodnosti
        double[] koeficientyVyhodnosti = new double[ceny.length];


        //vypocet vsetkych koeficientov vyhodnosti (pomery ceny a hmotnosti)
        for (int i = 0; i < koeficientyVyhodnosti.length; i++) {
            koeficientyVyhodnosti[i] = (double) ceny[i]/hmot[i];
        }


        //nacitanie koeficientov vyhodnosti do struktury TreeMap pre lahsie usporiadanie a indexovanie prvkov
        TreeMap<Integer,Double> koeficientVyhodnosti = new TreeMap<>();

        for (int i = 0; i < koeficientyVyhodnosti.length; i++) {
            koeficientVyhodnosti.put(i + 1, koeficientyVyhodnosti[i]);
        }


        //usporiadanie koeficientov vyhodnosti od najmensieho po najvacsi do struktury,
        // z ktorej budeme nasledne vyberat prvky
        LinkedList<Map.Entry<Integer, Double>> usporiadane = new LinkedList<>(koeficientVyhodnosti.entrySet());
        Comparator<Map.Entry<Integer, Double>> comparator = Comparator.comparing(Map.Entry::getValue);
        usporiadane.sort(comparator); //comparator.reversed() pre opacne usporiadanie


//        // vypis usporiadanych koeficientov vyhodnosti
//        for (Map.Entry<Integer, Double> integerDoubleEntry : usporiadane) {
//            System.out.println(integerDoubleEntry);
//        }


        //inicializacia pola v ktorom budu ulozene iba true/false ako ci bol alebo nebol predmet vlozeny do batohu
        ries = new boolean[ceny.length];


        //nastavenie vsetkych predmetov ako vlozene kvoli zadaniu dualnej heuristiky
        for (int i = 0; i < ries.length; i++) {
            ries[i] = true;
        }


        //nastavenie plneho batohu
        int celkovyPocetPredmetov = 500;


        //nastavenie celkovej hmotnosti plneho batohu (suma vsetkych hmotnosti vsetkych predmetov)
        int celkovaHmotnost = 0;
        for (int value : hmot) {
            celkovaHmotnost += value;
        }


        //vypis hmotnosti plneho batohu pred heuristikou
        System.out.println("\nHmotnost pred: \t" + celkovaHmotnost);


        //samotny algoritmus heuristiky:
        // Postupne vybera predmety podla koeficientu vyhodnosti az pokym nebude v pripustnom stave:
        // (kapacita = 15000 >= hmotnost batohu && maximalny pocet predmetov = 300 >= pocet predmetov)
        //
        // Jednoduchsi zapis algoritmu:
        // kapacita = 15000 (zo zadania), maximalny pocet predmetov (pocetPredmetov) = 300 (zo zadania)
        // podmienka zadania:
        //                     kapacita >= hmotnost batoha
        //                     maximalny pocet predmetov >= pocet predmetov v batohu
        // podmienka algoritmu:
        //                     odoberaj prvky, pokial si v nepripustnom rieseni
        //                     (ked je kapacita mensia ako hmotnost batoha
        //                     alebo maximalny pocet predmetov je mensi ako pocet predmetov v batohu)

        // pokial je tato podmienka splnena, odobere sa z batohu predmet, a znizi sa pocet predmetov v batohu
        // koeficient daneho predmetu vyhodnosti sa nastavi v poli riesinia ako false == bol odobraty
        // a zaroven sa odoberie z usporiadanych koeficientov vyhodnosti aby sa s nim uz dalej neratalo
        while (kapacita < celkovaHmotnost || pocetPredemtov < celkovyPocetPredmetov) {
            celkovaHmotnost -= hmot[usporiadane.get(0).getKey() - 1];
            celkovyPocetPredmetov--;

            ries[usporiadane.get(0).getKey() - 1] = false;
            usporiadane.remove(0);
        }


        System.out.println("\nVysledna hmotnost: \t" + celkovaHmotnost + "\nPocet predmetov: \t" + celkovyPocetPredmetov);


        //inicializacia ucelovej funkcie
        int ucelovaFunkcia = 0;


        //vypocet ucelovej funkcie
        for (int i = 0; i < ceny.length; i++) {
            if (ries[i]) {
                ucelovaFunkcia += ceny[i];
            }
        }

        //vypis ucelovej funkcie
        System.out.println("Hodnota ucelovej funkcie: \t" + ucelovaFunkcia);


        //vypis riesenia do suboru:
        FileWriter fileWriter = new FileWriter("vystupne subory/vystup.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(
                "Hodnota ucelovej funkcie: \t" + ucelovaFunkcia +
                        "\nVysledna hmotnost: \t\t\t" + celkovaHmotnost +
                        "\nPocet predmetov: \t\t\t" + celkovyPocetPredmetov + "\n\nRiesenie:"
        );

        printWriter.print("n\tx_n\n");

        for (int i = 0; i < ceny.length; i++) {
            printWriter.print(i + 1);
            printWriter.println(ries[i]? "\t1" : "\t0");
        }

        printWriter.close();
    }


    /**
     * Pomocna trieda na vypocet hmotnosti, pre pripad kontroly programu
     * @return hmotnost - vrati aktualnu hmotnost batohu
     */
    private static int vypocitajHmotnost() {
        int hmotnost = 0;


        for (int i = 0; i < hmot.length; i++) {
            if (ries[i]) {
                hmotnost += hmot[i];
            }
        }

        return hmotnost;
    }

    /**
     * Pomocna trieda na vypocet hmotnosti, pre pripad kontroly programu
     * @return predmety - vrati aktualny pocet predmetov v batohu
     */
    private static int vypocitajPocetPredmetov() {
        int predmety = 0;


        for (int i = 0; i < ceny.length; i++) {
            if (ries[i]) {
                predmety += 1;
            }
        }

        return predmety;
    }
}