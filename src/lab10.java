import java.util.ArrayList;
import java.util.List;

/**
 * Devise a dynamic programming solution for the following problem:
 * Given two strings, find the length of longest subsequence that they share in common.
 * Different between substring and subsequence:
 * Substring: the characters in a substring of S must occur contiguously in S.
 * Subsequence: the characters can be interspersed with gaps.
 * For example: Given two Strings - “regular” and “ruler”, your algorithm should output 4.
 *
 * Devise a dynamic programming solution for the following problem:
 * Given a positive integer n, find the least number of perfect square numbers which sum to n.
 * (Perfect square numbers are 1, 4, 9, 16, 25, 36, 49, …)
 * For example, given n = 12, return 3; (12 = 4 + 4 + 4)
 * Given n = 13, return 2; (13 = 4 + 9)
 * Given n = 67 return 3; (67 = 49 + 9 + 9)
 */
public class lab10 {

    static int[][] D;

    public static void main(String[] args) {
        System.out.println(llcs("regular", "ruler"));
        System.out.println(llcs("jackass", "brass"));

        System.out.println(squares(12));
        System.out.println(squares(13));
        System.out.println(squares(67));

        System.out.println(getMinSquares(12));
        System.out.println(getMinSquares(13));
//        System.out.println(getMinSquares(67));

        System.out.println(lnps(12));
        System.out.println(lnps(13));
//        System.out.println(lnps(67));

        System.out.println(lnspdpw(12));
        System.out.println(lnspdpw(13));
        System.out.println(lnspdpw(67));
    }

    static int[] A;
    static int lnspdpw(int n) {
        A = new int[n];
        return lnpsdp(n);
    }

    static int lnpsdp(int n) {
        System.out.println("Computing for n = "+n);
        List<Integer> S = new ArrayList<>();
        for (int i = 1; i*i <= n; i++)
            S.add(i*i);
        if (S.contains(n)) return 1;
        int res = n;
        for (int s: S) {
            int diff = n - s;
            if (A[diff] == 0) A[diff] = lnpsdp(diff) + 1;
            res = Math.min(res, A[diff]);
        }
        return res;
    }

    static int lnps(int n) {
        System.out.println("Computing for n = "+n);
        List<Integer> S = new ArrayList<>();
        for (int i = 1; i*i <= n; i++)
            S.add(i*i);
        if (S.contains(n)) return 1;
        int res = n;
        for (int s: S)
            res = Math.min(res, lnps(n - s)+ 1);
        return res;
    }

    // Returns count of minimum squares that sum to n
    static int getMinSquares(int n)
    {
        // base cases
        if (n <= 3)
            return n;

        // getMinSquares rest of the table using recursive
        // formula
        int res = n; // Maximum squares required is
        // n (1*1 + 1*1 + ..)

        // Go through all smaller numbers
        // to recursively find minimum
        for (int x = 1; x <= n; x++) {
            int temp = x * x;
            if (temp > n)
                break;
            else
                res = Math.min(res, 1 + getMinSquares(n - temp));
        }
        return res;
    }

    static List<Integer> squares(int n) {
        List<Integer> S = new ArrayList<>();
        for (int i = 1; i*i <= n; i++)
            S.add(i*i);
        List<Integer> set = new ArrayList<>();
        int last = S.get(S.size() - 1);
        if (last == n) {
            set.add(n);
            return set;
        }
        int diff = n - last;
        if (diff > n) {
            set.add(last);
            set.addAll(squares(n));
            return set;
        } else {
            set.add(last);
            set.addAll(squares(diff));
            return set;
        }
    }

    static int llcs(String A, String B) {
        int i = A.length() + 1;
        int j = B.length() + 1;
        D = new int[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                D[k][l] = -1;
            }
        }
        return llcsdp(A, B);
    }

    static int llcsdp(String A, String B) {
        int i = A.length();
        int j = B.length();
        if (i == 0 || j == 0) return 0;
        if (D[i][j] != -1) return D[i][j];
        if (A.charAt(i-1) == B.charAt(j-1)) { // last character in string
            if (D[i-1][j-1] == -1)
                D[i-1][j-1] = llcsdp(A.substring(0, i-1), B.substring(0, j-1));
            D[i][j] = 1 + D[i-1][j-1];
        } else {
            if (D[i-1][j-1] == -1)
                D[i-1][j-1] = llcsdp(A.substring(0, i-1), B.substring(0, j-1));
            if (D[i-1][j] == -1)
                D[i-1][j] = llcsdp(A.substring(0, i-1), B.substring(0, j));
            D[i][j] = D[i-1][j] > D[i-1][j-1] ? D[i-1][j] : D[i-1][j-1];
        }
        return D[i][j];
    }
}
