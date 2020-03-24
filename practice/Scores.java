import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scores {
    static List<Integer> S;
    static Map<Integer, Integer> scores = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(Scores.countWaysToScore(1));
        System.out.println(Scores.countWaysToScore(-1));
        System.out.println(Scores.countWaysToScore(6));
        System.out.println(Scores.countWaysToScore(5));
        System.out.println(Scores.countWaysToScore(8));
        System.out.println(Scores.countWaysToScore(2));
        System.out.println(Scores.countWaysToScore(15));
        System.out.println(Scores.countWaysToScore(30));
        System.out.println(Scores.countWaysToScore(50));
    }

    public static int countWaysToScore(int score) {
        S = new ArrayList<>();
        S.add(2);
        S.add(3);
        S.add(6);
        S.add(7);
        S.add(8);
        return Scores.getWaysToScore(score);
    }

    public static Integer getWaysToScore(int score) {
        int ways = 0;

        if (scores.containsKey(score)) return scores.get(score);

        if (score < 2) ways = 0;
        else if (score == 2 || score == 3) ways++;
        else {
            for (Integer s : S) {
                if (s < score) {
                    ways += getWaysToScore(score - s);
                }
                else if (s == score) ways++; //6, 7 or 8
            }
        }
//        System.out.println("Debug; Score " + score + ": " + ways);
        if (!scores.containsKey(score)) scores.put(score, ways);
        return ways;
    }
}
