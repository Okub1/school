import java.util.Scanner;

public class main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean koniec = false;
        do {

            pexesoLogo();

            System.out.println(
                  "\f\tVitajte v hre Pexeso!"
                + "\n\t Vyberte jednu z moznosti: "
                + "\n\t1 - Hrat hru pexeso"
                + "\n\t2 - Navod ako hrat hru pexeso"
                + "\n\t3 - Informacie o tvorcovi hry"
                + "\n\t0 - Koniec"
            );

            int volba = scanner.nextInt();
            switch (volba) {
                case 1:
                    Pexeso pexeso = new Pexeso();
                    break;
                case 2:
                    akoHrat();
                    break;
                case 3:
                    oTvorcovi();
                    break;
                case 0:
                    // vypne program
                    koniec = true;
                    break;
                default:
                    System.out.println("Prosim zadajte moznost z menu...");
                    break;
            }
        } while (!koniec);
    }

    private static void akoHrat() {
        System.out.println("Hra pexeso spočíva v zapamätaní a následnom využití tejto " +
                "pamäte na vyriešenie hry, hráč postupne vyberá karty tak, aby ich uhádol." +
                " Hra končí keď sú všetky karty uhádnuté.\n");
    }

    private static void oTvorcovi() {
        System.out.println("Hru vytvoril Andrej Minár, 5ZY026 - 2019/2020 " +
                "ako semestrálnu prácu na predmet Informatika 1 (Java).\n");
    }

    private static void pexesoLogo() {
        System.out.println("______ _______   __ _____ _____  _____ \n" +
                "| ___ \\  ___\\ \\ / /|  ___/  ___||  _  |\n" +
                "| |_/ / |__  \\ V / | |__ \\ `--. | | | |\n" +
                "|  __/|  __| /   \\ |  __| `--. \\| | | |\n" +
                "| |   | |___/ /^\\ \\| |___/\\__/ /\\ \\_/ /\n" +
                "\\_|   \\____/\\/   \\/\\____/\\____/  \\___/ \n" +
                "                                       \n" +
                "                                       ");
    }
}
