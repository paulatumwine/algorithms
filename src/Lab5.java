import java.util.Vector;

class Lab5 {

    public static void main(String args[]) {
        int arr[] = {2, 5, 8, 4, 6, 11};
        int sum = 13;
        System.out.println(
                getSubset(arr, arr.length, sum)
        );
    }

    // Wrapper over subsetSum()
    static Vector<Integer> getSubset(int arr[], int n, int sum) {
        Vector<Integer> v = new Vector<Integer>();
        return subsetSum(arr, n, v, sum);
    }

    // The vector v stores current subset
    static Vector<Integer> subsetSum(int arr[], int n, Vector<Integer> v, int sum) {

        if (n == 0)
            return null;

        if (sum == 0) {
            return v;
        }

        // We consider two cases for every element
        // a) We do not include last element
        Vector<Integer> subset = subsetSum(arr, n - 1, v, sum);
        if (subset == null) {
            // b) We include last element in current subset
            Vector<Integer> v1 = new Vector<>(v);
            v1.add(arr[n - 1]);
            subset = subsetSum(arr, n - 1, v1, sum - arr[n - 1]);
        }
        return subset;
    }
}