import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon7576_3 {
    private static int[][] info;
    private static boolean[][] visit;
    private static int row;
    private static int col;
    private static int[] rowTemp = { -1, 1, 0, 0 };
    private static int[] colTemp = { 0, 0, -1, 1 };
    private static int result = 0;
    private static int[][] dayInfo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        visit = new boolean[row][col];
        info = new int[row][col];
        dayInfo = new int[row][col];

        // 토마토 상태 입력
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < col; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Position7576> queue = new LinkedList<>();

        // 모든 출발점 ( 익은 토마토 ) 를 큐에 넣어준다.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visit[i][j] && info[i][j] == 1) {
                    visit[i][j] = true;
                    queue.add(new Position7576(i, j));
                }
            }
        }
        // 최단 거리에 있는 모든 토마토를 익혀준다.
        bfs7576(queue);

        // 익지 않은 토마토가 있으며 -1를 출력하고 종료
        // 모두 다 익었다면, 익는 데 까지 걸린 날짜를 저장한다.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (info[i][j] == 0 && !visit[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                } else if (dayInfo[i][j] > result) {
                    result = dayInfo[i][j];
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs7576(Queue<Position7576> queue) {
        while (!queue.isEmpty()) {
            Position7576 position = queue.remove();
            int currentRow = position.row;
            int currentCol = position.col;

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + rowTemp[i];
                int nextCol = currentCol + colTemp[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < row && nextCol < col) {
                    if (!visit[nextRow][nextCol] && info[nextRow][nextCol] == 0) {
                        visit[nextRow][nextCol] = true;
                        dayInfo[nextRow][nextCol] = dayInfo[currentRow][currentCol] + 1;
                        queue.add(new Position7576(nextRow, nextCol));
                    }
                }
            }
        }

    }
}

class Position7576 {
    int row;
    int col;

    Position7576(int row, int col) {
        this.row = row;
        this.col = col;
    }
}