import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> H = new HashMap<>();
        int l = 0;
        for(int i=0; i<nums.length; i++) {
            H.put(nums[i], 0);
            if (nums[i] > l) l = nums[i];
        }
        for(int i=1; i<l; i++) {
            if (H.get(i) == null) return i;
        }
        return l+1;
    }

    @Test
    public void testFirstMissingPositive() {
        assertEquals(3, firstMissingPositive(new int[]{1,2,0}));
        assertEquals(2, firstMissingPositive(new int[]{3,4,-1,1}));
        assertEquals(1, firstMissingPositive(new int[]{7,8,9,11,12}));
    }

}
