import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Matica matica1 = new Matica(3, 2);
        Matica matica2 = new Matica(2, 3);
//        Matica matica3 = new Matica(3, 3);
        Operacie operacie = new Operacie();

//        int randomNum = ThreadLocalRandom.current().nextInt(0,  100 + 1);
//
//        for (int i = 0; i < matica1.dajVelkostMatice()[0]; i++) {
//            for (int j = 0; j < matica1.dajVelkostMatice()[1]; j++) {
//                matica1.setHodnotaPozicie(i, j, randomNum + j);
//            }
//        }
//
//        int randomNum2 = ThreadLocalRandom.current().nextInt(0,  50 + 1);
//
////        for (int i = 0; i < matica2.dajVelkostMatice()[0]; i++) {
////            for (int j = 0; j < matica2.dajVelkostMatice()[1]; j++) {
////                matica2.setHodnotaPozicie(i, j, randomNum + i);
////            }
////        }


        //matica 1

        matica1.setHodnotaPozicie(0,0,0);
        matica1.setHodnotaPozicie(0,1,5);
//        matica1.setHodnotaPozicie(0,2,0);
        matica1.setHodnotaPozicie(1,0,3);
        matica1.setHodnotaPozicie(1,1,5);
//        matica1.setHodnotaPozicie(1,2,0);
        matica1.setHodnotaPozicie(2,0,5);
        matica1.setHodnotaPozicie(2,1,2);
//        matica1.setHodnotaPozicie(2,2,0);

        //matica2

        matica2.setHodnotaPozicie(0,0,3);
        matica2.setHodnotaPozicie(0,1,3);
        matica2.setHodnotaPozicie(0,2,4);
        matica2.setHodnotaPozicie(1,0,4);
        matica2.setHodnotaPozicie(1,1,-2);
        matica2.setHodnotaPozicie(1,2,-2);
//        matica2.setHodnotaPozicie(2,0,0);
//        matica2.setHodnotaPozicie(2,1,0);
//        matica2.setHodnotaPozicie(2,2,0);


        //matica 3

//        matica3.setHodnotaPozicie(0,1,50);
//        matica3.setHodnotaPozicie(2,2,25);
//        matica3.setHodnotaPozicie(0,2,34);
//        matica3.setHodnotaPozicie(2,1,38);

        System.out.println("vypis matice 1: ");
        matica1.vypisMatice();
        System.out.println();

        System.out.println("vypis matice 2: ");
        matica2.vypisMatice();
        System.out.println();

//        System.out.println("vypis matice 3: ");
//        matica3.vypisMatice();
//        System.out.println();
//
//        System.out.println("Scitanie matic 1 a 2: ");
//        operacie.scitajDveMatice(matica1, matica2).vypisMatice();
//        System.out.println();
//
//        System.out.println("Scitanie matic 1, 2 a 3: ");
//        operacie.scitajDveMatice(operacie.scitajDveMatice(matica1, matica2), matica3).vypisMatice();
//        System.out.println();

        System.out.println("Vynasobenie dvoch matic 1 a 2: ");
        operacie.vynasobDveMatice(matica1, matica2);
        System.out.println();
    }
}
