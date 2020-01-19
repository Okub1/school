import java.util.Scanner;

public class main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean koniec = false;
        do {

            obesenecLogo();

            System.out.println(
                    "\t\t\t\t\u001B[96mVitajte v hre Obesenec!"
                  + "\n\t\t\t\t Vyberte jednu z moznosti: "
                  + "\n\t\t\t\t1 - Hrat hru obesenec"
                  + "\n\t\t\t\t2 - Navod ako hrat hru obesenec"
                  + "\n\t\t\t\t3 - Informacie o tvorcovi hry"
                  + "\n\t\t\t\t0 - Koniec\u001B[0m"
            );

            int volba = scanner.nextInt();
            switch (volba) {
                case 1:
                    Obesenec obesenec = new Obesenec();
                    break;
                case 2:
                    akoHratObesenca();
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


    private static void obesenecLogo() {
        System.out.println(
                "\f\t\t\u001B[93m   ____  __                                  \n" +
                "\t\t  / __ \\/ /_  ___  ________  ____  ___  _____\n" +
                "\t\t / / / / __ \\/ _ \\/ ___/ _ \\/ __ \\/ _ \\/ ___/\n" +
                "\t\t/ /_/ / /_/ /  __(__  )  __/ / / /  __/ /__  \n" +
                "\t\t\\____/_.___/\\___/____/\\___/_/ /_/\\___/\\___/  \n" +
                "\t\t                                             ");
    }

    private static void akoHratObesenca() {
        System.out.println("V hre obesenec je potrebne hadat pozadovane slovicko alebo viacero" +
                " slov, pomocou postupneho zadavania pismen do konzoly, v pripade ze je pismeno " +
                "spravne, vsetky rovnake pismena v hadanom slove sa vypisu. " +
                "Hra konci v pripade ked hrac uhadne vsetky pismena slova alebo slov.\n");

        System.out.println("Stlacte enter pre pokracovanie...");
        try{
            System.in.read();}
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void oTvorcovi() {
        System.out.println("Hru vytvoril Ján Sáňka 5ZY025 - 2019/2020 " +
                " ako projekt na semestralnu pracu na predmet Informatika1.\n");

        System.out.println("Stlacte enter pre pokracovanie...");
        try{
            System.in.read();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
