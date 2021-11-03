import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class baekjoon1339_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        List<String> problemInfo = new ArrayList<>();
        Map<Character, Integer> alphabetScoreMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            Integer length = temp.length();
            problemInfo.add(temp);
            for (int j = 0; j < temp.length(); j++) {

                Character alphabet = temp.charAt(j);
                if (alphabetScoreMap.containsKey(alphabet)) {
                    alphabetScoreMap.put(alphabet, (int) (alphabetScoreMap.get(alphabet) + Math.pow(10, length - 1)));
                } else {
                    alphabetScoreMap.put(alphabet, (int) Math.pow(10, length - 1));
                }
                length--;
            }
        }

        List<Entry<Character, Integer>> alphabetScoreList = new LinkedList<>(alphabetScoreMap.entrySet());
        Collections.sort(alphabetScoreList, (o1, o2) -> o2.getValue() - o1.getValue());

        Map<Character, Integer> map = new HashMap<>();
        int count = 9;
        for (Entry<Character, Integer> entry : alphabetScoreList) {
            map.put(entry.getKey(), count);
            count--;
        }

        int result = 0;
        for (String problem : problemInfo) {
            String temp = "";
            for (int i = 0; i < problem.length(); i++) {
                temp += map.get(problem.charAt(i));
            }
            result += Integer.parseInt(temp);
        }

        System.out.println(result);
    }
}
