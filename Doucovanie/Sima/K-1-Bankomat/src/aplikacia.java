import java.util.*;

public class aplikacia {
    public static void main(String[] args) {
        Bankomat bankomat = new Bankomat();
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadajte sumu, ktorú chcete dostať v bankovkách: ");
        int vstup = sc.nextInt();
        bankomat.vypocitaj(vstup);
    }
}
