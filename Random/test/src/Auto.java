public class Auto {

    private int pocetKolies = 0;

    Auto(int pocetKolies) {
        this.pocetKolies = pocetKolies;
    }

    public void pohyb() {

    }



    public static String cap1stChar(String userIdea) {
        char[] stringArray = userIdea.toCharArray();

        for (int i = 0; i < stringArray.length; i++) {
            if (i % 2 == 0) {
                stringArray[i] = Character.toUpperCase(stringArray[i]);
            }
        }

        return new String(stringArray);
    }


}
