import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon2529_4 {
    private static ArrayList<String> resultList = new ArrayList<>();
    private static int n;
    private static String[] info;
    private static boolean[] visit = new boolean[10];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        info = new String[n];
        int[] result = new int[n + 1];

        for (int i = 0; i < n; i++) {
            info[i] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            result[0] = i;
            bruteForce2529(1, result);
            visit[i] = false;
        }

        Collections.sort(resultList);
        String min = resultList.get(0);
        String max = resultList.get(resultList.size() - 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void bruteForce2529(int index, int[] result) {
        if (index == n + 1) {
            if (checkCondition2529(result)) {
                String temp = "";
                for (int i : result) {
                    temp += Integer.toString(i);
                }
                resultList.add(temp);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[index] = i;
                bruteForce2529(index + 1, result);
                visit[i] = false;
            }
        }
    }

    private static boolean checkCondition2529(int[] result) {
        for (int i = 0; i < n; i++) {
            if (info[i].equals(">") && result[i] <= result[i + 1]) {
                return false;
            }
            if (info[i].equals("<") && result[i] >= result[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
