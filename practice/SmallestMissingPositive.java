// Java program to find the smallest
// positive missing number

class SmallestMissingPositive {

    /* Utility function that puts all non-positive
    (0 and negative) numbers on left side of
    arr[] and return count of such numbers */
    static int segregate(int arr[], int size)
    {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    /* Find the smallest positive missing
    number in an array that contains
    all positive integers */
    static int findMissingPositive(int arr[], int size)
    {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for (i = 0; i < size; i++)
            if (arr[i] > 0)
                return i + 1; // 1 is added becuase indexes
        // start from 0

        return size + 1;
    }


    /* Find the smallest positive missing
    number in an array that contains
    all positive integers */
    static int findMissingPositiveAlt(int arr[], int offset)
    {
        int size = arr.length;

        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] + offset] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for (i = offset; i < size; i++) {
            int x = Math.abs(arr[i]);
            int val = ((long)x + offset) > Integer.MAX_VALUE ? x : x + offset;
            int idx = val - 1;
            if (idx < size && arr[idx] > 0)
                arr[idx] = -arr[idx];
        }

        // Return the first index value at which
        // is positive
        for (i = offset; i < size; i++)
            if (arr[i] > 0)
                return i - offset + 1; // 1 is added because indexes
        // start from 0

        return size - offset + 1;
    }

    /* Find the smallest positive missing
    number in an array that contains
    both positive and negative integers */
    static int findMissing(int arr[], int size)
    {
        // First separate positive and
        // negative numbers
        int shift = segregate(arr, size);
        /*int arr2[] = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);*/
        return findMissingPositiveAlt(arr, shift);
    }
    // main function
    public static void main(String[] args)
    {
        int arr[] = { 0, 10, 2, -10, -20 };
        int missing = findMissing(arr, arr.length);
        System.out.println("The smallest positive missing number is " + missing);

        arr = new int[]{7,8,9,11,12};
        missing = findMissing(arr, arr.length);
        System.out.println("The smallest positive missing number is " + missing);

        arr = new int[]{3,4,-1,1};
        missing = findMissing(arr, arr.length);
        System.out.println("The smallest positive missing number is " + missing);

        arr = new int[]{1,2,0};
        missing = findMissing(arr, arr.length);
        System.out.println("The smallest positive missing number is " + missing);

        arr = new int[]{2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648};
        missing = findMissing(arr, arr.length);
        System.out.println("The smallest positive missing number is " + missing);
    }
}
