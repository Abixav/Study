package algo;

public class Randomalgo {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[]{1, 2, 4, 5, 6, 7, 8, 9,10};
        int sumAll = (n*(n+1))/2;
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        if (sumAll != sum){
            System.out.println("not have: " + (sumAll - sum));
        } else {
            System.out.println("all numbers have");
        }
       /* int count = array[1] - array[0];
        for (int i = 1; i < array.length-1; i++) {
            if( count != array[i+1] - array[i]){
               int res = array[i] + count;
                System.out.println(res);
            }

        }*/
    }

}
