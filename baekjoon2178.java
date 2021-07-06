import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon2178 {
    static int n;
    static int m;
    static Queue<Integer> queueX = new LinkedList<>();
    static Queue<Integer> queueY = new LinkedList<>();
    static char[][] mazeInfo;
    static boolean[][] visit;
    static int res = -1;
    static int[] distX = { 0, 0, -1, 1 };
    static int[] distY = { -1, 1, 0, 0 };
    static int[][] distInfo;

    public static void main(String[] args) {
        Queue<Pair> queue = new LinkedList<>();

        String stringTemp;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        distInfo = new int[n][m];
        mazeInfo = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            stringTemp = sc.next();
            for (int j = 0; j < m; j++) {
                mazeInfo[i][j] = stringTemp.charAt(j);
                visit[i][j] = true;
            }
        }

        queue.add(new Pair(0, 0));
        distInfo[0][0] = 1;
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int newX = x + distX[i];
                int newY = y + distY[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (mazeInfo[newX][newY] == '1' && visit[newX][newY]) {
                        visit[newX][newY] = false;
                        distInfo[newX][newY] = distInfo[x][y] + 1;
                        queue.add(new Pair(newX, newY));
                    }
                }
            }
        }
        System.out.println(distInfo[n - 1][m - 1]);

        // permutation(0, 0, 1);
        // System.out.println(res);
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

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}