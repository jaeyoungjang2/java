import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon2529_3 {
    private static int n;
    private static String[] info;
    private static int[] tempResult;
    private static boolean[] visit = new boolean[10];
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 2
        // < >
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tempResult = new int[n + 1];
        info = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            info[i] = st.nextToken();
        }

        permutation2529(0, 0);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    private static void permutation2529(int index, int start) {
        if (index == n + 1) {
            // toDo: calculate result;
            check();
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                tempResult[index] = i;
                permutation2529(index + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    private static void check() {
        for (int i = 0; i < n; i++) {
            String throthold = info[i];
            if (throthold.equals(">") && !(tempResult[i] > tempResult[i + 1])) {
                return;
            } else if (throthold.equals("<") && !(tempResult[i] < tempResult[i + 1])) {
                return;
            }
        }

        String temp = "";
        for (int i = 0; i < n + 1; i++) {
            temp += tempResult[i];
        }
        result.add(temp);
    }
}
