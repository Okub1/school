import java.util.Scanner;

public class Clovece {
    public static void main(String[] args) {
        HraciePole haHraciePole = new HraciePole();
        Scanner scanner = new Scanner(System.in);
        Kocka kocka = new Kocka();

        boolean koniec = false;
        int tah = 1; // len na DEBUGGGGGGGGGGGGGG

        while (!koniec) {
            haHraciePole.vykresli();

            System.out.println("Tah " + tah + " Hrac na tahu: " + haHraciePole.getHracNaTahu());

            int padnuteCislo = kocka.hod();

            System.out.println("Na kocke padla: " + padnuteCislo);

            // ~~~~~~~~~~~~~~~~~~~~~~ USER INPUT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            // ziska pozadovany USER INPUT (A-D, 1-4)
            String userInput = "";
            boolean koniecInput = false;

            while (!koniecInput) {
                System.out.print("Zadaj figurku: ");

                if (haHraciePole.getHracNaTahu() == Hrac.PISMENKOVY) {
                    System.out.print("(A, B, C, D");
                } else {
                    System.out.print("(1, 2, 3, 4");
                }

                System.out.println(", koniec)");

                userInput = scanner.next().toUpperCase();

                if (haHraciePole.getHracNaTahu() == Hrac.PISMENKOVY) {
                    switch (userInput) {
                        case "A":
                        case "B":
                        case "C":
                        case "D":
                            koniecInput = true;
                            break;
                        default:
                            System.out.println("zly input...");
                    }
                } else {
                    switch (userInput) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                            koniecInput = true;
                            break;
                        default:
                            System.out.println("zly input...");
                    }
                }

                if (userInput.equals("KONIEC")) {
                    System.out.println("\f\tKoniec programu...");
                    System.out.println("\n\tNaprogramoval: Jakub Senko, 2020");
                    koniec = true;
                    break;
                }
            }


            // vyuzivanie inputu v hre

            haHraciePole.tahPanacika(userInput.charAt(0), padnuteCislo);


            tah++;
        }


    }
}
