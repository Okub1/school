import java.util.Scanner;


/**
 * Trieda obsahujuca menu na spustanie hry a pomocne vypisy do menu.
 */
public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean koniec = false;

        do {
            logoLodicky();

            System.out.println(
                    "\t\tVitajte v hre Lodicky!"
                            + "\n\t\t Vyberte jednu z moznosti: "
                            + "\n\t\t1 - Hrat hru lodicky"
                            + "\n\t\t2 - Navod ako hrat hru lodičky"
                            + "\n\t\t0 - Koniec"
            );

            int volba = scanner.nextInt();
            switch (volba) {
                case 1:
                    Lodicky lodicky = new Lodicky();
                    break;
                case 2:
                    akoHratLodicky();
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

    /**
     * Pomocna metoda sluziaca len pre vypis.
     */
    private static void logoLodicky() {

        System.out.println("\f" +
                "\t\u001B[96m _               _        _          \n" +
                "\t\u001B[96m| |             | (_)    | |         \n" +
                "\t\u001B[96m| |     ___   __| |_  _\\/_| | ___   _ \n" +
                "\t\u001B[96m| |    / _ \\ / _` | |/ __| |/ / | | |\n" +
                "\t\u001B[96m| |___| (_) | (_| | | (__|   <| |_| |\n" +
                "\t\u001B[96m\\_____/\\___/ \\__,_|_|\\___|_|\\_\\\\__, |\n" +
                "\t\u001B[96m                                __/ |\n" +
                "\t\u001B[96m                               |___/ \u001B[0m");
    }

    /**
     * Pomocna metoda sluziaca len pre vypis.
     */
    private static void akoHratLodicky() {
        System.out.println("\fLodicky su jednoducha hra, kde sa jeden super snazi druhemu\n" +
                " znicit vsetky jeho lode! Hra sa strieda medzi dvoma hracmi po kazdom tahu\n" +
                "okrem trafenia lodky, vtedy hrac dostava tah navyse.\n" +
                "Hra konci v pripade ze jeden super porazi druheho.");

        System.out.println("Stlacte enter pre pokracovanie...");
        try{
            System.in.read();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
