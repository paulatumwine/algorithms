import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Arrays {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n], R = new int[n], O = new int[n];
        for (int i=0, j=n-1; i<n; i++, j--) {
            if (i==0 || j==n-1) {
                L[i] = 1;
                R[j] = 1;
                continue;
            }
            L[i] = L[i-1] * nums[i-1];
            R[j] = R[j+1] * nums[j+1];
        }
        for (int i=0; i<n; i++)
            O[i] = L[i] * R[i];
        return O;
    }

    public int[] productExceptSelfSp(int[] nums) {
        int n = nums.length;
        int[] O = new int[n];
        for (int i=0; i<n; i++) {
            if (i==0) {
                O[0] = 1;
                continue;
            }
            O[i] = O[i-1] * nums[i-1];
        }
        int R=1;
        for (int j = n-1; j>=0; j--) {
            O[j] = O[j] * R;
            R *= nums[j];
        }
        return O;
    }

    @Test
    public void testProductExceptSelf() {
        assertArrayEquals(new int[]{24,12,8,6}, productExceptSelf(new int[] {1,2,3,4}));
        assertArrayEquals(new int[]{24,12,8,6}, productExceptSelfSp(new int[] {1,2,3,4}));
    }
}
