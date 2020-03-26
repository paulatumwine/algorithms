import java.util.*;

public class Lab2 {

    public static void main(String[] args) {
        int[] result = merge(new int[]{1, 4, 5, 8, 17}, new int[]{2, 4, 8, 11, 13, 21, 23, 25});
//        System.out.println(Arrays.toString(result));
//        List<Set<Integer>> powerSet = powerSetWithListIterator(List.of(1, 2, 3));
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        List<Set<Integer>> powerSet = powerSetWithForLoop(list);
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

    static List<Set<Integer>> powerSetWithForLoop(List<Integer> X) {
        List<Set<Integer>> P = new ArrayList<>();
        Set<Integer> S = new HashSet<>();
        P.add(S);
        if (X.isEmpty()) return P;
        while (!X.isEmpty()) {
            Integer f = X.remove(0);
            int size = P.size();
            for (int i = 0; i < size; i++) {
                Set<Integer> T = new HashSet<>();
                T.addAll(P.get(i));
                T.add(f);
                System.out.println(T);
                P.add(T);
            }
        }
        return P;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();

        List<Integer> subset = new ArrayList<>();
        powerSet.add(subset);
        if (nums.length == 0) return powerSet;

        for (int j=0; j<nums.length; j++) {
            int size = powerSet.size();
            for (int i = 0; i < size; i++) {
                subset = new ArrayList<>(powerSet.get(i));
                subset.add(nums[j]);
                powerSet.add(subset);
            }
        }
        return powerSet;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<>(curr){{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
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
        int arr3[] = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length)
            if (arr1[i] <= arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];

        while (i < arr1.length)
            arr3[k++] = arr1[i++];

        while (j < arr2.length)
            arr3[k++] = arr2[j++];
        return arr3;
    }
}
