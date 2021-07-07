import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] tomatoState = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        int[][] dayAry = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        int[] batchX = { 0, 0, -1, 1 };
        int[] batchY = { -1, 1, 0, 0 };
        // 토마토 숙성 상태 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int state = sc.nextInt();
                tomatoState[i][j] = state;
                visit[i][j] = true;
                if (state == 1) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        // 기준점에서 상, 하, 좌, 우에 존재하는 토마토를 숙성시킴
        // 숙성일은 기준점 날짜 + 1일
        // 새로운 좌표는 0이상, y축은 n x축은 m 미만인 값을 지녀야 함
        // tomatoState[][] 의 값이 -1 이면 큐를 추가하지 않는다.
        while (!q.isEmpty()) {
            int location[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int newH = location[0] + batchX[i];
                int newW = location[1] + batchY[i];
                if (newH >= 0 && newW >= 0 && newH < n && newW < m && visit[newH][newW]) {
                    visit[newH][newW] = false;
                    dayAry[newH][newW] = dayAry[location[0]][location[1]] + 1;
                    q.add(new int[] { newH, newW });
                }
            }
        }

        // 저장될 때 부터 모두 익어있는 상태 (모두 1 ) 이면 0을 출력
        // 백 트래킹 : 안익은 토마토가 ( 0 ) 존재하면 -1 출력, 안익은 토마토가 ( 0 ) 존재하지 않으면 최소 날짜를 출력
    }

}

// https://velog.io/@juhyun7793/백준-2178-미로찾기-Java