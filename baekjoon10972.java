import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon10972 {
    private static String result = "-1";
    private static int n;
    private static int[] targetInfo;
    private static int[] info;
    private static int[] res;
    private static boolean[] visit;
    private static boolean nextPermutation = false;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        info = new int[n];
        targetInfo = new int[n];
        res = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            targetInfo[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            info[i] = i + 1;
        }

        combination10972(0);
        System.out.println(result);

    }

    static boolean isTarget(int[] res) {
        for (int i = 0; i < n; i++) {
            if (res[i] != targetInfo[i]) {
                return false;
            }
        }
        return true;
    }

    static void combination10972(int index) {
        if (index == n) {
            if (nextPermutation) {
                result = "";
                for (int i : res) {
                    result += i + " ";
                }
                System.out.println(result);
                System.exit(0);
            }
            if (isTarget(res)) {
                nextPermutation = true;
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                res[index] = info[i];
                combination10972(index + 1);
                visit[i] = false;
            }
        }
    }
}
