package algo;

import java.util.Arrays;

public class SortSelect {
    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 1, 5, 3, 9, 3, 5};
        for (int step = 0; step < array.length; step++) {
            System.out.println(Arrays.toString(array));
            int index = min(array, step);
            int term = array[step];
            array[step] = array[index];
            array[index] = term;
        }

    }

    public static int min(int[] array, int step) {
        int minValue = array[step];
        int minIndex = step;
        for (int i = step + 1; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
