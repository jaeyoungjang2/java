import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon2146 {
    static boolean[][] visit;
    static int[][] info;
    static int[] aryH = { 0, 0, -1, 1 };
    static int[] aryW = { -1, 1, 0, 0 };
    static int n;
    static int[][] color;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visit = new boolean[n][n];
        info = new int[n][n];
        color = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = true;
                info[i][j] = sc.nextInt();
            }
        }
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] && info[i][j] == 1) {
                    dfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        System.out.println(Arrays.toString(color[0]));
        System.out.println(Arrays.toString(color[1]));
        System.out.println(Arrays.toString(color[2]));
        System.out.println(Arrays.toString(color[3]));
        System.out.println(Arrays.toString(color[4]));
        System.out.println(Arrays.toString(color[5]));
        System.out.println(Arrays.toString(color[6]));
        System.out.println(Arrays.toString(color[7]));
        System.out.println(Arrays.toString(color[8]));
        System.out.println(Arrays.toString(color[9]));

        Queue<int[]> q = new LinkedList<>();
        // q.add(new int[] {4,5});
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == false) {
                    for (int j2 = 0; j2 < 4; j2++) {
                        int newI = i + aryH[j2];
                        int newJ = j + aryW[j2];
                        if (newI >= 0 && newJ >= 0 && newI < n && newJ < n && visit[newI][newJ]) {
                            q.add(new int[] { newI, newJ, color[i][j] });

                        }
                    }
                }
            }
        }

        boolean isRun = true;
        int result = 0;
        while (!q.isEmpty()) {
            if (isRun == false) {
                break;
            }
            int[] location = q.remove();
            int h = location[0];
            int w = location[1];
            int c = location[2];

            for (int i = 0; i < 4; i++) {
                int newH = h + aryH[i];
                int newW = w + aryW[i];
                if (newH >= 0 && newW >= 0 && newH < n && newW < n && visit[newH][newW] && info[newH][newW] == 0) {
                    dist[newH][newW] = dist[h][w] + 1;
                    color[newH][newW] = c;
                    q.add(new int[] { newH, newW, color[h][w] });
                } else if (newH >= 0 && newW >= 0 && newH < n && newW < n && visit[newH][newW] == false
                        && info[newH][newW] == 1 && color[newH][newW] != c) {
                    isRun = false;
                    result = dist[h][w];
                    break;
                }
            }
        }
        System.out.println(result);

        System.out.println(Arrays.toString(color[0]));
        System.out.println(Arrays.toString(color[1]));
        System.out.println(Arrays.toString(color[2]));
        System.out.println(Arrays.toString(color[3]));
        System.out.println(Arrays.toString(color[4]));
        System.out.println(Arrays.toString(color[5]));
        System.out.println(Arrays.toString(color[6]));
        System.out.println(Arrays.toString(color[7]));
        System.out.println(Arrays.toString(color[8]));
        System.out.println(Arrays.toString(color[9]));
    }

    static void dfs(int h, int w, int c) {
        visit[h][w] = false;
        color[h][w] = c;
        for (int i = 0; i < 4; i++) {
            int newH = h + aryH[i];
            int newW = w + aryW[i];
            if (newH >= 0 && newW >= 0 && newH < n && newW < n && visit[newH][newW] && info[newH][newW] == 1) {

                dfs(newH, newW, c);

            }
        }
    }
}
