import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class baekjoon1759_2 {
    private static StringBuilder sb = new StringBuilder();
    private static List<String> info = new ArrayList<>();
    private static List<String> checkList = Arrays.asList("a", "e", "i", "o", "u");
    private static String[] res;
    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        // 4 6
        // a t c i s w
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            info.add(st.nextToken());
        }

        info = info.stream().sorted().collect(Collectors.toList());
        permutation1759(0, 0);
        System.out.println(sb);
    }

    private static void permutation1759(int index, int start) {

        if (index == n) {
            if (!check()) {
                return;
            }
            for (String string : res) {
                sb.append(string);
            }
            sb.append("\n");
            // toDo : result calculation
            return;
        }

        if (start == m) {
            return;
        }

        for (int i = start; i < m; i++) {
            res[index] = info.get(i);
            permutation1759(index + 1, i + 1);
        }
    }

    private static boolean check() {
        int mo = 0;
        for (String string : res) {
            if (checkList.contains(string)) {
                mo++;
            }
        }
        if (mo >= 1 && n - mo >= 2) {
            return true;
        }
        return false;
    }
}
