import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11723 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] s = new boolean[21];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String problem = st.nextToken();
            if (problem.equals("add")) {
                s[Integer.parseInt(st.nextToken())] = true;
            } else if (problem.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                if (s[num]) {
                    s[num] = false;
                }
            } else if (problem.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                if (s[num]) {
                    sb.append(1 + "\n");
                    continue;
                }
                sb.append(0 + "\n");
            } else if (problem.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (s[num]) {
                    s[num] = false;
                    continue;
                }
                s[num] = true;
            } else if (problem.equals("all")) {
                for (int j = 1; j < 21; j++) {
                    s[j] = true;
                }
            } else if (problem.equals("empty")) {
                s = new boolean[21];
            }
        }
        System.out.println(sb);
    }
}
