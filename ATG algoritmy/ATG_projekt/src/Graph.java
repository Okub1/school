import java.io.FileNotFoundException;
import java.util.HashMap;

public class Graph {
    private HashMap<Integer, Vertex> vertices = new HashMap<>();

    public Graph() {
    }

    public void loadFromFile(String fileName) throws FileNotFoundException {
        FileManager fileManager = new FileManager(fileName);
        int[][] matrix = fileManager.getMatrix();

        /*
        Creates vertices and connections (edges) between them.
         */
        for (int i = 0; i <= fileManager.getNumberOfVertices(matrix); i++) {
            vertices.put(i + 1, new Vertex(i + 1));
        }

        for (int i = 0; i < matrix.length; i++) {
            vertices.get(matrix[i][0]).addNeighbor(vertices.get(matrix[i][1]));
        }
    }

    public int numberOfVertices() {
        return vertices.size();
    }

    public String toString() {

        StringBuilder temp = new StringBuilder();


        for (Integer integer : vertices.keySet()){
            temp.append("\n\t");
            temp.append(vertices.get(integer).toString());
        }

        return String.valueOf(temp);
    }

    public boolean isVertexInside(Vertex vertex) {
        return vertices.containsValue(vertex);
    }

    public boolean isVertexInside(int vertex) {
        return vertices.containsKey(vertex);
    }

    public Vertex getVertex(int vertex) {
        return vertices.get(vertex);
    }
}
