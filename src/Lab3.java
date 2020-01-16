import java.util.Arrays;

/**
 * An array A holds n integers, and all integers in A belong to the
 * set {0, 1, 2}. Describe an O(n) sorting algorithm for putting A in sorted order. Your
 * algorithm may not make use of auxiliary storage such as arrays or hashtables (more
 * precisely, the only additional space used, beyond the given array, is O(1)). Give an
 * argument to explain why your algorithm runs in O(n) time.
 *
 *You are given a length-n array A consisting of 0s and 1s,
 * arranged in sorted order. Give an o(n) algorithm that counts the total number of 0s
 * and 1s in the array. Your algorithm may not make use of auxiliary storage such as
 * arrays or hashtables (more precisely, the only additional space used, beyond the given
 * array, is O(1)).
 */
public class Lab3 {

    public static void main(String[] args) {
        int[] sample = new int[]{0, 2, 1, 0, 1, 2, 2, 1, 0, 2, 1};
        int[] sortedSample = countingSort(sample);
        System.out.println(Arrays.toString(sortedSample));

        int[] sample1 = new int[] {0, 0, 0, 1, 1, 1, 1, 1, 1};
//        int[] sample1 = new int[] {0, 0, 0, 1, 1};
//        int[] sample1 = new int[] {0, 0, 1, 1};
//        int[] sample1 = new int[] {1, 1, 1};
//        int[] sample1 = new int[] {0, 0, 0};
//        int[] sample1 = new int[] {1, 1};
//        int[] sample1 = new int[] {0, 0};
//        int[] sample1 = new int[] {1};
//        int[] sample1 = new int[] {0};
//        int[] sample1 = new int[] {};
        int[] counts = countOfZerosAndOnes(sample1);
        System.out.printf("Count of 1's: %d\n", counts[1]);
        System.out.printf("Count of 0's: %d\n", counts[0]);
    }

    static int[] countOfZerosAndOnes(int[] arr) {
        int index = findFirstOccurrenceOfOne(arr, 0, arr.length - 1);
        if (index == -1) return new int[] {arr.length, 0};
        else return new int[] {index, arr.length - index};
    }

    static int findFirstOccurrenceOfOne(int[] arr, int start, int end) {
        int len = end - start;
        if (len == 0) return arr[start] == 1 ? start : -1;
        if (len == 1) return arr[start] == 1 ? start : arr[end] == 1 ? end : -1;
        int mid = (start + end) / 2;
        if (arr[mid] == 1 && arr[mid - 1] == 0) return mid;
        if (arr[mid - 1] != 0) return findFirstOccurrenceOfOne(arr, start, mid - 1);
        else return findFirstOccurrenceOfOne(arr, mid + 1, end);
    }

    static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                int tmp = arr[i];
                arr[i] = arr[0];
                arr[0] = tmp;
            }
            if (arr[i] == 2) {
                int tmp = arr[i];
                arr[i] = arr[len - 1];
                arr[len - 1] = tmp;
            }
        }
        return arr;
    }

    static int[] countingSort(int[] arr) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) a++;
            if (arr[i] == 1) b++;
            if (arr[i] == 2) c++;
        }
        for (int i = 0; i < a; i++) {
            arr[i] = 0;
        }
        for (int i = a; i < a + b; i++) {
            arr[i] = 1;
        }
        for (int i = a + b; i < a + b + c; i++) {
            arr[i] = 2;
        }
        return arr;
    }
}
