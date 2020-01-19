import java.io.FileNotFoundException;

public class Main {

    /**
     * "Graphs/paluchov velky graf.graph" - nie je legit graf pre tento algoritmus
     * "Graphs/pr1.graph" - ok
     * "Graphs/pr2.graph" - ok
     * "Graphs/pr3.graph" - nesuvisly, cize ukazuje kostru viacerych komponentov
     * "Graphs/pr4.graph" - nesuvisly
     * "Graphs/pr5.graph" - ok
     * "Graphs/pr6.graph" - nesuvisly
     * "Graphs/pr7.graph" - nesuvisly
     * "Graphs/pr8.graph" - nesuvisly
     * "Graphs/pr9.graph" - nesuvisly
     * "Graphs/pr10.graph" - nesuvisly
     * "Graphs/pr11.graph" - nesuvisly
     * "Graphs/pr12.graph" - ok
     * "Graphs/pr13.graph" - nesuvisly
     * "Graphs/pr14.graph" - nesuvisly
     * "Graphs/pr15.graph" - ok, ale je to tricky
     * "Graphs/pr16.graph" - nesuvisly
     * "Graphs/pr17.graph" - nesuvisly
     * "Graphs/pr18.graph" - ok
     *
     * Julove priklady:
     * "Graphs/julov_priklad1.graph" - ok
     * "Graphs/julov_priklad2.graph" - ok
     *
     *
     * @param args asd
     * @throws FileNotFoundException asd
     */
    public static void main(String[] args) throws FileNotFoundException {
        Kruskal kruskal = new Kruskal("Graphs/julov_priklad2.graph");
    }
}
