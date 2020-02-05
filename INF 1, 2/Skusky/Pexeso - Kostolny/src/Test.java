import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Pexeso pexeso = new Pexeso();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Zadajte riadok: ");
            int riadok = scanner.nextInt();
            System.out.println("Zadajte stlpec: ");
            int stlpec = scanner.nextInt();

            pexeso.otocKartu(riadok, stlpec);
        }

    }
}
