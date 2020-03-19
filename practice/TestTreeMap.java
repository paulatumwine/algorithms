import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Dog implements Comparable{
    String color;
    int size;
    Dog(String c, int s) {
        color = c;
        size = s;
    }
    public String toString(){
        return color + " dog";
    }

    @Override
    public int compareTo(Object o) {
        return  ((Dog) o).size - this.size;
    }
}

class Dog1 {
    String color;
    Dog1(String c) {
        color = c;
    }
    public boolean equals(Object o) {
        return ((Dog1) o).color == this.color;
    }
    public int hashCode() {
        return color.length();
    }
    public String toString(){
        return color + " dog";
    }
}

public class TestTreeMap {
    public static void main(String[] args) {
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("white", 40);
        TreeMap treeMap = new TreeMap();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
        for (Object en : treeMap.entrySet()) {
            Map.Entry entry = (Map.Entry) en;
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("---");
        Dog1 d5 = new Dog1("red");
        Dog1 d6 = new Dog1("black");
        Dog1 d7 = new Dog1("white");
        Dog1 d8 = new Dog1("white");
        HashMap map = new HashMap();
//        LinkedHashMap map = new LinkedHashMap();
        map.put(d5, 10);
        map.put(d6, 15);
        map.put(d7, 5);
        map.put(d8, 20);
        for (Object en : map.entrySet()) {
            Map.Entry entry = (Map.Entry) en;
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}