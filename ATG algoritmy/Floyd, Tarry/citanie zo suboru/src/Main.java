import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Aplikacia app = new Aplikacia();
//        app.vypisKdeZacinajuSusedia(10);
        app.floydovAlgoritmus();
        app.zistiCestu(1,4);
//        app.zistiCestu(1,326);
//        app.tarryhoAlgoritmus(5);
    }
}
