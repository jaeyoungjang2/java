import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class baekjoon15663 {
    private static int n;
    private static int m;
    private static List<Integer> info;
    private static int[] res;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visit;
    private static Map<String, Integer> store = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        res = new int[m];
        visit = new boolean[n];

        String[] string = br.readLine().split(" ");
        info = Arrays.stream(string).map(s -> Integer.parseInt(s)).sorted().collect(Collectors.toList());

        combination15663(0, 0);
        System.out.println(sb);
    }

    private static boolean isDuplicate(String string) {
        if (store.containsKey(string)) {
            return true;
        }
        store.put(string, 0);
        return false;

    }

    private static void combination15663(int index, int start) {
        if (index == m) {
            String string = "";
            for (Integer integer : res) {
                string += integer + " ";
            }
            if (!isDuplicate(string)) {
                sb.append(string + "\n");
            }

            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                res[index] = info.get(i);
                visit[i] = true;
                combination15663(index + 1, start);
                visit[i] = false;
            }
        }
    }
}
