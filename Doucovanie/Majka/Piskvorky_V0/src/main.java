import java.util.Scanner;

public class main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean koniec = false;
        do {

            piskvorkyLogo();

            System.out.println(
                    "\f\tVitajte v hre Piskvorky!"
                            + "\n\t Vyberte jednu z moznosti: "
                            + "\n\t1 - Hrat hru piskvorky"
                            + "\n\t2 - Navod ako hrat hru piskvorky"
                            + "\n\t3 - Informacie o tvorkyni hry"
                            + "\n\t0 - Koniec"
            );

            int volba = scanner.nextInt();
            switch (volba) {
                case 1:
                    Piskvorky piskvorky = new Piskvorky();
                    break;
                case 2:
                    akoHratPiskvorky();
                    break;
                case 3:
                    oTvorkyni();
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


    private static void piskvorkyLogo() {
        System.out.println("______ _     _                     _          \n" +
                "| ___ (_)   | |                   | |         \n" +
                "| |_/ /_ \\/_| | ____   _____  _ __| | ___   _ \n" +
                "|  __/| / __| |/ /\\ \\ / / _ \\| '__| |/ / | | |\n" +
                "| |   | \\__ \\   <  \\ V / (_) | |  |   <| |_| |\n" +
                "\\_|   |_|___/_|\\_\\  \\_/ \\___/|_|  |_|\\_\\\\__, |\n" +
                "                                         __/ |\n" +
                "                                        |___/ ");
    }

    private static void akoHratPiskvorky() {
        System.out.println("V hre piskvorky ide o vsetko! Hraci postupne zadavaju svoje znaky do hracieho pola," +
                "a snazia sa dosiahnut neprerusenych 5 znakov za sebou v riadku alebo stlpci, "/*TODO diagonalne*/ +
                "vyhra ten hrac, ktory dosiahne 5 svojich znakov za sebou ako prvy.\n");

        System.out.println("Stlacte enter pre pokracovanie...");
        try{
            System.in.read();}
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void oTvorkyni() {
        System.out.println("Hru vytvorila Mária Mäsiarová, 5ZY02NEVIEM - 2019/2020 " +
                " na semestralnu pracu z Informatiky 1.\n");

        System.out.println("Stlacte enter pre pokracovanie...");
        try{
            System.in.read();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
