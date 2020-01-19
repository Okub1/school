import java.util.ArrayList;
import java.util.HashMap;

public class test {

    public static void main(String[] args) {
        HashMap<Integer, Integer> test1 = new HashMap<>();


        for (int i = 0; i < 10; i++) {
            test1.put(i, i);
        }

        test1.remove(5);
        test1.put(2, 2);

        for (int i = 0; i < 10; i++) {
            System.out.println(test1.get(i));
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        ArrayList<Integer> test2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            test2.add(i);
        }

        test2.remove(0);
        test2.add(5);

        for (int i = 0; i < 10; i++) {
            System.out.println(test2.get(i));
        }
    }
}
