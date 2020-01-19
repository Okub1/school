public class Policko {
    private char znak;

    public Policko(char znak) {
        this.znak = znak;
    }

    public char getZnak() {
        return znak;
    }

    public void setZnak(char znak) {
        this.znak = znak;
    }

    @Override
    public String toString() {
        return "Policko{" +
                "znak=" + znak +
                '}';
    }
}
