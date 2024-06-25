public class Test1 {
    public static void main(String[] args) {
        Te te = new Te();
        te.sec(new Executeble() {
            @Override
            public int start(int x, int y) {
                return 0;
            }
        });
        te.sec((x, y) -> x + y);

    }

}

class Te {
    public int sec(Executeble executeble) {
        int i = executeble.start(1, 5);
        return i;
    }
}
