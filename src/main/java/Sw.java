class T {
    int i ;
    public T(int i){
        this.i = i;
    }
    public T(){
        this(2);
    }
    public void t(){
        System.out.println("bla-bla");
    }
    public void t1(int i, double... y){
        System.out.println("ty-tu");
        this.t();
    }
}
public class Sw {
    public static void main(String[] args) {
        T t = new T();
        t.t1(1, 2.3, 3.1, 4.3);
        System.out.println(t.i);

    }

    public static void st() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
    }

    public static void sa() {
        int x = 0;
        while (x < 10) {
            x++;
            if (x == 5) {
                continue;
            }
            System.out.println(x);
        }
    }

    public static void sq() {
        int x = 0;
        do {
            x++;
            if (x == 5) {
                continue;
            }
            System.out.println(x);
        } while (x<10);
    }
}
