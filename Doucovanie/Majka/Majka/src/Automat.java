public class Automat {
    private int suma;

    public Automat(int suma){
        this.suma = suma;
    }

    public void rozmen(){

        System.out.println("\n peniaze: " + suma);

        System.out.println("\n Rozklad penazi: \n");


        System.out.format(" %d x 200€%n", this.suma/200);
        this.suma %= 200;
        System.out.format(" %d x 100€%n", this.suma/100);
        this.suma %= 100;
        System.out.format(" %d x 50€%n", this.suma/50);
        this.suma %= 50;
        System.out.format(" %d x 20€%n", this.suma/20);
        this.suma %= 20;
        System.out.format(" %d x 10€%n", this.suma/10);
        this.suma %= 10;
        System.out.format(" %d x 5€%n", this.suma/5);
        this.suma %= 5;
        System.out.format(" %d x 2€%n", this.suma/2);
        this.suma %= 2;
        System.out.format(" %d x 1€%n", this.suma/1);
        this.suma %= 1;

    }
}
