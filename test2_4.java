import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test2_4 {
    private static int n;
    private static int m;
    private static int k;
    private static ArrayList<String> testCase = new ArrayList<>();
    private static int[] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        info = new int[n];

        int[][] info = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        broot(0);

        for (String test : testCase) {
            System.out.println(test);
        }

    }

    private static void broot(int index) {
        if (index == n - 1) {
            int total = 0;
            String temp = "";

            for (int i = 0; i < n - 1; i++) {
                total += i;
            }

            if (k - total < 0) {
                return;
            }

            info[index] = k - total;
            for (int i : info) {
                temp += Integer.toString(i);
            }

            testCase.add(temp);
            return;
        }

        for (int i = 0; i < k + 1; i++) {
            info[index] = i;
            broot(index + 1);
        }
    }
}
