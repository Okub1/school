import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Algorithms {

    private FileManager fileManager;
    private ArrayList<Integer> tarryhoSled;

    public Algorithms() {
    }

    public void tarry(String fileName, int startingPoint) throws FileNotFoundException {
        fileManager = new FileManager(fileName);
        tarryhoSled = new ArrayList<>();

        int[][] matrixTarry = new int[fileManager.getMatrix().length][3];

        //nastavi kazdej hrane ze sa da cez nu prejst
        for (int i = 0; i < matrixTarry.length; i++) {
            matrixTarry[i][0] = fileManager.getMatrix()[i][0];
            matrixTarry[i][1] = fileManager.getMatrix()[i][1];
            matrixTarry[i][2] = 0;
        }

        int[][] matrixTarry2 = new int[getNumberOfVrcholy(matrixTarry)][getNumberOfVrcholy(matrixTarry)];

        for (int i = 0; i < matrixTarry2.length; i++) {
            for (int j = 0; j < matrixTarry2.length; j++) {
                matrixTarry2[i][j] = -1; //hrana neexistuje
            }
        }

//        for (int i = 0; i < matrixTarry2.length; i++) {
//            matrixTarry2[matrixTarry[i][0]][matrixTarry[i][1]] = 1;
//        }

        //next(startingPoint, matrixTarry2);

        for (int i = 0; i < matrixTarry.length; i++) {

        }

        next(startingPoint, matrixTarry);
    }

    private HashMap<Integer, Integer> getNeighbors(int vrchol, int[][] matrixTarry) {
        HashMap<Integer, Integer> neighbors = new HashMap<Integer, Integer>();

        for (int i = 0; i < matrixTarry.length; i++) {
            if (matrixTarry[i][0] == vrchol) {
                neighbors.put(matrixTarry[i][1], matrixTarry[i][2]);
            }
        }

        return neighbors;
    }

    private boolean startRangeCheck(int start, int[][] matrix) {
        return start > 0 && start <= getNumberOfVrcholy(matrix);
    }

    private boolean isInTarryhoSled(int vrchol) {
        return tarryhoSled.contains(vrchol);
    }


    private void next(int vrchol, int[][] matrixTarry) {
        HashMap<Integer, Integer> neighbors = getNeighbors(vrchol, matrixTarry);

        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i) == 0) {
                matrixTarry[vrchol][i] = 1;

                System.out.println("Idem z vrcholu: " + vrchol + " do vrcholu: " + neighbors.get(i));

                next(i, matrixTarry);
            } else if ( neighbors.get(i) == 1 && !isInTarryhoSled(neighbors.get(i))) {
                matrixTarry[vrchol][i] = 2;

                next(i, matrixTarry);
            } else if (neighbors.get(i) == 1 && isInTarryhoSled(neighbors.get(i)) && neighbors.size() == i){
                matrixTarry[vrchol][i] = 2;

                next(i, matrixTarry);
            } else if (neighbors.get(i) == 2) {
                if (neighbors.size() == i) {
                    break;
                }
            }
        }
    }

    private int getNumberOfVrcholy(int[][] matrix) {
        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][0] == counter) {
                counter++;
            }
        }
        return counter;
    }


    /**
     * Tento je uz ten spravny tarry...
     * @param graph
     * @param start
     */
    public void tarry(Graph graph, int start) {
        if(graph.isVertexInside(start)) {

            System.out.print("\nZaciatocny bod: "  + start);
            System.out.print("\nTarryho Sled 1. komponentu: \n" + start);

            graph.getVertex(start).setDiscovered(true);

            findNext(graph.getVertex(start));
        } else {
            System.out.println("Invalid vertex, please select vertex from range: ");
            System.out.println("0 - " + " asdasd"); //TODO range check
        }

        int numberOfComponents = 1;

        for (int i = 1; i <= graph.numberOfVertices(); i++) {
            for (Vertex vertexV : graph.getVertex(i).getNeighbors().keySet()) {
                if (vertexV.getNeighbors().get(graph.getVertex(i)).getState() == 0) {
                    numberOfComponents++;
                    if (numberOfComponents > 1) {
                        System.out.print("\nTarryho sled " + numberOfComponents + ". komponentu: \n" + vertexV.getVertex());
                    }
                    findNext(vertexV);
                }
            }
        }

        System.out.println("\nPocet komponentov: " + numberOfComponents);

        if (numberOfComponents > 1) {
            System.out.println("Graf je nesuvisly. (pocet komponentov > 1");
        } else {
            System.out.println("Graf je suvisly.");
        }

//        System.out.println(graph.toString()); //DEBUG-------------------------------------------------------------
    }

    public void findNext(Vertex vertexU) {
        HashMap<Vertex, Edge> neighbors = vertexU.getNeighbors();

        for (Vertex vertexV : neighbors.keySet()){

            if (!vertexV.isDiscovered()) {
                if (neighbors.get(vertexV).getState() == 0 && vertexV.getNeighbors().get(vertexU).getState() == 0) {
                    vertexU.getNeighbors().get(vertexV).setState(2);
                    vertexV.setDiscovered(true);
                    //System.out.print(" " + vertexV.getVertex());
                    findNext(vertexV);
                }
            } else {
                if (neighbors.get(vertexV).getState() == 0 && vertexV.getNeighbors().get(vertexU).getState() == 0) {
                    vertexU.getNeighbors().get(vertexV).setState(1);
                    vertexV.setDiscovered(true);
                    //System.out.print(" " + vertexV.getVertex());
                    findNext(vertexV);
                }
            }
        }

        for (Vertex vertexV : neighbors.keySet()){
            if (neighbors.get(vertexV).getState() == 0 && vertexV.getNeighbors().get(vertexU).getState() == 1) {
                vertexU.getNeighbors().get(vertexV).setState(1);
                System.out.print(" " + vertexV.getVertex());
                findNext(vertexV);
            }
        }


        for (Vertex vertexV : neighbors.keySet()){
            if (neighbors.get(vertexV).getState() == 0 && vertexV.getNeighbors().get(vertexU).getState() == 2) {
                vertexU.getNeighbors().get(vertexV).setState(1);
                System.out.print(" " + vertexV.getVertex());
                findNext(vertexV);
            }
        }
    }
}
