package algo;

import java.util.Arrays;

public class QuickSort2 {
    public static void quickSort(int[] array, int from, int to) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (from >= to)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = from + (to - from) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = from;
        int j = to;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (from < j)
            quickSort(array, from, j);

        if (to > i)
            quickSort(array, i, to);
    }

    public static void main(String[] args) {
        int[] x = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }
}
