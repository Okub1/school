import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Aplikacia {

    private Scanner scanner;
    private int pocetRiadkov;
    private File subor;
    private int[][] pole;
    private HashMap<Integer, Integer> hashMap;
    private int[][] maticaC;
    private int[][] maticaX;

    public Aplikacia() throws FileNotFoundException {

        //otvori pozadovany subor
        this.subor = new File("citanie zo suboru/subory/pr1.hrn"); //staci zmenit pr1 na pr2 a zmenia sa data...
        try {
            this.scanner = new Scanner(this.subor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //aplikacia si zisti, kolko riadkov ma dany subor, aby sa mohli prednastavit polia, i ked lepsie by bolo spravit arraylisty, a tie by sa dynamicky rozsirovali
        this.pocetRiadkov = 0;
        do {
            assert this.scanner != null;
            this.scanner.next();
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
        this.hashMap = new HashMap();

        int pom = 0;
        for (int i = 1; i <= this.pocetRiadkov; i++) {
            if (this.pole[i][1] != pom) {
                //hashmap(cislo(kluc), cislo kde zacinaju susedia(riadok));
                this.hashMap.put(this.pole[i][1], i);
                pom++;
            }
        }
    }

    //floydov algoritmus (matica C a matica X)
    public void floydovAlgoritmus(/*int[][] pole -> len ak by som to chcel objektovo*/) {
        int velkostMaticeC = this.hashMap.size() + 1;
        int velkostMaticeX = this.hashMap.size() + 1;

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
                        this.maticaX[j][k] = i;
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
        if (vrcholZ <= this.hashMap.size() + 1 || vrcholDo <= this.hashMap.size() + 1) {
            System.out.println("\nCesta z vrcholu " + vrcholZ + " do vrcholu " + vrcholDo + " je cez vrcholy:");
            path(vrcholZ, vrcholDo);
            System.out.println(", a vzdialenost tychto vrcholov je: " + this.maticaC[vrcholZ][vrcholDo] + "\n");
        } else {
            //vypisanie platnych vrcholov, pokial su zadane nespravne vrcholy
            String platneVrcholy = "\n---------------------------------------\nNemozem najst cestu,\nnespravne vrcholy!\n\nZadajte platne vrcholy, \n" +
                    "Platne vrcholy: ";
            for (int i = 1; i < this.hashMap.size() + 1; i++) {
                platneVrcholy += i + ", ";
            }
            System.out.println(platneVrcholy);
            System.out.println("vase vrcholy: " + vrcholZ + ", " + vrcholDo);
            System.out.println("---------------------------------------\n");
        }
    }

    public void path(int q, int r) {
        if (this.maticaX[q][r] == q) {
            return;
        }
        System.out.print(", vrchol " + this.maticaX[q][r]);
        path (this.maticaX[q][r], r);
    }

    // vypise kde zacinaju susedia daneho cisla
    public void vypisKdeZacinajuSusedia(int sused) {
        if (sused > 0) {
            System.out.println("\nSusedia cisla " + sused + " zacinaju na riadku: " + this.hashMap.get(sused));
        } else {
            System.out.println("\nZadajte cislo > 0...");
        }
    }
}