import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Cars  {
    public int i;

    public Cars(int i){
        this.i = i;
    }
    public void printList(List<? extends Bus> list) {
        for (Bus fruit : list) {
            System.out.println(fruit);
        }
    }

    public static void main(String[] args) {
        Cars c = new Cars(1);
        Stack<String> animals= new Stack<>();

        // Add elements to Stack
        animals.push("Dog");
        animals.push("Bee");
        animals.push("Horse");
        animals.push("Cat");
        System.out.println("Stack: " + animals);

        // Search an element
        int position = animals.search("Bee");
        System.out.println("Position of Horse: " + position);
    }
}

class Bus {
    public int s;
    public Bus(int i , int s) {

        this.s = s;
    }
    Cars c = new Cars(1);





}
class Other extends Bus {
    public Other(int i, int s){
        super(i,s);
    }
}
