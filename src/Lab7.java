import java.util.Stack;

/**
 * Devise an O(n) algorithm to accomplish this task:
 * Given a none-empty string S of length n, S consists some words
 * separated by spaces. We want to reverse every word in S.
 *
 * For example, given S = “we test coders”, your algorithm is going
 * to return a string with every word in S reversed and separated
 * by spaces. So the result for the above example would be “ew tset sredoc”
 */
class Lab7 {

    public static void main(String args[]) {
        String str = "we test coders";
        System.out.println(reverse(str));
    }

    static String reverse(String str) {
        char[] strArr = str.toCharArray();
        StringBuffer buf = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == ' ' || i == strArr.length - 1) {
                while (!stack.empty())
                    buf.append(stack.pop());
                buf.append(" ");
            } else stack.push(strArr[i]);
        }
        return buf.toString();
    }
}