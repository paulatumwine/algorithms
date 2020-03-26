import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayTests {

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

    public int[] basic_intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            for (int j=0; j<nums2.length; j++) {
                if (nums1[i] == nums2[j])
                    tmp.put(nums1[i], 1);
            }
        }
        int result[] = new int[tmp.size()], i=0;
        for(Map.Entry<Integer, Integer> e: tmp.entrySet()) {
            result[i++] = e.getKey();
        }
        return result;
    }

    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s)) output[idx++] = s;

        return Arrays.copyOf(output, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }

    public int[] bis_intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }

    @Test
    public void testIntersection() {
        assertArrayEquals(new int[]{2}, basic_intersection(new int[]{1,2,2,1}, new int[]{2,2}));
        assertArrayEquals(new int[]{4,9}, basic_intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));

        assertArrayEquals(new int[]{2}, intersection(new int[]{1,2,2,1}, new int[]{2,2}));
        assertArrayEquals(new int[]{4,9}, intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));

        assertArrayEquals(new int[]{2}, bis_intersection(new int[]{1,2,2,1}, new int[]{2,2}));
        assertArrayEquals(new int[]{4,9}, bis_intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
    }

    public int[] intersectWithDups(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersectWithDups(nums2, nums1);
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int n: nums1) {
            if (tmp.containsKey(n))
                tmp.put(n, tmp.get(n)+1);
            else
                tmp.put(n, 1);
        }
        int i=0;
        for(int n: nums2) {
            if (tmp.containsKey(n) && tmp.get(n) > 0) {
                nums1[i++] = n;
                tmp.put(n, tmp.get(n)-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, i);
    }

    @Test
    public void testIntersectionWithDups() {
        assertArrayEquals(new int[]{1}, intersectWithDups(new int[]{1,2}, new int[]{1,1}));
        assertArrayEquals(new int[]{2,2}, intersectWithDups(new int[]{1,2,2,1}, new int[]{2,2}));
//        assertEquals(Arrays.equals(new int[]{4,9}, intersectWithDups(new int[]{4,9,5}, new int[]{9,4,9,8,4})), true);
        int[] output = intersectWithDups(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println(output);
    }

}
