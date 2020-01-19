import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Aplikacia {

    private Scanner scanner;
    private int pocetRiadkov;
    private File subor;
    private int[][] pole;
    private HashMap<Integer, Integer> smerniky;
    private int[][] maticaC;
    private int[][] maticaX;
    private HashMap<Integer, Boolean> objaveneVrcholy;
    private int[][] maticaTarryX;
    private int[][] maticaTarryY;
    private HashMap<Integer, Integer> trivialnySled;
    private int celkovaVzdialenostTarry;

    public Aplikacia() throws FileNotFoundException {

        //otvori pozadovany subor
        this.subor = new File("citanie zo suboru/subory/pr5.hrn"); //staci zmenit pr1 na pr2 a zmenia sa data...
        try {
            this.scanner = new Scanner(this.subor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //aplikacia si zisti, kolko riadkov ma dany subor, aby sa mohli prednastavit polia, i ked lepsie by bolo spravit arraylisty, a tie by sa dynamicky rozsirovali
        this.pocetRiadkov = 0;
        do {
            this.scanner.nextLine();
            this.pocetRiadkov++;
        } while (this.scanner.hasNextLine());

        //zapise data do pola
        //x a y v poli: pole[y][x]
        this.pole = new int[this.pocetRiadkov+1][4];

        Scanner scanner2 = new Scanner(this.subor);
        do {
            for (int i = 1; i <= this.pocetRiadkov; i++) {
                for (int j = 1; j < 4; j++) {
                    this.pole[i][j] = scanner2.nextInt();
                }
            }
        } while (scanner2.hasNextLine());

        //vypisuje data z pola
        for (int i = 1; i <= this.pocetRiadkov; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(this.pole[i][j] + " ");
            }
            System.out.println();
        }

        //zisti susedov a ulozi do pamate ich pozicie
        this.smerniky = new HashMap();

        int pom = 0;
        for (int i = 1; i <= this.pocetRiadkov; i++) {
            if (this.pole[i][1] != pom) {
                //hashmap(cislo(kluc), cislo kde zacinaju susedia(riadok));
                this.smerniky.put(this.pole[i][1], i);
                pom++;
            }
        }
    }

//Zaciatok floydovho algoritmu                                                                                      <<<
    //floydov algoritmus (matica C a matica X)
    public void floydovAlgoritmus(/*int[][] pole -> len ak by som to chcel objektovo*/) {
        int velkostMaticeC = this.smerniky.size() + 1;
        int velkostMaticeX = this.smerniky.size() + 1;

        //bacha, velkost matice je + 1 <<<<<<<<<<<<<<<<<<< pretoze 0 indexy su cislovanie a 1 az nekonecno je matica...
        this.maticaC = new int[velkostMaticeC][velkostMaticeC];
        this.maticaX = new int[velkostMaticeX][velkostMaticeX];


        //vytvorenie cislovania stlpcov a riadkov, resp. oznacenie vrcholov matice C
        for (int i = 1; i < velkostMaticeC; i++) {
            this.maticaC[i][0] = i;
            this.maticaC[0][i] = i;
        }

        //vytovrenie cislovania stlpcov a riadkov, resp. oznacenie vrcholov matice X
        for (int i = 1; i < velkostMaticeX; i++) {
            this.maticaX[i][0] = i;
            this.maticaX[0][i] = i;
        }

        //naplni maticu C "nekonecnami" (maximalnou hodnotou int-u) matica C
        for (int i = 1; i < velkostMaticeC; i++) {
            for (int j = 1; j < velkostMaticeC; j++) {
                this.maticaC[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < velkostMaticeX; i++) {
            for (int j = 1; j < velkostMaticeX; j++) {
                this.maticaX[i][j] = Integer.MAX_VALUE;
            }
        }

        //cyklus pre pridavanie nul po hlavnej diagonale matice C
        for (int i = 1; i < velkostMaticeC; i++) {
            for (int j = 1; j < velkostMaticeC; j++) {
                if (i == j) {
                    this.maticaC[i][j] = 0;
                    i++;
                }
                continue;
            }
        }

        //cyklus pre pridavanie od 1 po n cisel po hlavnej diagonale matice X
        for (int i = 1; i < velkostMaticeX; i++) {
            for (int j = 1; j < velkostMaticeX; j++) {
                if (i == j) {
                    this.maticaX[i][j] = i;
                    i++;
                }
                continue;
            }
        }

        //naplni maticu vzdialenostami; matica C
        for (int k = 1; k <= this.pocetRiadkov; k++) {
            this.maticaC[this.pole[k][1]][this.pole[k][2]] = this.pole[k][3];
        }

        //naplni maticu hodnotami; matica X
        for (int i = 1; i <= this.pocetRiadkov; i++) {
            this.maticaX[this.pole[i][1]][this.pole[i][2]] = this.pole[i][1];
        }

//        //floydov algoritmus na vypocet matice vzdialenosti verzia 1
//        for (int i = 1; i < velkostMaticeC; i++) {
//            for (int j = 1; j < velkostMaticeC; j++) {
//                for (int k = 1; k < velkostMaticeC; k++) {
//                    if (i == k) {
//                        continue;
//                    }
//                    for (int l = 1; l < velkostMaticeC; l++) {
//                        if (j == l) {
//                            continue;
//                        }
//                        if (maticaC[i][l] == Integer.MAX_VALUE) {
//                            continue;
//                        }
////                            mal som to cely cas dobre, len mi chybala ta podmienka s nekonecnami
//                        if (this.maticaC[j][i] != Integer.MAX_VALUE &&
//                            this.maticaC[i][k] != Integer.MAX_VALUE &&
//                            this.maticaC[j][i] + this.maticaC[i][k] < this.maticaC[j][k]) {
//                            this.maticaC[j][k] = this.maticaC[j][i] + this.maticaC[i][k];
//                        }
//                    }
//                }
//            }
//        }

        //floydov algoritmus na vypocet matice vzdialenosti verzia 2
        for (int i = 1; i < velkostMaticeC; i++) {
            for (int j = 1; j < velkostMaticeC; j++) {
                for (int k = 1; k < velkostMaticeC; k++) {
                    if (this.maticaC[j][i] != Integer.MAX_VALUE &&
                        this.maticaC[i][k] != Integer.MAX_VALUE &&
                        this.maticaC[j][i] + this.maticaC[i][k] < this.maticaC[j][k]) {
                        this.maticaC[j][k] = this.maticaC[j][i] + this.maticaC[i][k];
                        this.maticaX[j][k] = this.maticaC[i][k];
                    }
                }
            }
        }

//        //floydov algoritmus na vypocet matice X
//        for (int i = 1; i < velkostMaticeX; i++) {
//            for (int j = 1; j < velkostMaticeX; j++) {
//                for (int k = 1; k < velkostMaticeX; k++) {
//                    if (maticaX[j][i] != Integer.MAX_VALUE &&
//                            maticaX[i][k] != Integer.MAX_VALUE) {
//                        maticaX[j][k] = i;
//                    }
//                }
//            }
//        }

        //algoritmus na hladanie najkratsej cesty

        //vypise maticu C
        System.out.println();
        for (int i = 0; i < velkostMaticeC; i++) {
            for (int j = 0; j < velkostMaticeC; j++) {
                System.out.print(this.maticaC[i][j] + "\t");
            }
            System.out.println();
        }

        //vypise maticu X
        System.out.println();
        for (int i = 0; i < velkostMaticeX; i++) {
            for (int j = 0; j < velkostMaticeX; j++) {
                System.out.print(this.maticaX[i][j] + "\t");
            }
            System.out.println();
        }

//        //malo by hladat cestu, ale nefunguje to este, problem je v metode path
//        for (int i = 1; i < velkostMaticeX; i++) {
//            for (int j = 1; j < velkostMaticeX; j++) {
//                path(i,j);
//            }
//            System.out.println();
//        }


        //toto tu je na otestovanie konkretnych vrcholov, metoda nizsie je na dynamicke cisla aj s opravou, ak ste sa pomylili...
//        zistiCestu(3,4);
    }

    public void zistiCestu(int vrcholZ, int vrcholDo) {
        if (vrcholZ > 0 && vrcholDo < this.smerniky.size() + 1) {
            System.out.println("\nCesta z vrcholu " + vrcholZ + " do vrcholu " + vrcholDo + " je cez vrcholy:");
            path(vrcholZ, vrcholDo);
            System.out.println(", a vzdialenost tychto vrcholov je: " + this.maticaC[vrcholZ][vrcholDo] + "\n");
        } else {
            //vypisanie platnych vrcholov, pokial su zadane nespravne vrcholy
            String platneVrcholy = "\nCHYBA\n<------------------------------------------>\n\t\tNemozem najst cestu,\n\t\tnespravne vrcholy!\n\n\t\tZadajte platne vrcholy, \n" +
                    "\t\tPlatne vrcholy: ";
            for (int i = 1; i < this.smerniky.size() + 1; i++) {
                platneVrcholy += i + ", ";
                if (i == 8) {
                    platneVrcholy += "\n";
                }
            }
            System.out.println(platneVrcholy);
            System.out.println("\t\tvami zadane vrcholy: " + vrcholZ + ", " + vrcholDo);
            System.out.println("<------------------------------------------>\n");
        }
    }

    private void path(int q, int r) {
        if (this.maticaX[q][r] == q) {
            return;
        } else {
            System.out.print(", vrchol " + this.maticaX[q][r]);
            path (this.maticaX[q][r], r);
        }
    }

//Koniec floydovho algoritmu                                                                                        <<<

//Zaciatok zakladneho algoritmu                                                                                     <<<
    public void zakladnyAlgoritmus() {
        //ak vidite tuto poznamku, mate staru verziu programu...
    }
//Koniec zakladneho algoritmu                                                                                       <<<

//Zaciatok tarryho algoritmu                                                                                        <<<
    public void tarryhoAlgoritmus(int pociatocnyVrchol) {
        int velkostMaticTarry = this.smerniky.size() + 1;
        this.trivialnySled = new HashMap<>();

        //kontrola spravneho vrcholu, ak je vrchol mimo platnych vrcholov, oznami chybu...
        this.objaveneVrcholy = new HashMap<>(this.smerniky.size() + 1);
        if (pociatocnyVrchol < 0 || pociatocnyVrchol > this.smerniky.size()) {
            System.out.println("Nastavte spravny pociatocny vrchol...");
            String platneVrcholy = "\n---------------------------------------\nNemozem najst cestu,\nnespravny vrchol!\n\nZadajte platny vrchol, \n" +
                    "Platne vrcholy: ";
            for (int i = 1; i < this.smerniky.size() + 1; i++) {
                platneVrcholy += i + ", ";
                if (i == 8) {
                    platneVrcholy += "\n";
                }
            }
            System.out.println(platneVrcholy);
            System.out.println("vas pociatocny vrchol: " + pociatocnyVrchol);
            System.out.println("---------------------------------------\n");
        }

        this.maticaTarryX = new int[velkostMaticTarry][velkostMaticTarry]; //matica vzdialenosti - tarryX
        this.maticaTarryY = new int[velkostMaticTarry][velkostMaticTarry]; //matica podmienok - tarryY
//        //z bezpecnostneho hladiska su nastavene vsetky vzdialenosti na nulu...
//        //ak nie je potreba, tak zakomentovat tento cyklus...
//         for (int i = 1; i < this.pocetRiadkov; i++) {
//            this.pole[i][3] = 0;
//        }

        //prida indexy matice tarryX
        for (int i = 1; i < maticaTarryX.length; i++) {
            maticaTarryX[i][0] = i;
            maticaTarryX[0][i] = i;
        }

        //cyklus pre pridavanie nul po hlavnej diagonale tarryX
        for (int i = 1; i < maticaTarryX.length; i++) {
            for (int j = 1; j < maticaTarryX.length; j++) {
                if (i == j) {
                    maticaTarryX[i][j] = 0;
                }
                continue;
            }
        }

        //prida indexy matice tarryY
        for (int i = 1; i < maticaTarryX.length; i++) {
            maticaTarryY[i][0] = i;
            maticaTarryY[0][i] = i;
        }

        //cyklus pre pridavanie nul po hlavnej diagonale tarryY
        // 0 = hrana je nepouzitelna
        // 1 = hrana je pouzitelna
        // 2 = hrana prveho prichodu
        for (int i = 1; i < maticaTarryY.length; i++) {
            for (int j = 1; j < maticaTarryY.length; j++) {
                if (i == j) {
                    maticaTarryY[i][j] = 0;
                }
                continue;
            }
        }

        //naplni maticu vzdialenostami; matica tarryX
        for (int k = 1; k <= this.pocetRiadkov; k++) {
            maticaTarryX[this.pole[k][1]][this.pole[k][2]] = this.pole[k][3];
        }

        //naplni maticu podmienok jednotlivymi podmienkami (konkretne ze je pouzitelna = 1) tarryY
        for (int i = 1; i < maticaTarryY.length; i++) {
            for (int j = 1; j < maticaTarryY.length; j++) {
                if (maticaTarryX[i][j] != 0) {
                    maticaTarryY[i][j] = 1;
                }
            }
        }

//        //vypisanie susedov daneho cisla
//        for (int i = 0; i < this.vypisSusedovCisla(5).size(); i++) {
//            System.out.println(vypisSusedovCisla(5).get(i) + " ");
//        }

        //Tarryho algoritmus
        System.out.println();
        this.objaveneVrcholy.put(pociatocnyVrchol, true);
        this.trivialnySled.put(pociatocnyVrchol, pociatocnyVrchol);
        this.tarry(pociatocnyVrchol);



//        //                      vypisovanie matic:
//        //vypise maticu tarryX
//        System.out.println();
//        for (int i = 0; i < maticaTarryX.length; i++) {
//            for (int j = 0; j < maticaTarryX.length; j++) {
//                System.out.print(maticaTarryX[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        //vypise maticu tarryY
//        System.out.println();
//        for (int i = 0; i < maticaTarryY.length; i++) {
//            for (int j = 0; j < maticaTarryY.length; j++) {
//                System.out.print(maticaTarryY[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

//Koniec tarryho algoritmu                                                                                          <<<

    // vypise kde zacinaju susedia daneho cisla
    public void vypisKdeZacinajuSusedia(int sused) {
        if (sused > 0) {
            System.out.println("\nSusedia cisla " + sused + " zacinaju na riadku: " + this.smerniky.get(sused));
        } else {
            System.out.println("\nZadajte cislo > 0...");
        }
    }

    public ArrayList vypisSusedovCisla(int cislo) {
        ArrayList<Integer> susediaDanehoCisla = new ArrayList<>();
        int zaciatokSusedov = this.smerniky.get(cislo);

        for (int i = zaciatokSusedov; i < this.pole.length; i++) {
            for (int j = 0; j < this.pole.length; j++) {
                if (this.pole[i][1] == cislo) {
                    susediaDanehoCisla.add(this.pole[i][2]);
                } else {
                    if (this.pole[i][1] == cislo) {
                        break;
                    }
                }
                break;
            }
        }
        return susediaDanehoCisla;
    }


    public void tarry(int vrchol) {

        int sused = this.najdiSuseda(vrchol);

        if (sused == 0) {
            System.out.println("Prejdena vzdialenost: " + this.celkovaVzdialenostTarry);
            return;
        }

        if (!jeObjaveny(sused)) {
            this.objaveneVrcholy.put(sused, true);
            this.maticaTarryY[vrchol][sused] = 2;
            this.trivialnySled.put(vrchol, sused);
            System.out.println(vrchol + " " + sused);
            this.celkovaVzdialenostTarry += this.maticaTarryX[vrchol][sused];
            tarry(sused);
            return;
        }

        if (jeObjaveny(sused)) {
            this.maticaTarryY[vrchol][sused] = 0;

            if (this.maticaTarryY[sused][vrchol] == 2) {
                this.maticaTarryY[sused][vrchol] = 0;
            }

            this.trivialnySled.put(vrchol, sused);
            System.out.println(vrchol + " " + sused);
            this.celkovaVzdialenostTarry += this.maticaTarryX[vrchol][sused];
            tarry(sused);
            return;
        }
    }

    private int najdiSuseda(int vrchol) {
        ArrayList<Integer> susedia;
        susedia = vypisSusedovCisla(vrchol);

        for (int i = 0; i < susedia.size(); i++) {
            if (this.maticaTarryY[vrchol][susedia.get(i)] == 1 && this.maticaTarryY[susedia.get(i)][vrchol] != 2) {
                return susedia.get(i);
            }
        }

        for (int i = 0; i < susedia.size(); i++) {
            if (this.maticaTarryY[vrchol][susedia.get(i)] == 1) {
                return susedia.get(i);
            }
        }
        return 0;
    }


    private boolean jeObjaveny(int vrchol) {
        return this.objaveneVrcholy.containsKey(vrchol);
    }
}