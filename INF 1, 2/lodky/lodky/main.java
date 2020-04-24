import java.util.*;
public class main
{
    private static Scanner citac = new Scanner(System.in);
    private static Scanner citac2 = new Scanner(System.in);

    public static void main(String args[]){
        System.out.print("\f");

        hlaskaVitajte();

        int volba = citac.nextInt();
        citac.close();    

        //TODO PREROBIT CELE MENU NANOVO!! az kym nebude hotova logika NESAHAT!!!

        switch(volba){
            case 1:
                hlaskaVelkost();

                int velkost = citac2.nextInt();
                citac2.close();
                Hra hra = new Hra(velkost);
                hra.vypisPole();

                while (hra.koniec == 0) {
                    hra.vypisPole();
                    hra.vypisMoznosti();
                }

                hra.endScore();
                hra.zapisScore();
                break;
             case 2:
        break;
        }
    }


    public static void hlaskaVitajte(){
        System.out.println("Vitajte v hre lodky.");
        System.out.println("1 - Zacat hru");
        System.out.println("2 - Koniec");
    }

    public static void hlaskaVelkost(){
        System.out.println("Vyberte velkost pola.");
        System.out.println("1 - Male pole");
        System.out.println("2 - Velke pole");
    }
}
