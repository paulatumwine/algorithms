public class Strings {

    public static void main(String[] args) {
        System.out.println(Strings.isPalindromic("EVE"));
        System.out.println(Strings.stringToInt("-23241"));
        System.out.println(Strings.isPalindrome("A man, a plan, a canal, Panama."));
        System.out.println(Strings.isPalindrome("Ray a Ray"));
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

    public static int stringToInt(String s) {
        int result = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
            final int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }
}
