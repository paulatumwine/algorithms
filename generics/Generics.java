import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generics<K,V> {

    public <T> int countOccurrences(T[] arr, T target) {
        int count = 0;
        if (target == null) {
            for (T item : arr) {
                if (item == null) {
                    count++;
                }
            }
        } else {
            for (T item : arr) {
                if (target.equals(item)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) {
            ints.add(i);
        }
    }

    public static <T extends Comparable<? super T>> T max(List<T> list) {
        T max = list.get(0);
        for (T t: list) {
            if (t.compareTo(max) > 0) max = t;
        }
        return max;
    }

    public static void main(String[] args) {
        Generics p = new Generics();
        System.out.println(p.countOccurrences(new String[] {"one", "two"}, "one"));

//        List<? extends Number> nums = new ArrayList<Number>();
        List<Number> nums = new ArrayList<Number>();
        nums.add(1);
        List<Integer> ints = java.util.Arrays.asList(1, 2);
        List<Double> doubles = java.util.Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(doubles);
        System.out.println(nums);

        List<? super Integer> test = new ArrayList<>();
        test.add(5);
//        Number i = test.get(0);
        Object i = test.get(0);
        System.out.println(i);

        List<Integer> ints1 = new ArrayList<>();
        count(ints1, 5);
        System.out.println(ints1);

        List<Number> ints2 = new ArrayList<>();
        count(ints2, 5);
        ints2.add(5.0);
        System.out.println(ints2);

        List<Object> ints3 = new ArrayList<>();
        count(ints3, 5);
        ints3.add("Greetings");
        System.out.println(ints3);

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2019, 1,1));
        dates.add(LocalDate.of(2019, 1,2));
        LocalDate mostRecent = max(dates);
        System.out.println(mostRecent);
    }
}
