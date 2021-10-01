import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon15661 {
    private static int n;
    private static int[][] info;
    private static List<Integer> teamA;
    private static boolean[] visit;
    private static int difference;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new int[n][n];
        teamA = new ArrayList<>();
        visit = new boolean[n];
        difference = 100 * n;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit[0] = true;
        teamA.add(0);
        permutation15661(1, 1);
        System.out.println(difference);

    }

    private static void permutation15661(int index, int start) {
        calculateResult();

        if (index == n) {
            return;
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            teamA.add(i);
            permutation15661(index + 1, i + 1);
            teamA.remove(teamA.size() - 1);
            visit[i] = false;
        }
    }

    private static void calculateResult() {
        int teamAscore = 0;
        int teamBscore = 0;

        List<Integer> teamB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                teamB.add(i);
            }
        }

        for (int i = 0; i < teamA.size(); i++) {
            for (int j = 0; j < teamA.size(); j++) {
                if (i != j) {
                    teamAscore += info[teamA.get(i)][teamA.get(j)];
                }
            }
        }

        for (int i = 0; i < teamB.size(); i++) {
            for (int j = 0; j < teamB.size(); j++) {
                if (i != j) {
                    teamBscore += info[teamB.get(i)][teamB.get(j)];
                }
            }
        }

        difference = Math.min(difference, Math.abs(teamAscore - teamBscore));
    }
}
