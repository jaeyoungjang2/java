import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon2529_5 {
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
            String temp = "";
            for (int i : result) {
                temp += Integer.toString(i);
            }
            resultList.add(temp);
            return;
        }

        for (int i = 0; i < 10; i++) {
            result[index] = i;
            if (!visit[i] && checkCodition2529_4(index, result)) {
                visit[i] = true;
                bruteForce2529(index + 1, result);
                visit[i] = false;
            }
        }
    }

    private static boolean checkCodition2529_4(int index, int[] result) {
        if (info[index - 1].equals(">") && result[index - 1] > result[index]) {
            return true;
        }
        if (info[index - 1].equals("<") && result[index - 1] < result[index]) {
            return true;
        }
        return false;
    }
}