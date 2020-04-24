import java.util.Scanner;

public class Hlavna {

    public static void main(String[] args) {
        Bludisko bludisko = new Bludisko();
        Scanner scanner = new Scanner(System.in);

        // start
        while (true) {
            bludisko.vykresli();
            // ~~~~~~~~~~~~~~~~~~~~~~~~~~ USER INPUT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            // konkretne: zadanie smeru pac-mana
            boolean koniecInput = false;
            String userInput;
            Smer vybratySmer = null;

            while (!koniecInput) {
                System.out.println("Zadaj smer: (moznosti: hore, dole, vlavo, vpravo, koniec)");

                userInput = scanner.next().toLowerCase(); // osetrenie velkych pismen

                switch(userInput) {
                    case "hore":
                        vybratySmer = Smer.HORE;
                        koniecInput = true;
                        break;
                    case "dole":
                        vybratySmer = Smer.DOLE;
                        koniecInput = true;
                        break;
                    case "vlavo":
                        vybratySmer = Smer.VLAVO;
                        koniecInput = true;
                        break;
                    case "vpravo":
                        vybratySmer = Smer.VPRAVO;
                        koniecInput = true;
                        break;
                    case "koniec":
                        System.out.println("\f\tKoniec programu...");
                        System.out.println("\n\tNaprogramoval: Jakub Senko, 2020");
                        System.exit(0);
                    default:
                        System.out.println("Zla volba...");
                        break;
                }
            }

            bludisko.getPacman().krok(vybratySmer);
            bludisko.tik();
        }

    }
}
