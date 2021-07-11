import java.util.Arrays;
import java.util.Scanner;

public class baekjoon16929 {
    static Boolean isTrue = false;
    static boolean[][] visit;
    static char[][] info;
    static int[][] dist;
    static int n;
    static int m;
    static int[] aryW = { -1, 1, 0, 0 };
    static int[] aryH = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        info = new char[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < m; j++) {
                info[i][j] = temp.charAt(j);
                visit[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) {
                    visit[i][j] = false;
                    permutation(i, j, 1);
                }
            }
        }
        if (isTrue) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    static void permutation(int h, int w, int cnt) {
        for (int i = 0; i < 4; i++) {
            int newH = h + aryH[i];
            int newW = w + aryW[i];
            // 좌표가 범위내에 있으며, 색깔이 같을 때
            if (newH >= 0 && newW >= 0 && newH < n && newW < m && info[newH][newW] == info[h][w]) {

                // 거리 차가 4 이상이고, 방문한 적이 있으면
                if (cnt - dist[newH][newW] >= 4 && visit[newH][newW] == false) {

                    isTrue = true;
                } else if (visit[newH][newW]) {

                    dist[newH][newW] = cnt;
                    visit[newH][newW] = false;
                    permutation(newH, newW, cnt + 1);
                }
            }
        }

    }

}
