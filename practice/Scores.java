import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Scores {
    Set<Integer> S = Set.of(2, 3, 6, 7, 8);

    public static void main(String[] args) {
        System.out.println(new Scores().countWaysToScore(1));
        System.out.println(new Scores().countWaysToScore(-1));
        System.out.println(new Scores().countWaysToScore(6));
        System.out.println(new Scores().countWaysToScore(5));
        System.out.println(new Scores().countWaysToScore(8));
        System.out.println(new Scores().countWaysToScore(2));
        System.out.println(new Scores().countWaysToScore(100));
    }

    public Set countWaysToScore(int score) {
        Set<List<Integer>> H = new HashSet<>();
        List<Integer> tmp;
        if (score < 2) H.add(new ArrayList<>());
        else if (score == 2 || score == 3) {
            tmp = new ArrayList<>();
            tmp.add(score);
            H.add(tmp);
        }
        else {
            for (Integer s : S) {
                if (s < score) {
                    Set<List<Integer>> T = countWaysToScore(score - s);
                    for (List<Integer> t : T) {
                        if (!t.isEmpty()) {
                            t.add(s);
                            H.add(t);
                        }
                    }
                } else if (s == score) { //6, 7 or 8
                    tmp = new ArrayList<>();
                    tmp.add(s);
                    H.add(tmp);
                }
            }
        }
        System.out.println("Debug; Score " + score + ": " + H);
        return H;
    }
}
