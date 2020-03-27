import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

class Roman {
    static Map<Integer, String> nums = new LinkedHashMap<>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    private static int getClosestKey(int num) {
        // if (num>=1 && num<4) return 1;
        // else if (num>4 && num<9) return 5;
        // else if (num>10 && num<40) return 10;
        // else if (num>50 && num<90) return 50;
        // else if (num>=90 && num<100) return 90;
        // else if (num>100 && num<400) return 100;
        // else if (num>500 && num<900) return 500;
        // else return num;

        int lower = 1;
        for(Map.Entry<Integer, String> e: nums.entrySet()) {
            if (num >= lower && num < e.getKey())
                return lower;
            lower = e.getKey();
        }
        return lower;
    }

    public static String intToRoman(int num) {
        if (nums.containsKey(num))
            return nums.get(num);
//        int n = getClosestKey(num);
        int n = 1;
        for(Map.Entry<Integer, String> e: nums.entrySet()) {
            if (num >= n && num < e.getKey()) break;
            n = e.getKey();
        };
        return nums.get(n) + intToRoman(num - n);
    }

    public static void main(String[] args) {
        assertEquals("XXVIII", intToRoman(28));
        assertEquals("MCMXCIV", intToRoman(1994));
    }
}
