import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14889_2 {
    private static int[][] info;
    private static int[] team1Member;
    private static int[] team2Member;
    private static int n;
    private static boolean[] visit;
    private static int minDifference;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        info = new int[n][n];
        team1Member = new int[n / 2];
        team2Member = new int[n / 2];
        visit = new boolean[n];
        minDifference = 20 * n;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team1Member[0] = 0;
        visit[0] = true;
        permutation14889(1, 0);
        System.out.println(minDifference);
    }

    private static void permutation14889(int index, int start) {
        if (index == n / 2) {
            int team2Index = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    team2Member[team2Index] = i;
                    team2Index++;
                }
            }

            int team1 = 0;
            int team2 = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i != j) {
                        team1 += info[team1Member[i]][team1Member[j]];
                        team2 += info[team2Member[i]][team2Member[j]];
                    }
                }
            }

            minDifference = Math.min(Math.abs(team2 - team1), minDifference);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                team1Member[index] = i;
                permutation14889(index + 1, i + 1);
                visit[i] = false;
            }

        }
    }
}
