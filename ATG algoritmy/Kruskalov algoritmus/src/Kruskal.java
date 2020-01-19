import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Kruskal {
    private static FileManager fileManager;

    public Kruskal(String filename) throws FileNotFoundException {
        fileManager = new FileManager(filename);

        doAlgorithm();
    }

    private void doAlgorithm(){
        int[][] graf = fileManager.getMatrix();



        //najde najmensiu hranu
        TreeMap<Integer, Edge> edges = new TreeMap<>();

        for (int i = 0; i < graf.length; i++) {
            edges.put(i, new Edge(graf[i][2], graf[i][0], graf[i][1]));
        }

//        for (int i = 0; i < edges.size(); i++) {
//            System.out.println(edges.get(i).toString());
//        }


        //algoritmus na usporiadanie hran podla najmensej ceny
        ArrayList<Edge> usporiadaneHrany = new ArrayList<>();
        //int n = fileManager.getNumberOfVertices(graf);
        int n = edges.size();

        int index = 0;
        while (index <= n) {
            int smallestCost = Integer.MAX_VALUE;
            int indexOfSmallest = 0;

            for(Integer key: edges.keySet()){
                if (edges.get(key).getCost() < smallestCost) {
                    smallestCost = edges.get(key).getCost();
                    indexOfSmallest = key;
                }
            }

            if (edges.size() == 0) {
                break;
            } else {
                usporiadaneHrany.add(edges.get(indexOfSmallest));
                edges.remove(indexOfSmallest);
            }


            index++;
        }


        // ~~Debug: vypis usporiadanych hran podla ceny
        for (int i = 0; i < usporiadaneHrany.size(); i++) {
            System.out.println(usporiadaneHrany.get(i));
        }


        //zaciatok kruskalovho algoritmu (for real!)
        int[][] maticaStromu = new int[fileManager.getNumberOfVertices(graf)][2];

        for (int i = 0; i < maticaStromu.length; i++) {
            maticaStromu[i][0] = i;
            maticaStromu[i][1] = i;
        }


        ArrayList<Edge> kostra = new ArrayList<>();
        int celkovaCenaKostry = 0;
        index = 0;
        //System.out.println("Kostra grafu: ");
        while (usporiadaneHrany.size() > 0) {
            if (maticaStromu[usporiadaneHrany.get(0).getVertexU() - 1][1] != maticaStromu[usporiadaneHrany.get(0).getVertexV() - 1][1]) {
                kostra.add(usporiadaneHrany.get(0));

                // zisti ktore cislo je mensie v tabulke a nastavi mu take cislo komponentu
                // zaroven nastavi vsetkym ostatnym prvkom komponentu lepsie cislo...
                if (maticaStromu[usporiadaneHrany.get(0).getVertexU() - 1][1] < maticaStromu[usporiadaneHrany.get(0).getVertexV() - 1][1]) {
                    int itemThatWillBeDeleted = maticaStromu[usporiadaneHrany.get(0).getVertexV() - 1][1];
                    int itemThatWillBeAdded = maticaStromu[usporiadaneHrany.get(0).getVertexU() - 1][1];

                    for (int i = 0; i < maticaStromu.length; i++) {
                        if (maticaStromu[i][1] == itemThatWillBeDeleted) {
                            maticaStromu[i][1] = itemThatWillBeAdded;
                        }
                    }

                } else {
                    int itemThatWillBeDeleted = maticaStromu[usporiadaneHrany.get(0).getVertexU() - 1][1];
                    int itemThatWillBeAdded = maticaStromu[usporiadaneHrany.get(0).getVertexV() - 1][1];

                    for (int i = 0; i < maticaStromu.length; i++) {
                        if (maticaStromu[i][1] == itemThatWillBeDeleted) {
                            maticaStromu[i][1] = itemThatWillBeAdded;
                        }
                    }
                }



                celkovaCenaKostry += usporiadaneHrany.get(0).getCost();
                usporiadaneHrany.remove(0);
            } else {
                usporiadaneHrany.remove(0);
            }

            index++;
        }
        //System.out.println("\nCelkova cena kostry je: " + celkovaCenaKostry);

        // ~~Debug: vypis matice stromu
        for (int i = 0; i < maticaStromu.length; i++) {
            System.out.println((maticaStromu[i][0] + 1) + " " + (maticaStromu[i][1] + 1));
        }

        int diff = maticaStromu[0][1];
        boolean suvisly = true;
        for (int i = 0; i < maticaStromu.length; i++) {
            if (maticaStromu[i][1] != diff) {
                suvisly = false;
            }
        }

        if (suvisly) {
            System.out.println("Graf je suvisly, jeho kostra je:");

            for (int i = 0; i < kostra.size(); i++) {
                System.out.println(kostra.get(i).getVertexU() + " <-> " + kostra.get(i).getVertexV() + "\t Cena: "+ kostra.get(i).getCost());

            }

            System.out.println("\nA celkova cena kostry je: " + celkovaCenaKostry);

        } else {
            System.out.println("Graf je nesuvisly (ma viacero komponentov), cize nemoze byt zostrojena uplna kostra...");
        }
    }
}
