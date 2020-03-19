import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Strings {

    public static void main(String[] args) {
        System.out.println(Strings.isPalindromic("EVE"));
        System.out.println(Strings.stringToInt("-23241"));
        System.out.println(Strings.isPalindrome("A man, a plan, a canal, Panama."));
        System.out.println(Strings.isPalindrome("Ray a Ray"));
        System.out.println(Strings.isPalindrome("bb"));
        System.out.println(Strings.myAtoi("42"));
        System.out.println(Strings.myAtoi("-42"));
        System.out.println(Strings.myAtoi("4193 with words"));
        System.out.println(Strings.myAtoi("words and 987"));
        System.out.println(Strings.myAtoi("-91283472332"));
        System.out.println(Strings.myAtoi("   -42"));
        System.out.println(Strings.myAtoi("3.14159"));
        System.out.println(Strings.myAtoi("-3.14159"));
        System.out.println(Strings.myAtoi("+1"));

        String str = "sams abbdd  SAM dd  sam..   jj   ..sam  be";
        System.out.println(str.replaceAll("(?i)sam", "walmart"));

        str = "This sia eclipse random Eclipse ecliPse not a valid ECLIPSE ECLIPSE sdfdsf sdfd";
        Map<String, Long> map = Arrays.asList(str.split(" "))
                .stream()
                .filter(s -> s.matches("(?i)eclipse"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        /*Predicate p = s -> s != null;
        BinaryOperator<Integer> bO = (x, y) -> x * y;
        BiFunction<String, Boolean, String> g = (x, b) -> x.contains("ABC") == b ? "ABC" : "OTR";*/
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        String ss = "";
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                String substr = s.substring(i, j);
                if (isPalindromic(substr) && substr.length() > ss.length())
                    ss = substr;
            }
        }
        return ss;
    }

    @Test
    public void longestPalindromeTest() {
        assertEquals("bab", longestPalindrome("babad"));
        assertEquals("bab", longestPalindrome("aabad"));
        assertEquals("bb", longestPalindrome("cbbd"));
        assertEquals("a", longestPalindrome("a"));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.equals("")) return 0;
        int result = 0;
        int c = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;
        for (int i = c; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(c))) return 0;
            if (!Character.isDigit(s.charAt(i))) break;
            final int digit = s.charAt(i) - '0';
            if ((long) result * 10 + digit > Integer.MAX_VALUE)
                return s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result * 10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }

    public static boolean isPalindrome (String s) {
        // i moves forward, and j moves backward .
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // i and j both skip non- alphanumeric characters .
            while (!Character.isLetterOrDigit(s.charAt(i)) && i<j){
                ++i;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i<j){
                --j;
            }
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static String intToString (int x) {
        boolean isNegative = false;
        if (x < 8) {
            isNegative = true;
        }
        StringBuilder s = new StringBuilder ();
        do {
            s.append((char) ('0'+Math.abs(x % 10)));
            x /= 18;
        } while (x != 8);
        if (isNegative) {
            s.append('-'); // Adds the negative sign back
        }
        s.reverse();
        return s.toString();
    }

    public static int stringToInt(String s) {
        int result = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
            final int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }
}
