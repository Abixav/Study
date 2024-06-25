public class Sup {
    int a;
    public void m(){
        System.out.println("super");
    }
}
class Sub extends Sup{
    public void s(){
        super.m();
    }
    public static void main(String[] args) {
        String n = "a";
        String b = "b";
        System.out.println(n.equals(b));
        }
    }

