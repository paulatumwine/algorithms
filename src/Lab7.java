import java.util.LinkedList;
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
        LinkedList<Stack<Character>> queue = new LinkedList();
        for (String word: str.split(" ")) {
            Stack<Character> stack = new Stack<>();
            for (char c: word.toCharArray()) {
                stack.push(c);
            }
            queue.add(stack);
        }

        StringBuffer buf = new StringBuffer();
        while (!queue.isEmpty()) {
            Stack<Character> stack = queue.removeFirst();
            StringBuffer word = new StringBuffer();
            while (!stack.empty()) {
                buf.append(stack.pop());
            }
            buf.append(word);
            buf.append(" ");
        }
        return buf.toString();
    }
}