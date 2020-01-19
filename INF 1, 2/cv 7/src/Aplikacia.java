public class Aplikacia {
    public static void main(String[] args) {
        Kniznica kniznica = new Kniznica(10);
        Publikacia publikacia = new Publikacia("nazov 1", 2001);
        Publikacia publikacia1 = new Publikacia("nazov 1", 2005);


        kniznica.pridaj(publikacia);

        kniznica.najdi("nazov 1");
        kniznica.pridaj(publikacia1);
        kniznica.najdi("nazov 1");
        System.out.println(kniznica.toString());
    }
}
