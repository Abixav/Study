public class Test {
    static int a;
    public int b;

    static {
        a = 6;
    }
    public Test(int b){
        this.b = b;
    }

    public static void main(String[] args) {
        Test t = new Test(7);
        Test t1  = new Test(1);
        System.out.println(t.a+ ":" + t.b);
        System.out.println(t1.a+":"+t1.b);
    }

 }
