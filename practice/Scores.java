import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scores {
    static List<Integer> S;
    static Map<Integer, Integer> scores = new HashMap<>();

    public static void main(String[] args) {

        Assert.assertEquals(0, Scores.countWaysToScore(1));
        Assert.assertEquals(0, Scores.countWaysToScore(-1));
        Assert.assertEquals(3, Scores.countWaysToScore(6));
        Assert.assertEquals(2, Scores.countWaysToScore(5));
        Assert.assertEquals(7, Scores.countWaysToScore(8));
        Assert.assertEquals(1, Scores.countWaysToScore(2));
        Assert.assertEquals(92, Scores.countWaysToScore(15));
        Assert.assertEquals(28542, Scores.countWaysToScore(30));
        Assert.assertEquals(59651728, Scores.countWaysToScore(50));
        System.out.println("All clear");
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
