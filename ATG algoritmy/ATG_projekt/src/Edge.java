public class Edge {
    private final Vertex vertexU;
    private final Vertex vertexV;
    private int price;


    /**
     * 0 = not used
     * 1 = used in direction from U to V
     * 2 = used as edge of first arrival
     *
     * by default is state set to "Has not been used" (0).
     */
    private int state = 0;

    public Edge(Vertex vertexU, Vertex vertexV) {
        this.vertexU = vertexU;
        this.vertexV = vertexV;
    }

    public Vertex getVertexU() {
        return vertexU;
    }

    public Vertex getVertexV() {
        return vertexV;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Translation for states.
     * see attributes
     * @return String form of state (in sentence for outputting)
     */
    public String getStateString() {
        String temp = "";

        switch (state) {
            case 0:
                temp = "Edge has not been used.";
                break;
            case 1:
                temp = "Edge was used in one direction.";
                break;
            default:
                temp = "Edge was used as edge of first arrival";
                break;
        }

        return temp;
    }

    public String toString() {

        return "Edge from " + vertexU.getVertex() + " to " + vertexV.getVertex() + ". State: " + getStateString();
    }
}
