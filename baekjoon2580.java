import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class baekjoon2580 {

    static int n = 9;
    static int[] aryH = { 0, 1 };
    static int[] aryW = { 1, 0 };
    static int[][] info = new int[n][n];
    static boolean[][] visit = new boolean[n][n];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                info[i][j] = sc.nextInt();
            }
        }
        permutation(0, 0);
    }

    static void permutation(int h, int w) {
        if (h == n - 1 && w == n - 1) {
            System.out.println("HI");
        }
        visit[h][w] = true;
        if (info[h][w] == 0) {
            for (int i = 1; i <= n; i++) {

                int squareH = findRangeForBactrackingSquare(h);
                int squareW = findRangeForBactrackingSquare(w);
                // System.out.println(h);
                // System.out.println(w);
                // System.out.println(backtrackingCol(h, w));
                // System.out.println(backtrackingRow(h, w));
                // System.out.println(backTrackingSquare(squareH, squareW));

                if (backTrackingSquare(squareH, squareW, i) && backtrackingCol(h, w, i) && backtrackingRow(h, w, i)) {
                    for (int j = 0; j < 2; i++) {
                        int newH = h + aryH[j];
                        int newW = w + aryW[j];
                        info[h][w] = i;
                        if (newH < n && newW < n) {
                            permutation(newH, newW);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < 2; i++) {
                int newH = h + aryH[i];
                int newW = w + aryW[i];

                if (newH < n && newW < n && !visit[newW][newW]) {
                    permutation(newH, newW);
                }
            }
        }

    }

    static boolean backtrackingRow(int h, int w, int target) {
        for (int i = 0; i < n; i++) {
            if (info[h][i] == target) {
                return false;
            }
        }
        return true;
    }

    static boolean backtrackingCol(int h, int w, int target) {
        for (int i = 0; i < n; i++) {
            if (info[i][w] == target) {
                return false;
            }
        }
        return true;
    }

    static int findRangeForBactrackingSquare(int x) {
        if (x <= 2) {
            return 0;
        } else if (x <= 5) {
            return 3;
        } else {
            return 6;
        }
    }

    static boolean backTrackingSquare(int h, int w, int target) {
        for (int i = h; i < h + 2; i++) {
            for (int j = w; j < w + 2; j++) {
                if (info[i][j] == target) {
                    return false;
                }
            }
        }
        return true;
    }
}
