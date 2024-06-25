public class Mas {
    private int i;

    public Mas(int i) {
        this.i = i;
        System.out.println("Mas super const");
    }

    public Mas() {
        this(1);
    }

    void mas() {
        System.out.println("dsfsdf");
    }

}

class Mas1 extends Mas {
    Mas1() {
        System.out.println("1111");
    }

    @Override
    void mas() {
        System.out.println("qeeee");
    }

    public static void main(String[] args) {
        Mas1 mas1 = new Mas1();
    }
}
