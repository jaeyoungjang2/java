import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon7562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();
        int[] aryH = { +2, +2, +1, +1, -1, -1, -2, -2 };
        int[] aryW = { +1, -1, +2, -2, +2, -2, +1, -1 };

        for (int i = 0; i < cycle; i++) {
            int size = sc.nextInt();
            int[][] chess = new int[size][size];
            boolean[][] visit = new boolean[size][size];
            int[][] roundInfo = new int[size][size];
            Queue<int[]> q = new LinkedList<>();

            int knightH = sc.nextInt();
            int knightW = sc.nextInt();

            int targetH = sc.nextInt();
            int targetW = sc.nextInt();

            if (knightH == targetH && knightW == targetW) {
                roundInfo[targetH][targetW] = 0;
            } else {
                q.add(new int[] { knightH, knightW });
            }
            for (int j = 0; j < size; j++) {
                for (int j2 = 0; j2 < size; j2++) {
                    visit[j][j2] = true;
                }
            }
            while (!q.isEmpty()) {
                int[] location = q.poll();
                int h = location[0];
                int w = location[1];
                for (int j = 0; j < 8; j++) {
                    int newH = h + aryH[j];
                    int newW = w + aryW[j];
                    if (newH >= 0 && newW >= 0 && newH < size && newW < size && visit[newH][newW]) {

                        roundInfo[newH][newW] = roundInfo[h][w] + 1;
                        visit[newH][newW] = false;
                        q.add(new int[] { newH, newW });
                    }
                }
            }
            System.out.println(roundInfo[targetH][targetW]);
        }
    }

}
