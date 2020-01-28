/**
 * Devise a dynamic programming solution for the following problem:
 * Given two strings, find the length of longest subsequence that they share in common.
 * Different between substring and subsequence:
 * Substring: the characters in a substring of S must occur contiguously in S.
 * Subsequence: the characters can be interspersed with gaps.
 * For example: Given two Strings - “regular” and “ruler”, your algorithm should output 4.
 */
public class lab10 {

    static int[][] D;

    public static void main(String[] args) {
        System.out.println(llcs("regular", "ruler"));
        System.out.println(llcs("jackass", "brass"));
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
