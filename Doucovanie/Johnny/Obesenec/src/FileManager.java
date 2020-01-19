import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Berie to subory typu:
 * --------------
 *  |  String   |
 * --------------
 * (aj s medzerami...)
 *
 * DOLEZITA VEC: nedavat diakritiku, nedavat znaky ine ako [a-z, A-Z, 0-9] <<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class FileManager {
    private static int filesCounter = 0;
    private String[] matrix;

    public FileManager(String fileName) throws FileNotFoundException {

        filesCounter += 1;
        int lines = 0;
        Scanner scanner = new Scanner(new File(fileName));
        Scanner scanner1 = new Scanner(new File(fileName));

        try (scanner) {
            do{
                lines++;
                scanner.nextLine();
            } while (scanner.hasNext());

            this.matrix = new String[lines];
        }

        // nacitanie do pola Stringov

        for (int i = 0; i < lines; i++) {
            this.matrix[i] = scanner1.nextLine();
        }
    }

    public void vypis() {
        for (String s : this.matrix) {
            System.out.println(s);
        }
    }

    public String[] getMatrix(){
        return this.matrix;
    }


    public static int getFilesCounter() {
        return filesCounter;
    }
}
