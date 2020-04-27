import java.util.Scanner;

public class Palindrome {

    public static boolean check(String palindrome) {

        boolean isPalindrom = true;
        int j = palindrome.length() - 1;

        for (int i = 0; i < palindrome.length(); i++) {
            char zpredu = palindrome.charAt(i);
            char zozadu = palindrome.charAt(j);

            if (!Character.isLetterOrDigit(zpredu)) {
                continue;
            }

            if (!Character.isLetterOrDigit(zozadu)) {
                i--;
                j--;
                continue;
            }

            if (zpredu != zozadu) {
                isPalindrom = false;
                break;
            }

            j--;
            if (j < 0) {
                break;
            }

        }

        return isPalindrom;
    }
}
