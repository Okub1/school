import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Dijkstra {

    public Dijkstra(String fileName) throws FileNotFoundException {
        FileManager fileManager = new FileManager(fileName);

        int[][] graf = fileManager.getMatrix();

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < graf.length; i++) {
            edges.add(new Edge(graf[i][0], graf[i][1], graf[i][2]));
        }

        // ~~Debug: vypis vsetkych hran digrafu
//        for (Edge edge : edges) {
//            System.out.println(edge.toString());
//        }


    }
}
