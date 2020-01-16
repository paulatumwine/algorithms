import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println(gcd(12, 20));
        System.out.println(gcd(12, 42));
        System.out.println(gcd(7, 9));

        System.out.println(computeGcd(12, 20));
        System.out.println(computeGcd(12, 42));
        System.out.println(computeGcd(7, 9));

        System.out.println(secondSmallest(new int[]{1, 4, 2, 3}));
        System.out.println(secondSmallest(new int[]{3, 3, 4, 7}));
        // System.out.println(secondSmallest(new int[]{9}));

        print(subsetSum(new int[]{1, 3, 9, 4, 8, 5}, 21));
        print(subsetSum(new int[]{1, 3, 9}, 5));
        print(subsetSum(new int[]{1, 3, 9, 4, 8, 5}, 0));
    }

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static int gcd(int m, int n) {
        int gcd = m < n ? m/2 : n/2;
        for (int i = gcd; i > 1; i--) {
            if (m % i == 0 && n % i == 0) return i;
        }
        return 1;
        /*if (m < n) {
            for (int i = m/2; i > 1; i--) {
                if (m % i == 0 && n % i == 0) return i;
            }
        }
        for (int i = n/2; i > 1; i--) {
            if (m % i == 0 && n % i == 0) return i;
        }
        return 1;*/
    }

    /**
     * Euclidean algorithm
     * @param m
     * @param n
     * @return
     */
    static int computeGcd(int m, int n) {
        if (n == 0) return m;
        return computeGcd(n, m % n);
    }

    static int secondSmallest(int[] arr) {
        if(arr==null || arr.length < 2) {
            throw new IllegalArgumentException("Input array too small");
        }
        //implement
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if (arr[i] < secondSmallest) secondSmallest = arr[i];
        }
        return secondSmallest;
    }

    static int[] subsetSum(int[] arr, int k) {
        if (k == 0) return new int[]{};
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) return Arrays.copyOfRange(arr, i, j + 1);
                if (sum > k) break;
            }
        }
        return null;
    }
}
