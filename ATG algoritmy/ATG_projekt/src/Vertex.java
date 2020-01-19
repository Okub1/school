import jdk.nashorn.api.tree.Tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Vertex implements Comparator<Vertex> {
    private final int vertex; //number of vertex
    private HashMap<Vertex, Edge> neighbors; // neighboring vertices of vertex
    private boolean discovered = false;

    public Vertex(int vertex) {
        this.vertex = vertex;
        this.neighbors = new HashMap<Vertex, Edge>();
    }

    /**
     * Returns vertex number
     * @return vertex
     */
    public int getVertex() {
        return vertex;
    }

    /**
     * Returns list of neighbors, where key is Vertex neighbor, and Value is edge between this and neighbor
     * @return
     */
    public HashMap<Vertex, Edge> getNeighbors() {
        return neighbors;
    }

    /**
     * Adds neighbors, both ways!
     * U -> V,
     * V -> U
     * @param neighbor
     */
    public void addNeighbor(Vertex neighbor) {
        neighbors.put(neighbor, new Edge(this, neighbor));

        neighbor.getNeighbors().put(this, new Edge(neighbor, this));
    }

    /**
     * Simple getter for state of discovery.
     * @return
     */
    public boolean isDiscovered() {
        return discovered;
    }

    /**
     * Simple setter for state of discovery.
     * @param discovered
     */
    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    /**
     * Returns String that can be outputted via System.out.print();
     * Example output:
     * ----------------------------
     * Vertex 1
     * neighbors: 3, 2,
     * Edges:
     * 	Edge from 1 to 3
     * 	Edge from 1 to 2
     * @return
     */
    public String toString() {

        StringBuilder temp = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();

        for (Vertex vertex : neighbors.keySet()){
            temp.append("\n\t");
            temp.append(neighbors.get(vertex).toString());
            temp2.append(neighbors.get(vertex).getVertexV().getVertex());
            temp2.append(", ");

        }

        return "----------------------------\nVertex " + vertex + " \nneighbors: " + temp2 + "\nEdges: " + temp;
    }

    @Override
    public int compare(Vertex o1,Vertex o2)
    {
        Integer o1_int = o1.getVertex();
        Integer o2_int = o2.getVertex();

        return o1_int.compareTo(o2_int);

        // Your logic for comparing the key strings
    }
}
