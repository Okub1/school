public class Edge {

    private int cost;
    private int vertexU;
    private int vertexV;

    public Edge(int vertexU, int vertexV, int cost) {
        this.cost = cost;
        this.vertexU = vertexU;
        this.vertexV = vertexV;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getVertexU() {
        return vertexU;
    }

    public void setVertexU(int vertexU) {
        this.vertexU = vertexU;
    }

    public int getVertexV() {
        return vertexV;
    }

    public void setVertexV(int vertexV) {
        this.vertexV = vertexV;
    }

    public String toString() {
        return /*"Edge: " + */"\t" + getVertexU() + " --> " + getVertexV() + ", with cost:\t" + getCost();
    }
}
