import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Berie to subory typu:
 * -------------------------------------------
 *  |  VRCHOL_OD   VRCHOL_DO   CENA_HRANY   |
 * -------------------------------------------
 */
public class FileManager {
    private static int filesCounter = 0;
    private int[][] matrix;

    public FileManager(String fileName) throws FileNotFoundException {

        filesCounter += 1;
        int lines = 0;
        Scanner scanner = new Scanner(new File(fileName));
        Scanner scanner2 = new Scanner(new File(fileName));

        try (scanner; scanner2) {
            do{
                lines++;
                scanner.nextLine();
            } while (scanner.hasNext());

            //nenavidim scannery...
            //na to, aby toto spravne fungovalo je treba dva scannery krista

            this.matrix = new int[lines][3];

            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < 3; j++) {
                    this.matrix[i][j] = scanner2.nextInt();
                }
            }
        }
    }

    public void print() {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < 3; j++) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getMatrix(){
        return this.matrix;
    }


    /**TODO: dorobit nacitavanie zo suboru do grafu, ale objektovo!!
     * napriklad vytvorit triedu Graf, a tam to cele nejako zrobit,
     * a potom v triede algorithm vyrobit metodu Tarry,
     * ktora bude mat dva parametre, a to zaciatocny vrchol, a dany graf.
     */

    public Object[] processFileIntoGraph() {
        Object[] graph = new Object[2];

        //ArrayList<> ;


        return null;
    }

    /**
     * returns number of vertices in matrix
     * @param matrix
     * @return
     */
    public int getNumberOfVertices(int[][] matrix) {
        int largest1 = 0;
        int largest2 = 0;


        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] >= largest1) {
                largest1 = matrix[i][0];
            }

            if (matrix[i][1] >= largest2) {
                largest2 = matrix[i][1];
            }
        }

        if (largest1 >= largest2) {
            return largest1;
        } else {
            return largest2;
        }
    }

    public static int getFilesCounter() {
        return filesCounter;
    }
}
