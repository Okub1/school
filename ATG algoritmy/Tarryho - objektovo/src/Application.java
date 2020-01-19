import java.io.File;
import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {

        /*
         * Jednotlivé príklady:
         *  "Graphs/pr1.graph"  - suvisly
         *  "Graphs/pr2.graph"  - suvisly
         *  "Graphs/pr3.graph"  - nesuvisly, 2 komponenty
         *  "Graphs/pr4.graph"  - nesuvisly, 2 komponenty
         *  "Graphs/pr5.graph"  - suvisly
         *  "Graphs/pr6.graph"  - nesuvisly, 2 komponenty
         *  "Graphs/pr7.graph"  - nesuvisly, 3 komponenty
         *  "Graphs/pr8.graph"  - nesuvisly, 2 komponenty
         *  "Graphs/pr9.graph"  - nesuvisly, 2 komponenty
         *  "Graphs/pr10.graph" - nesuvisly, 5 komponentov
         *  "Graphs/pr11.graph" - nesuvisly, 4 komponenty
         *  "Graphs/pr12.graph" - suvisly
         *  "Graphs/pr13.graph" - nesuvisly, 27 komponentov
         *  "Graphs/pr14.graph" - nesuvisly, 5 komponentov
         *  "Graphs/pr15.graph" - suvisly - tento je ale zaujimavy, slucka na samom sebe
         *  "Graphs/pr16.graph" - nesuvisly - viacero sluciek samych na sebe, 3 komponenty
         *  "Graphs/pr17.graph" - nesuvisly - 2 kopomenty, len ako ukazkovy priklad s poctom vrcholov...
         *
         *  "Graphs/paluchov velky graf.graph" - suvisly
         *
         *
         * Mozne problemy: (male)
         *
         * Fungovat by mal akykolvek graf, avsak silno odporucam vkladat grafy, ktore budu mat vsetky vrcholy od 1 po N,
         * pretoze nacitavanie nie je uplne dokonale, a tak len najde najvyssi vrchol, a podla neho vytvori vrcholy, cize
         * ak mame vrcholy 1, 2, 3 a 18, tak vytvori 18 vrcholov (je to dobugovane, vytvori vzdy o jeden viac, niekedy
         * vytvori presne, nechce sa mi to uz zistovat preco...) - kuknut "Graphs/pr17.graph", tam to je vidno
         */

        final String pathName = "Graphs/pr1.graph";

        Graph graph = new Graph();

        graph.loadFromFile(pathName);

        System.out.println(graph.toString());

        Algorithms algorithms = new Algorithms();

        algorithms.tarry(graph, 1);

    }
}
