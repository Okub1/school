import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Pomocna trieda na spracovanie suborov.
 *
 * Berie to subory typu:
 * -----------
 * |  Cislo  |
 * -----------
 */
public class FileManager {
    private static int filesCounter = 0;
    private int[] matrix;

    /**
     * Konstruktor triedy.
     * Umoznuje nacitat data zo suborov do matice.
     * Potreba dvoch scannerov (pretoze proste java...)
     * Jeden scanner zisti pocet riadkov,
     * druhy scanner nacita data zo suboru na zaklade poctu riadkov.
     *
     * Sice to vyzera akokeby to programoval niekto iny, ale v skutocnosti programujem po anglicky,
     * originalny FileManager pouzivam na ATG algoritmy, toto je len "okresaná verzia"...
     * Ak by ste chceli dokaz, kludne vam obhajim svoje ATG algoritmy.
     * @param fileName meno suboru, ktory sa ma otvorit v podobe Stringu
     * @throws FileNotFoundException vynimka v pripade neexistujuceho suboru
     */
    public FileManager(String fileName) throws FileNotFoundException {

        filesCounter += 1;
        int lines = 0;
        Scanner scanner = new Scanner(new File(fileName));
        Scanner scanner2 = new Scanner(new File(fileName));

        try {
            do{
                lines++;
                scanner.nextLine();
            } while (scanner.hasNext());

            this.matrix = new int[lines];
        } finally {
            scanner.close();
        }

        try {
            for (int i = 0; i < lines; i++) {
                this.matrix[i] = scanner2.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner2.close();
        }

    }

    /**
     * Vypis nacitanych dat.
     */
    public void print() {
        for (int aMatrix : matrix) {
            System.out.println(aMatrix);
        }
    }

    /**
     * Getter nacitanych dat suboru v podobe matice.
     * @return matrix - vrati data suboru v matici.
     */
    public int[] getMatrix(){
        return this.matrix;
    }

    /**
     * Utility metoda na ziskanie poctu spracovanych suborov danou triedou...
     * @return pocet spracovanych suborov FileManager-om
     */
    public static int getFilesCounter() {
        return filesCounter;
    }
}
