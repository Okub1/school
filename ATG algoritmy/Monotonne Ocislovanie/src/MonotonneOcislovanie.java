import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MonotonneOcislovanie {

    public MonotonneOcislovanie(String fileName) throws FileNotFoundException {
        FileManager fileManager = new FileManager(fileName);

        int[][] digraf = fileManager.getMatrix();
        int numberOfVertices = fileManager.getNumberOfVertices(digraf);


        // nacitanie hran digrafu do zoznamu hran, ktory budeme potom iterovat pri monotonnom cislovani
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < digraf.length; i++) {
            edges.add(new Edge(digraf[i][0], digraf[i][1], digraf[i][2]));
        }

        // ~~Debug: vypisanie nacitanych hran
//        for (Edge edge: edges) {
//            System.out.println(edge.toString());
//        }

        //zoznamy predchodcov
        ArrayList<Integer>[] zoznamyPredchodcov = new ArrayList[numberOfVertices];

        for (int i = 0; i < zoznamyPredchodcov.length; i++) {
            zoznamyPredchodcov[i] = new ArrayList<>();
        }


        // ~~Debug: vypis zoznamov predchodcov
//        for (int i = 0 ;i < numberOfVertices; i++) {
//            System.out.println(zoznamyPredchodcov[i].toString());
//        }


        // najde predchodcov vrcholov a prida ich do zoznamov predchodcov
        for (int i = 0; i <= numberOfVertices; i++) {
            for (int j = 0; j < edges.size(); j++) {
                if (i == edges.get(j).getVertexV()) {
                    zoznamyPredchodcov[i - 1].add(edges.get(j).getVertexU());
                }
            }
        }

        // ~~Debug: vypis zoznamov predchodcov aj s indexovanim
        for (int i = 0 ;i < numberOfVertices; i++) {
            System.out.print(i + 1 + zoznamyPredchodcov[i].toString() + "\n");
        }




        int pocetPrazdnychZoznamov = 0;
        int pocitadlo = 0;

        ArrayList<Integer> ocislovanie = new ArrayList<>();

        do {
            int smallestIdeg = 0;
            int indexSmallestIdeg = -1;

            for (int i = 0; i < zoznamyPredchodcov.length; i++) {
                if (zoznamyPredchodcov[i] == null) {
                    continue;
                }


                if (zoznamyPredchodcov[i].size() <= smallestIdeg) {
                    smallestIdeg = zoznamyPredchodcov[i].size();
                    indexSmallestIdeg = i + 1;
                }
            }

            for (int i = 0; i < zoznamyPredchodcov.length; i++) {
                if (zoznamyPredchodcov[i] == null) {
                    continue;
                }


                for (int j = 0; j < zoznamyPredchodcov[i].size(); j++) {
                    if (zoznamyPredchodcov[i].get(j) == indexSmallestIdeg) {
                        zoznamyPredchodcov[i].remove(j);
                    }
                }
            }


            ocislovanie.add(indexSmallestIdeg);

            // koniec algoritmu + vypis
            if (indexSmallestIdeg == -1) {

                //vypis v pripade, ze je acyklicky
                if (pocitadlo == numberOfVertices) {

                    System.out.println();
                    for (int i = 0 ;i < numberOfVertices; i++) {
                        if (zoznamyPredchodcov[i] == null) {
                            System.out.println(i + 1 + "[]");
                        } else {
                            System.out.print(i + 1 + zoznamyPredchodcov[i].toString() + "\n");
                        }
                    }

                    System.out.println();

                    Map<Integer, Integer> usporiadane = new TreeMap<>();

                    for (int i = 0; i < numberOfVertices; i++) {
                        usporiadane.put(ocislovanie.get(i), i);
                    }



                    System.out.println("vrchol \t poradie");
                    for (Map.Entry<Integer, Integer> entry : usporiadane.entrySet()) {
                        Integer key = entry.getKey();
                        Integer value = entry.getValue();

                        System.out.printf("  %s \t    %s\n", key, value + 1);
                    }

                    System.out.println("Graf je monotónne očíslovaný => graf je acyklický");

                //vypis v pripade, ze je cyklicky
                } else {

                    System.out.println();
                    for (int i = 0 ;i < numberOfVertices; i++) {
                        if (zoznamyPredchodcov[i] == null) {
                            System.out.println(i + 1 + "[]");
                        } else {
                            System.out.print(i + 1 + zoznamyPredchodcov[i].toString() + "\n");
                        }

                    }

                    System.out.println("Graf nebolo možné monotónne očíslovať => graf je cyklický!");
                }
                break;
            }

            // nastavi pouzity vrchol ako nepouzitelny...
            zoznamyPredchodcov[indexSmallestIdeg - 1] = null;

            //pocitadlo, aby nam to neloopovalo donekonecna, ale maximalne po pocet vsetkych hran grafu
            pocitadlo++;
        } while (pocitadlo < edges.size());
    }
}
