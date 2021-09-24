import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15651 {
    private static int[] info;
    private static int[] res;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        info = new int[n];
        res = new int[m];

        for (int i = 0; i < n; i++) {
            info[i] = i + 1;
        }
        combination15651(0, n, m);
        System.out.println(sb);
    }

    private static void combination15651(int index, int n, int m) {

        if (index == m) {

            for (int i : res) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            res[index] = info[i];
            combination15651(index + 1, n, m);
        }
    }
}
