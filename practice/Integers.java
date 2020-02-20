import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Integers {

    public static int reverse(int x) {
        int m = x, s = 0;
        for (int i = 0; i*10 <= Math.abs(x); i++) {
            final int k = m % 10;
            m = m / 10;
            if ((long) s * 10 + k > Integer.MAX_VALUE
                    || (long) s * 10 + k < Integer.MIN_VALUE) return 0;
            s = (s * 10) + k;
            if (m == 0) break;
        }
        return s;
    }

    public static void main(String[] args) {
        assert reverse(123) == 321;
        assert reverse(-123) == -321;
        assertEquals(21, reverse(120));
    }

    @Test
    public void reverseTest() {
        assert reverse(123) == 321;
        assert reverse(-123) == -321;
        assertEquals(21, reverse(120));
        assertEquals(1, reverse(10));
        assertEquals(109, reverse(901000));
        assertEquals(0, reverse(1534236469));
        assertEquals(0, reverse(-1563847412));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return x == reverse(x);
    }


    @Test
    public void isPallindromeTest() {
        assert true == isPalindrome(121);
        assert false == isPalindrome(-121);
        assert false == isPalindrome(10);
    }
}
