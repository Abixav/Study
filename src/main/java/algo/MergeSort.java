package algo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 9, 34, 76, 12, 4, 87, 23};
        sortMerge(array, array.length);

        System.out.println(Arrays.toString(array));
    }

    private static void sortMerge(int[] arr, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        int j = 0;

        for (int i = 0; i < length; i++) {
            if (i < mid) {
                left[i] = arr[i];
            } else {
                right[j] = arr[i];
                j++;
            }
        }
        sortMerge(left, mid);
        sortMerge(right, length - mid);
        merge(right, left, arr, length - mid, mid);
    }

    private static void merge(int[] right, int[] left, int[] arr, int rightLength, int leftLength) {
       int i = 0;
       int l = 0;
       int r = 0;
       while(l < leftLength && r < rightLength) {
           if (left[l] < right[r]) {
               arr[i++] = left[l++];
           } else {
               arr[i++] = right[r++];
           }
       }
       while(l < leftLength) {
           arr[i++] = left[l++];
       }
       while(r < rightLength) {
           arr[i++] = right[r++];
       }
    }

}
