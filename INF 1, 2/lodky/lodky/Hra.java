import java.util.*;
import java.io.*;
public class Hra {
    private String[][] hraciePole;
    private String[][] hraciePole2;
    private int pocetLodiek = 1;
    public int koniec = 0;
    private int trafeneLodky = 0;
    private int pocetPokusov = 0;
    private double percentil;
    Random generator = new Random();

    public Hra(int velkostPola) {
        int mala = 1;

        if (velkostPola == 1) {
            velkostPola = mala;
        }

        int velka = 11;

        if(velkostPola == 2) {
            velkostPola= velka;
        }

        this.hraciePole = new String[velkostPola][velkostPola]; // vytvarame pole o velkosti vstupneho parametra konstruktora
        this.hraciePole2 = new String[velkostPola][velkostPola];

        for(int i = 0; i < velkostPola; i++){
            for(int j = 0;j < velkostPola; j++){
                this.hraciePole[i][j] = "0";     // vsetky prvky v poli nastavime na 0
                this.hraciePole2[i][j] = " ";
            }
        
        }
        dajLodky();
    }
    
    public void vypisPole() {
        System.out.print("\f");
        for (int i = 0; i < this.hraciePole.length + 1; i++) {
            System.out.print(" " + i + " ");
        }

        System.out.println();

        for (int i = 0; i < this.hraciePole.length; i++) {
            for (int j=0; j < this.hraciePole.length; j++) {
                System.out.print("[" + this.hraciePole2[i][j] + "]");  // vsetky prvky v poli nastavime na 0
            }
                System.out.print(" " + i + " ");
                System.out.println();
        }
        this.info();
    }
    public void dajLodky(){
        int a, b;
        int h = 1;
        while(h <= this.pocetLodiek){
            a = this.generator.nextInt(this.hraciePole.length);
            b = this.generator.nextInt(this.hraciePole.length);

            if(this.hraciePole[a][b].equals("0")){
                this.hraciePole[a][b]="X";
                h++;
            }
        }
    }
    public void odkryPole (int x, int y) {

        // osetrenie
        if(x > this.hraciePole.length - 1 || x < 0) {
            return;
        }

        // TODO prerobit zadavanie cisel na nieco zmysluplnejsie...

        // osetrenie ak zada hodnotu mimo pola
        if (y > this.hraciePole.length-1 || y<0) {
            return;
        }

        if (this.hraciePole[x][y].equals("X") && this.hraciePole2[x][y]==" ") {
            this.trafeneLodky++;
        }

        this.hraciePole2[x][y] = this.hraciePole[x][y];
        
        this.pocetPokusov++;

        if (this.trafeneLodky == this.pocetLodiek) {
            this.koniec = 1;
        }
        vypisPole();
    }
    public void vypisMoznosti(){
        int x,y;

        System.out.println("Odkrytie pola: ");

        Scanner citac = new Scanner(System.in);
        Scanner citac2 = new Scanner(System.in);

        x = citac.nextInt();
        y = citac2.nextInt();

        odkryPole(x,y);
    }

    private void info() {
        System.out.println("Trafenych lodiek zatial: " + this.trafeneLodky + " z " + this.pocetLodiek);
        System.out.println("Pocet pokusov: " + this.pocetPokusov);
        System.out.println("Uspesnost (%): " + (double) this.trafeneLodky / this.pocetPokusov * 100);
        
    }

    public void endScore() {
        System.out.println("\fVyhrali ste!");
        System.out.println("Pocet pokusov: " + this.pocetPokusov);
        System.out.println("Uspesnost (%): " + (double) this.trafeneLodky/this.pocetPokusov*100);
        System.out.println("Zapisujem do suboru...");
    }
    
    public void zapisScore() {
     try{    
         Date date = new Date();
         // display time and date using toString()
         String cas = date.toString();
         
         FileWriter fstream = new FileWriter("highscore.txt",true);
         BufferedWriter out = new BufferedWriter(fstream);
         out.write("Cas: " + cas + "\r\n");
         out.write("Pocet pokusov: " + this.pocetPokusov + "\r\n");
         out.write("Uspesnost (%): " + (double) this.trafeneLodky / this.pocetPokusov * 100 + "\r\n");
         out.write("* * * * * * * * * * * * * * * * * * * *\r\n");
         //Close the output stream
         out.close();
         System.out.println("Hotovo!");
        }catch (Exception e){//Catch exception if any
            System.err.println("Chyba: " + e.getMessage());
        }
    }
   
    

 
}
