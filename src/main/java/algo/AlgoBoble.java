package algo;

import java.util.Arrays;

public class AlgoBoble {
    public static void main(String[] args) {
        int[] array = new int[]{3, 9, 4, 0, 67, 3, 87, 5, 2};
      //  algo.AlgoBoble.optimizedBubbleSort(array);
       //  algo.AlgoBoble.sortBob(array);
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
            System.out.println(Arrays.toString(array));

        }
    }

    public static void sortBob(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            boolean swap = true;
            for (int j = 1; j < size-i; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    swap = false;
                }
            }
            if (swap)
                break;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void optimizedBubbleSort(int[] arr) {
        int i = 0, n = arr.length;
        boolean swapNeeded = true;
        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapNeeded = true;
                }
            }
            if(!swapNeeded) {
                break;
            }
            i++;
            System.out.println(Arrays.toString(arr));
        }
    }
}
