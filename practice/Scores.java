import java.util.*;

public class Scores {
    static List<Integer> S;
    static Map<Integer, Set<List<Integer>>> scores = new HashMap<>();

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
        return Scores.getWaysToScore(score).size();
    }
    

    public static Set getWaysToScore(int score) {
        Set<List<Integer>> H = new HashSet<>();
        List<Integer> tmp;
        if (scores.containsKey(score)) return scores.get(score);
        if (score < 2) H.add(new ArrayList<>());
        else if (score == 2 || score == 3) {
            tmp = new ArrayList<>();
            tmp.add(score);
            H.add(tmp);
        }
        else {
            for (Integer s : S) {
                if (s < score) {
                    int diff = score - s;
                    Set<List<Integer>> T = getWaysToScore(diff);
                    if (!scores.containsKey(score)) scores.put(diff, T);
                    for (List<Integer> t : T) {
                        if (!t.isEmpty()) {
                            List<Integer> list = new ArrayList<>(t);
                            list.add(s);
                            H.add(list);
                        }
                    }
                } else if (s == score) { //6, 7 or 8
                    tmp = new ArrayList<>();
                    tmp.add(s);
                    H.add(tmp);
                }
            }
        }
//        System.out.println("Debug; Score " + score + ": " + H);
        return H;
    }
}
