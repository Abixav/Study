package concurrent;

public class NetWorkUtils {
    public static void main(String[] args) {
        String l;
        String e;
        do{
            l ="1";
        } while (l !=null);
        System.out.println("sd");
    }
    public static void getConnection() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }
}
