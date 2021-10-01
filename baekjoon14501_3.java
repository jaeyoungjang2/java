import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14501_3 {
    private static int n;
    private static int[] dayInfo;
    private static int[] moneyInfo;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dayInfo = new int[n];
        moneyInfo = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dayInfo[i] = Integer.parseInt(st.nextToken());
            moneyInfo[i] = Integer.parseInt(st.nextToken());
        }

        permutation14501(0, 0);
        System.out.println(max);
    }

    private static void permutation14501(int index, int res) {
        if (index == n) {
            if (res > max) {
                max = res;
            }
            // toDo : calculate result
            return;
        }

        if (index > n) {
            return;
        }

        permutation14501(index + dayInfo[index], res + moneyInfo[index]);
        permutation14501(index + 1, res);
    }
}
