import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] aryH = { 0, 0, -1, 1 };
        int[] aryW = { 1, -1, 0, 0 };
        int[][] info = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[][] dist = new int[n][m];

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < m; j++) {
                info[i][j] = temp.charAt(j) - '0';
            }
        }
        dq.addFirst(new int[] { 0, 0 });
        visit[0][0] = true;

        while (!dq.isEmpty()) {
            int[] position = dq.removeFirst();
            int h = position[0];
            int w = position[1];
            if (h == n && w == m) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newH = h + aryH[i];
                int newW = w + aryW[i];
                if (0 <= newW && 0 <= newH && newH < n && newW < m && !visit[newH][newW]) {

                    visit[newH][newW] = true;
                    if (info[newH][newW] == 1) {
                        dq.addLast(new int[] { newH, newW });
                        dist[newH][newW] = dist[h][w] + 1;
                    } else if (info[newH][newW] == 0) {

                        dq.addFirst(new int[] { newH, newW });
                        dist[newH][newW] = dist[h][w];
                    }
                }
            }
        }
        System.out.println(dist[n - 1][m - 1]);
    }
}
