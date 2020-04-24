import java.util.ArrayList;

public class PascalTriangle {

    public PascalTriangle() {
    }

    public static int factorial(int num) {
        if (num == 0)
            return 1;
        else
            return(num * factorial(num-1));
    }

    public static void usingFactorial(int levelsOfPascalTriangle) {
        for (int i = 0; i < levelsOfPascalTriangle; i++) {
            for (int j = 0; j < i + 1; j++) {

                // indenting:
                if (j == 0) {
                    for (int indent = 0; indent < levelsOfPascalTriangle - i; indent++) {
                        System.out.print("\t");
                    }
                }

                // calculating (n over k) using factorial
                // (and base formulae for binomial coefficient n!/(k!*(n-k)!)
                // it does not work with more than 14 levels:
                System.out.print(factorial(i)/(factorial(j)*(factorial(i-j)))+ "\t\t");
            }
            System.out.println();
        }
    }

    public static void notUsingFactorial(int levelsOfPascalTriangle) {
        ArrayList<Long> lastLevel = new ArrayList<>();
        for (int i = 0; i < levelsOfPascalTriangle; i++) {
            ArrayList<Long> currentLevel = new ArrayList<>();

            if (i < 2) {
                if (i == 0) {
                    currentLevel.add((long) 1);
                } else if (i == 1) {
                    currentLevel.add((long) 1);
                    currentLevel.add((long) 1);
                }
            } else {

                for (int j = 0; j < i + 1; j++) {

                    if (j == 0 || j == i) {
                        currentLevel.add((long) 1);
                    } else {
                        currentLevel.add(lastLevel.get(j - 1) + lastLevel.get(j));
                    }
                }
            }

            lastLevel = currentLevel;

            for (int j = 0; j < currentLevel.size(); j++) {
                if (j == 0) {
                    for (int indent = 0; indent < levelsOfPascalTriangle - i; indent++) {
                        System.out.print("\t");
                    }
                }

                System.out.print(currentLevel.get(j));
                if (currentLevel.get(j) > 1000000 || currentLevel.get(j) < 0) {
                    System.out.print(" ");
                } else if (currentLevel.get(j) > 1000) {
                    System.out.print("\t");
                } else {
                    System.out.print("\t\t");
                }
            }


            System.out.println();
        }
    }
}
