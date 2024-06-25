package algo;

public class Algo {

    public static void main(String[] args) {
        int[] array = new int[]{12,43,1,76,23,99,4};
        int minValue = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > minValue){
                minValue = array[i];
                minIndex = i;
            }
        }
        System.out.println("index: " + minIndex);
        System.out.println("value: " + minValue);
    }
}
