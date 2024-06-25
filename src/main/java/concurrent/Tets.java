package concurrent;

public class Tets {
    static int i;
    private int d;
    void fr () {

    }
    class InnerTest {
        void te() {
            var i = Tets.this.d;
        }

    }

    public static void main(String[] args) {
        Tets.InnerTest innerTest = new Tets().new InnerTest();
    }
}
class Te {
    Tets t = new Tets() {
        void fr () {
            System.out.println("");
        }

    };

}
