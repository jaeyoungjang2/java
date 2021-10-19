import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon7562_2 {
    private static int[] rowTemp = { -2, -2, -1, -1, 1, 1, 2, 2 };
    private static int[] colTemp = { -1, 1, -2, 2, -2, 2, -1, 1 };
    private static int size;
    private static boolean[][] visit;
    private static int[][] distInfo;
    private static int endRow;
    private static int endCol;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 체스 게임 진행
        for (int i = 0; i < n; i++) {
            size = Integer.parseInt(br.readLine());
            distInfo = new int[size][size];
            visit = new boolean[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            Queue<Position7562> queue = new LinkedList<>();
            visit[startRow][startCol] = true;
            // 시작 지점과 종료 지점이 똑같을 경우 0을 저장
            if (startRow == endRow && startCol == endCol) {
                sb.append(0 + "\n");
            } else {
                // 시작 지점과 종료 지점이 다를 경우 시작 지점으로 부터 BFS를 진행한다.
                queue.add(new Position7562(startRow, startCol));
                bfs7562(queue);
            }
        }

        System.out.println(sb);
    }

    private static void bfs7562(Queue<Position7562> queue) {
        while (!queue.isEmpty()) {
            Position7562 position7562 = queue.remove();
            int row = position7562.row;
            int col = position7562.col;

            for (int i = 0; i < 8; i++) {
                int nextRow = row + rowTemp[i];
                int nextCol = col + colTemp[i];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < size && nextCol < size) {
                    if (!visit[nextRow][nextCol]) {
                        if (nextRow == endRow && nextCol == endCol) {
                            sb.append(distInfo[row][col] + 1 + "\n");
                            return;
                        }
                        visit[nextRow][nextCol] = true;
                        distInfo[nextRow][nextCol] = distInfo[row][col] + 1;
                        queue.add(new Position7562(nextRow, nextCol));
                    }
                }
            }

        }
    }
}

class Position7562 {
    int row;
    int col;

    Position7562(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
