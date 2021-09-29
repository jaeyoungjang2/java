import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon10971 {
    private static int n;
    private static int[][] info;
    private static int[] resultInfo;
    private static int result;
    private static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        info = new int[n][n];
        resultInfo = new int[n];
        visit = new boolean[n];
        result = 1_000_000 * n;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        resultInfo[0] = 0;
        visit[0] = true;
        allPermutation10971(1);
        System.out.println(result);
    }

    private static void allPermutation10971(int index) {
        if (index == n) {

            // toDo : calculate result;
            int tempResult = 0;
            int first = resultInfo[0];
            int second = resultInfo[1];
            for (int i = 1; i < n; i++) {
                second = resultInfo[i];
                int temp = info[first][second];
                if (temp == 0) {
                    return;
                }
                tempResult += temp;
                if (tempResult > result) {
                    return;
                }
                first = second;
            }

            int temp = info[second][0];
            if (temp == 0) {
                return;
            }
            tempResult += temp;
            if (tempResult < result) {
                result = tempResult;
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                resultInfo[index] = i;
                allPermutation10971(index + 1);
                visit[i] = false;
            }
        }
    }
}
