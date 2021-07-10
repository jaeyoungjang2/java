import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon7576_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] tomatoState = new int[n][m];
        Boolean[][] visitInfo = new Boolean[n][m];

        int[] aryH = { 0, 0, 1, -1 };
        int[] aryW = { 1, -1, 0, 0 };

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int state = sc.nextInt();
                tomatoState[i][j] = state;
                if (state == 1) {
                    q.add(new int[] { i, j });
                    visitInfo[i][j] = false;
                    dist[i][j] = 1;
                    continue;
                }
                visitInfo[i][j] = true;
            }
        }
        // 저장될 때 부터 토마토가 모두 익어있는 상태이면 0을 출력 ( tomato 상태가 0이 없는 경우 )

        while (!q.isEmpty()) {
            int[] location = q.poll();
            int h = location[0];
            int w = location[1];

            // 익은 토마토에서 상, 하, 좌, 우에 위치한 토마토 확인
            for (int i = 0; i < 4; i++) {
                int newH = h + aryH[i];
                int newW = w + aryW[i];
                if (newW >= 0 && newH >= 0 && newW < m && newH < n && visitInfo[newH][newW]
                        && tomatoState[newH][newW] == 0) {
                    q.add(new int[] { newH, newW });
                    visitInfo[newH][newW] = false;
                    tomatoState[newH][newW] = 1;
                    dist[newH][newW] = dist[h][w] + 1;
                }
            }
        }
        int res = 0;
        boolean isImpossible = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoState[i][j] == 0) {
                    isImpossible = true;
                }
                if (dist[i][j] > res) {
                    res = dist[i][j];
                }
            }
        }
        if (isImpossible) {
            System.out.println(-1);
        } else {
            System.out.println(res - 1);
        }

        // 익은 토마토에서 상, 하, 좌, 우에 위치한 안 익은 토마토는 다음날 익음
        // tomato 의 상태가 -1 이면 더이상 진행되지 않음
        // 토마토가 모두 익지 못하는 상황이면 -1을 출력
        // 토마토가 모두 익는데 걸리는 최소 날짜를 출력하라

    }

}
