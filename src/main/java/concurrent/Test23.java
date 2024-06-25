package concurrent;

import java.util.*;

public class Test23 {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("vov", 45);
        map.put("pop", 23);
        map.put("awa", 12);
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(7);
        list.add(2);

        var s = list.spliterator();
        ListIterator<Integer> spliterator = list.listIterator();
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m);
        }
       // Iterator<Integer> iterator = list.iterator();
        while(spliterator.hasPrevious()) {
            System.out.println(spliterator.previous());
        }


    }
    // Test23.removeDuplicates(list);


    /*public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection); // Вот и всё!
    }*/

}
