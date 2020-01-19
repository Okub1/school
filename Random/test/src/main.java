public class main {

    public static void main(String[] args) {

    System.out.println("==============================================");

        System.out.println("Prvy bankomat: ");

        // bankomat bez centov, iba cele eura

        Bankomat bankomat = new Bankomat(8888);

        bankomat.roztriedSumu();

        System.out.println(bankomat.getSuma());


//=============================================================================================================

    System.out.println("==============================================");

        System.out.println("Druhy bankomat: ");

        // bankomat s centami, v double


        Bankomat2 bankomat2 = new Bankomat2(888.88);

        bankomat2.roztriedSumu();

        System.out.println(bankomat2.getSuma());


//=============================================================================================================

    System.out.println("==============================================");

        System.out.println("Treti bankomat: ");

        // bankomat s centami, v double bez problemov...

        Bankomat3 bankomat3 = new Bankomat3(888.88);

        bankomat3.roztriedSumu();

        System.out.println(bankomat3.getSuma());

    }
}
