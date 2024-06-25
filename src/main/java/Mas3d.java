import java.util.ArrayList;

public class Mas3d {
    public static void main(String[] args) {
        ArrayList<String> d = new ArrayList<>();

        int[][][] arr = {
                {{1, 2}, {2, 3}},
                {{4, 5}, {6, 7}}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int z = 0; z < arr[j].length; z++) {
                    System.out.print(arr[i][j][z]);
                }
            }
        }
    }
}
