import java.io.FileNotFoundException;

/**
 * "Digraphs/paluchov velky graf.graph" - nie je acyklicky
 * "Digraphs/pr1.graph" - nie je acyklicky
 * "Digraphs/pr2.graph" - je acyklicky
 * "Digraphs/pr3.graph" - acyklicky
 * "Digraphs/pr4.graph" - acyklicky
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MonotonneOcislovanie monotonneOcislovanie = new MonotonneOcislovanie("Digraphs/pr4.graph");
    }
}
