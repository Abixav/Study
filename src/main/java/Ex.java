public class Ex {
    public static void main(String[] args) {
        execv();
        ex();

    }
    public static void ex(){
        System.out.println("ehy");
    }

    public static void execv(){
        try{
            int i = 3/0;

        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
