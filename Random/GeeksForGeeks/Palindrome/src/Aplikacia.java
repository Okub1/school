import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Made as an exercise from:
 * https://www.geeksforgeeks.org/java-program-to-check-whether-a-string-is-a-palindrome/
 * kashdkghsa
 */
public class Aplikacia {
    public static void main(String[] args) {
        System.out.println("Kontrola stringu ci je palindrom.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadajte string: ");
        String string = scanner.nextLine().toLowerCase();

        boolean palindrom = true;
        int j = string.length() - 1;

        for (int i = 0; i < string.length(); i++) {
            char zpredu = string.charAt(i);
            char zozadu = string.charAt(j);

            if (!Character.isLetterOrDigit(zpredu)) {
                continue;
            }

            if (!Character.isLetterOrDigit(zozadu)) {
                i--;
                j--;
                continue;
            }

            if (zpredu != zozadu) {
                palindrom = false;
                break;
            }

            j--;
            if (j < 0) {
                break;
            }

        }

        if (palindrom) {
            System.out.println("String je palindrom");
        } else {
            System.out.println("String nie je palindrom.");
        }
    }
}
