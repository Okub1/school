public class Automat{

    private int sumaVCentoch;

    public Automat(int sumaVCentoch){

        this.sumaVCentoch = sumaVCentoch;

    }

    public void rozmen(){

        System.out.println("\n peniaze v centoch: " + sumaVCentoch);
        System.out.println("\n Rozklad peňazí: \n");

        System.out.println("500€ " +this.sumaVCentoch/50000 );
        this.sumaVCentoch %=50000;

        System.out.println("200€ " +this.sumaVCentoch/20000 );
        this.sumaVCentoch %=20000;

        System.out.println("100€ " +this.sumaVCentoch/10000 );
        this.sumaVCentoch %=10000;

        System.out.println("50€ " +this.sumaVCentoch/5000 );
        this.sumaVCentoch %=5000;

        System.out.println("20€ " +this.sumaVCentoch/2000 );
        this.sumaVCentoch %=2000;

        System.out.println("10€ " +this.sumaVCentoch/1000 );
        this.sumaVCentoch %=1000;

        System.out.println("5€ " +this.sumaVCentoch/500 );
        this.sumaVCentoch %=500;

        System.out.println("2€ " +this.sumaVCentoch/200 );
        this.sumaVCentoch %=200;

        System.out.println("1€ " +this.sumaVCentoch/100 );
        this.sumaVCentoch %=100;

        System.out.println("0,5€ " +this.sumaVCentoch/50 );
        this.sumaVCentoch %=50;

        System.out.println("0,2€ " +this.sumaVCentoch/20 );
        this.sumaVCentoch %=20;

        System.out.println("0,1€ " +this.sumaVCentoch/10 );
        this.sumaVCentoch %=10;

        System.out.println("0,05€ " +this.sumaVCentoch/5 );
        this.sumaVCentoch %=5;

        System.out.println("0,02€ " +this.sumaVCentoch/2 );
        this.sumaVCentoch %=2;

        System.out.println("0,01€ " +this.sumaVCentoch/1 );
        this.sumaVCentoch %=1;


    }



}