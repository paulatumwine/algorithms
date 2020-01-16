import java.util.*;

public class Lab2 {

    public static void main(String[] args) {
        int[] result = merge(new int[]{1, 4, 5, 8, 17}, new int[]{2, 4, 8, 11, 13, 21, 23, 25});
        System.out.println(Arrays.toString(result));
        List<Set<Integer>> powerSet = powerSetWithListIterator(List.of(1, 2, 3));
        System.out.println(powerSet);
    }

    static List<Set<Integer>> powerSetWithListIterator(List<Integer> X) {
        List<Set<Integer>> P = new ArrayList<>();
        Set<Integer> S = new HashSet<>();
        P.add(S);
        for (Integer f: X) {
            /*for (Set<Integer> x: P) {
                Set<Integer> T = new HashSet<>(x);
                T.addAll(Set.of(f));
                P.add(T); // throws java.util.ConcurrentModificationException
                System.out.println(T);
            }*/
            for (ListIterator<Set<Integer>> iterator = P.listIterator(); iterator.hasNext(); ) {
                Set<Integer> x = iterator.next();
                Set<Integer> T = new HashSet<>(x);
                T.addAll(Set.of(f));
//                System.out.println(T);
                iterator.add(T);
            }
        }
        return P;
    }

    static List<Set<Integer>> powerSetByReplacement(List<Integer> X) {
        List<Set<Integer>> P = new ArrayList<>();
        Set<Integer> S = new HashSet<>();
        P.add(S);
        for (Integer f : X) {
            List<Set<Integer>> nP = new ArrayList<>();
            for (Set<Integer> x : P) {
                nP.add(x);
                Set<Integer> nS = new HashSet<>(x);
                nS.add(f);
                nP.add(nS);
            }
            P = nP;
        }
        return P;
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int arr3[] = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        if (i < m) {
            for (int p = i; p < m; p++) {
                arr3[k] = arr1[p];
                k++;
            }
        } else {
            for (int p = j; p < n; p++) {
                arr3[k] = arr2[p];
                k++;
            }
        }
        return arr3;
    }
}
