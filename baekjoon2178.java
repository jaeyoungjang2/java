import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon2178 {
    static int n;
    static int m;
    static char[][] mazeInfo;
    static boolean[][] visit;
    static int res = -1;

    public static void main(String[] args) {
        String stringTemp;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        mazeInfo = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            stringTemp = sc.next();
            for (int j = 0; j < m; j++) {
                mazeInfo[i][j] = stringTemp.charAt(j);
                visit[i][j] = true;
            }
        }

        permutation(0, 0, 1);
        System.out.println(res);
    }

    static void permutation(int h, int w, int count) {
        visit[h][w] = false;
        if (h == n - 1 && w == m - 1) {
            visit[h][w] = true;
            if (res == -1) {
                res = count;
            } else if (count < res) {
                res = count;
            }
            return;
        }

        if (w + 1 < m && visit[h][w + 1] && mazeInfo[h][w + 1] == '1') {
            // visit[h][w] = false;
            permutation(h, w + 1, count + 1);
            // visit[h][w] = true;
        }
        if (h + 1 < n && visit[h + 1][w] && mazeInfo[h + 1][w] == '1') {
            // visit[h][w] = false;
            permutation(h + 1, w, count + 1);
            // visit[h][w] = true;
        }
        if (w - 1 >= 0 && visit[h][w - 1] && mazeInfo[h][w - 1] == '1') {
            // visit[h][w] = false;
            permutation(h, w - 1, count + 1);
            // visit[h][w] = true;
        }
        if (h - 1 >= 0 && visit[h - 1][w] && mazeInfo[h - 1][w] == '1') {
            // visit[h][w] = false;
            permutation(h - 1, w, count + 1);
            // visit[h][w] = true;
        }

    }

}
