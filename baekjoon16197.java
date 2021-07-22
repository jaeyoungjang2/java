import java.util.Scanner;

public class baekjoon16197 {
    static int n;
    static int m;
    static int[][] info;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        info = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findMaxSum(i, j);
            }
        }
        System.out.println(res);
    }

    static void findMaxSum(int h, int w) {
        // case1
        if (w + 3 < m) {
            int temp = info[h][w] + info[h][w + 1] + info[h][w + 2] + info[h][w + 3];
            res = Math.max(res, temp);
        }
        // case1_2
        if (h + 3 < n) {
            int temp = info[h][w] + info[h + 1][w] + info[h + 2][w] + info[h + 3][w];
            res = Math.max(res, temp);
        }
        // case2
        if (h + 1 < n && w + 1 < m) {
            int temp = info[h][w] + info[h + 1][w] + info[h + 1][w + 1] + info[h][w + 1];
            res = Math.max(res, temp);
        }
        // case3
        if (h + 2 < n && w + 1 < m) {
            int temp = info[h][w] + info[h + 1][w] + info[h + 2][w] + info[h + 2][w + 1];
            res = Math.max(res, temp);
        }
        // case3_2
        if (h + 1 < n && w + 2 < m) {
            int temp = info[h + 1][w] + info[h + 1][w + 1] + info[h + 1][w + 2] + info[h][w + 2];
            res = Math.max(res, temp);
        }
        // case3_3
        if (h + 2 < n && w + 1 < m) {
            int temp = info[h][w] + info[h][w + 1] + info[h + 1][w + 1] + info[h + 2][w + 1];
            res = Math.max(res, temp);
        }
        // case3_4
        if (h + 1 < n && w + 2 < m) {
            int temp = info[h][w] + info[h][w + 1] + info[h][w + 2] + info[h + 1][w + 2];
            res = Math.max(res, temp);
        }
        // case4
        if (h + 2 < n && w + 1 < m) {
            int temp = info[h][w] + info[h + 1][w] + info[h + 1][w + 1] + info[h + 2][w + 1];
            res = Math.max(res, temp);
        }
        // case4_1
        if (h + 1 < n && w + 2 < m) {
            int temp = info[h + 1][w] + info[h + 1][w + 1] + info[h][w + 1] + info[h][w + 2];
            res = Math.max(res, temp);
        }
        // case5
        if (h + 1 < n && w + 2 < m) {
            int temp = info[h][w] + info[h][w + 1] + info[h][w + 2] + info[h + 1][w + 1];
            res = Math.max(res, temp);
        }
        // case5_2
        if (h + 1 < n && w + 2 < m) {
            int temp = info[h + 1][w] + info[h + 1][w + 1] + info[h + 1][w + 2] + info[h][w + 1];
            res = Math.max(res, temp);
        }
        // case5_3
        if (h + 2 < n && w + 1 < m) {
            int temp = info[h][w] + info[h + 1][w] + info[h + 2][w] + info[h + 1][w + 1];
            res = Math.max(res, temp);
        }
        // case5_4
        if (h + 2 < n && w + 1 < m) {
            int temp = info[h][w + 1] + info[h + 1][w + 1] + info[h + 2][w + 1] + info[h][w + 1];
            res = Math.max(res, temp);
        }
    }
}
