import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1182_2 {
    private static int n;
    private static int[] info;
    private static ArrayList<Integer> result = new ArrayList<>();
    private static int res;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        res = Integer.parseInt(st.nextToken());
        info = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
        permutation1182(0, 0);
        System.out.println(count);
    }

    private static void permutation1182(int index, int start) {
        if (start == n + 1) {
            // System.out.println(result);
            return;
        }
        if (result.size() != 0) {
            int total = 0;
            for (int i : result) {
                total += i;
            }
            if (total == res) {
                count++;
            }

        }

        for (int i = start; i < n; i++) {
            result.add(info[i]);
            permutation1182(index + 1, i + 1);
            result.remove(result.size() - 1);
        }
    }
}
