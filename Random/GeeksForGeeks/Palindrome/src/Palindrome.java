import java.util.Scanner;

public class Palindrome {
    private static String temp = "";

    public static boolean check(String palindrome) {
        temp = "";
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
                result(palindrome, i, j, zpredu, zozadu);
                break;
            }

            j--;

            if (j < 0) {
                break;
            }
        }

        return isPalindrom;
    }

    private static void result(String palindrome, int i, int j, Character zpredu, Character zozadu) {
        temp += "na pozícii \t" + (i + 1) + " (znak " + zpredu + ")\n";
        temp += "a na pozícii \t" + (j + 1) + " (znak " + zozadu + ") nie je zhoda...\n";
        temp += "Dĺžka slova: \t" + palindrome.length();
    }

    public static String getResult() {
        return temp;
    }
}
