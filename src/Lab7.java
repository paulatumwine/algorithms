import java.util.Stack;

class Lab7 {

    public static void main(String args[]) {
        String str = "we test coders";
        System.out.println(reverse(str));
    }

    static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray()) {
            stack.push(c);
        }
        StringBuffer buf = new StringBuffer();
        while (!stack.empty()) {
            buf.append(stack.pop());
        }
        return buf.toString();
    }
}