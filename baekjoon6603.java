import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon6603 {
    private static int n;
    private static int[] info;
    private static int[] res;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            info = new int[n];
            res = new int[6];
            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                info[i] = Integer.parseInt(st.nextToken());
            }
            allPermutation6603(0, 0);
            System.out.println(sb);

        }
    }

    static void allPermutation6603(int index, int start) {
        if (index == 6) {
            for (int i : res) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        if (start == n) {
            return;
        }

        for (int i = start; i < n; i++) {
            res[index] = info[i];
            allPermutation6603(index + 1, i + 1);
        }
    }
}
