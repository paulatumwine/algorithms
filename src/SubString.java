public class SubString {

    public static int lengthOfLongestSubstring(String s) {
        int r1 = 0, r2 = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (!sb.toString().contains(Character.toString(s.charAt(i)))) {
                sb.append(s.charAt(i));
                r1++;
                i++;
            } else {
                int idx = sb.toString().indexOf(s.charAt(i)) + 1;
                sb.replace(0, idx, "");
                r1 -= idx;
            }
            if (r1 > r2) r2 = r1;
        }
        return r2;
    }

    public static void main(String[] args) {
        System.out.println(SubString.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(SubString.lengthOfLongestSubstring("bbbbb"));
        System.out.println(SubString.lengthOfLongestSubstring("pwwkew"));
        System.out.println(SubString.lengthOfLongestSubstring("ohvhjdml"));
    }
}
