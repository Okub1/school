
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Obesenec {

    private Scanner scanner = new Scanner(System.in);
    private FileManager fileManager;

    {

    }

    public Obesenec() {
        String hadaneSlovo;
        StringBuilder progress = new StringBuilder();
        int pocetNespravnych = 0;

        // nacitanie slov zo suboru
        try {
            this.fileManager = new FileManager("Subory/slova.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        hadaneSlovo = this.fileManager.getMatrix()[rand.nextInt(this.fileManager.getMatrix().length)] ;

        // vytvorenie progress slovicka, ktore sa bude postupne menit podla uhadnutych znakov...
        for (int i = 0; i < hadaneSlovo.length(); i++) {
            if (hadaneSlovo.charAt(i) == ' ') {
                progress.append(" ");
            } else {
                progress.append("_");
            }
        }

        // prerobenie slov na pole char

        char[] hadaneSlovoChar = new char[hadaneSlovo.length()];
        char[] progressChar = new char[hadaneSlovo.length()];

        for (int i = 0; i < hadaneSlovo.length(); i++) {
            hadaneSlovoChar[i] = hadaneSlovo.charAt(i);
            progressChar[i] = progress.charAt(i);
        }

        // DEBUG ---------------------
        //System.out.println(hadaneSlovo);
        jeDohrate(pocetNespravnych);

        System.out.println(pomocnyVypis(String.valueOf(progressChar)));

        // regex
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);


        // zaciatok samotnej logiky programu
        while (!kontrola(String.valueOf(progressChar))) {
            char pismeno = ' ';

            // zadavanie pismena
            boolean koniec = false;
            do {
                System.out.println("Prosim zadajte pismeno: (a-z (not case-sensitive), 0-9)");


                // tento if fixuje chybu ked uzivatel nic nezada,
                // ked len stlaci enter, normalne bez tohoto ifu vyhodi exception
                // pretoze scanner na pozicii .charAt(0) nic nema...
//                if (this.scanner.nextLine().equals("")) {
//                    continue;
//                }

                String input = this.scanner.nextLine();

                if (input.equals("")) {
                    continue;
                }

                pismeno = input.toLowerCase().charAt(0);

                // dalsia cast regex
                Matcher matcher = pattern.matcher(String.valueOf(pismeno));

                // ak sa nezhoduje zadane pismeno s regex, pyta znovu input od uzivatela
                if (!matcher.matches()) {
                    continue;
                }

                koniec = true;
            } while (!koniec);


            boolean spravne = false;

            // kontrola ci sa dane pismeno nachadza v hadanom slove a rovno ho aj nahradi
            for (int i = 0; i < hadaneSlovo.length(); i++) {
                if (pismeno == hadaneSlovo.charAt(i)) {
                    progressChar[i] = pismeno;
                    spravne = true;
                }
            }

            // ak zada nespravne, prida sa pocet nespravnych
            if (!spravne) {
                pocetNespravnych++;
            }

            // ak je dohrate, konec
            if (jeDohrate(pocetNespravnych)) {
                break;
            }

            System.out.println(pomocnyVypis(String.valueOf(progressChar)));
            System.out.println("Pocet nespravnych: " + pocetNespravnych);
        }

        System.out.println("\n\u001B[93m--------------------------------------");
        System.out.println("\tKoniec hry.\n");
        System.out.println("\tHadane slovo/a: " + hadaneSlovo);
        System.out.println("\tPocet nespravnych: " + pocetNespravnych);
        System.out.println("\tGratulujem!");
        System.out.println("--------------------------------------");

    }

    // pre krajsi vypis progressu:
    // namiesto _____
    // bude _ _ _ _ _
    public String pomocnyVypis(String progress) {
        StringBuilder pom = new StringBuilder();

            for(int i = 0; i < progress.length(); i++) {
                pom.append(progress.charAt(i)).append(" ");
            }

        return pom.toString();
    }

    // kontrola ci uz je hadane slovo uhadnute cele alebo nie
    // false ak nie je este uhadnute
    // true ak uz je uhadnute
    private boolean kontrola(String hadaneSlovo) {

        for (int i = 0; i < hadaneSlovo.length(); i++) {
            Character pismeno = hadaneSlovo.charAt(i);

            if ((pismeno.equals('_'))) {
                return false;
            }
        }

        return true;
    }

    private boolean jeDohrate(int pocetNespravnych) {

        switch (pocetNespravnych) {
            case 0:
                System.out.println(
                        "______________ \n" +
                        "| | /          \n" +
                        "| |/           \n" +
                        "| |            \n" +
                        "| |            \n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____________|\n");
                return false;
            case 1:
                System.out.println(
                        "______________ \n" +
                        "| | /       |  \n" +
                        "| |/           \n" +
                        "| |            \n" +
                        "| |            \n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____________|\n");
                return false;
            case 2:
                System.out.println(
                        "______________ \n" +
                        "| | /       |  \n" +
                        "| |/        O  \n" +
                        "| |            \n" +
                        "| |            \n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____________|\n");
                return false;
            case 3:
                System.out.println(
                        "______________ \n" +
                        "| | /       |  \n" +
                        "| |/        O  \n" +
                        "| |         |  \n" +
                        "| |            \n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____________|\n");
                return false;
            case 4:
                System.out.println(
                        "______________ \n" +
                        "| | /       |  \n" +
                        "| |/        O  \n" +
                        "| |        /|  \n" +
                        "| |            \n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____________|\n");
                return false;
            case 5:
                System.out.println(
                        "______________ \n" +
                        "| | /       |  \n" +
                        "| |/        O  \n" +
                        "| |        /|\\\n" +
                        "| |            \n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____________|\n");
                return false;
            case 6:
                System.out.println(
                        "______________ \n" +
                        "| | /       |  \n" +
                        "| |/        O  \n" +
                        "| |        /|\\\n" +
                        "| |          \\\n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____________|\n");
                return false;
            case 7:
                System.out.println(
                        "______________ \n" +
                        "| | /       |  \n" +
                        "| |/        O  \n" +
                        "| |        /|\\\n" +
                        "| |         /\\\n" +
                        "|_|___________ \n" +
                        "|             |\n" +
                        "|_____DED_____|\n");
                return true;
        }
        return false;
    }


    // len placeholder, nech viem ako by mala ta sibenica vyzerat vo finale...
    private void sibenica() {
        System.out.println(" sibenica ");
        System.out.println(
                "______________\n" +
                "| | /       | \n" +
                "| |/        O \n" +
                "| |        /|\\ \n" +
                "| |         /\\ \n" +
                "|_|___________\n" +
                "|             |\n" +
                "|_____________|\n");

    }
}
