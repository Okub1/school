import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Aplikacia app = new Aplikacia();
//        app.vypisKdeZacinajuSusedia(10);
        app.floydovAlgoritmus();
        app.zistiCestu(3,4);
        app.zistiCestu(10,10);
    }
}
