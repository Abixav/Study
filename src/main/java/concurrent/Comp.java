package concurrent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Comp implements Comparator<Comp> {
    int speed;
    int price;
    String name;

    public Comp(int speed, int price, String name) {
        this.speed = speed;
        this.price = price;
        this.name = name;
    }

   /* @Override
    public int compareTo(Comp o) {
        int tmp = this.speed - o.speed;
        if (tmp == 0) {
            return this.name.compareTo(o.name);
        } else {
            return tmp;
        }

    }*/

    @Override
    public int compare(Comp o1, Comp o2) {
        return 0;
    }
}
class Ba {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        m.get("");
        Comp c = new Comp(1 , 4, "na");
        Comp c1 = new Comp(3 , 2, "an");
        Comp c2 = new Comp(2 , 6, "wa");
        Comp[] ra = {c, c1, c2};
        Arrays.sort(ra, new Comparator<Comp>() {
            @Override
            public int compare(Comp o1, Comp o2) {
                return o1.speed - o2.speed;
            }
        });

        for (Comp c4 : ra) {
            System.out.println(c4);
        }

    }
}
