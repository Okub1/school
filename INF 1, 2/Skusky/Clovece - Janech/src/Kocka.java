public class Kocka {
    int[] cisla = {1, 2, 5, 6, 3, 6, 6, 2, 6, 1, 6, 5, 6, 5, 4, 3}; // XD ok
    int momentalne;

    public Kocka() {
        this.momentalne = 0;
    }

    public int hod() {
        if (this.momentalne == this.cisla.length) {
            this.momentalne = 0;
        }
        int ciselko = this.cisla[this.momentalne];

        this.momentalne++;

        return ciselko;
    }
}
