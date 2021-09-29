import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon10819 {
    private static int n;
    private static int[] info;
    private static int[] res;
    private static boolean[] visit;
    private static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new int[n];
        res = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
        allPermutation10819(0);
        System.out.println(result);
    }

    private static void allPermutation10819(int index) {
        if (index == n) {
            // toDo : calculate result
            int tempResult = 0;
            int first = res[0];
            for (int i = 1; i < n; i++) {
                int second = res[i];
                tempResult += Math.abs(second - first);
                first = second;
            }
            if (tempResult > result) {
                result = tempResult;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                res[index] = info[i];
                allPermutation10819(index + 1);
                visit[i] = false;
            }

        }

    }
}
