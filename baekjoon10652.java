import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10652 {
    private static int n;
    private static int m;
    private static int[] res;
    private static int[] info;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");

        n = Integer.parseInt(string[0]);
        m = Integer.parseInt(string[1]);
        info = new int[n];
        res = new int[m];

        for (int i = 0; i < n; i++) {
            info[i] = i + 1;
        }

        combination10652(0, 0);
        System.out.println(sb);
    }

    private static void combination10652(int index, int start) {
        if (index == m) {
            for (int i : res) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            res[index] = info[i];
            combination10652(index + 1, i);
        }
    }
}
