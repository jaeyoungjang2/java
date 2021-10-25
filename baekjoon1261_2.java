import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1261_2 {
    private static int row;
    private static int col;
    private static int[][] info;
    private static int[][] distInfo;
    private static boolean[][] visit;
    private static int[] rowTemp = { -1, 1, 0, 0 };
    private static int[] colTemp = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        // 3 3
        // 011
        // 111
        // 110
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        info = new int[row][col];
        distInfo = new int[row][col];
        visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                info[i][j] = Character.getNumericValue(temp.charAt(j));
                // distInfo[i][j] = -1;
            }
        }

        bfs1261();
        System.out.println(distInfo[row - 1][col - 1]);

    }

    private static void bfs1261() {
        Queue<Position1261> queue = new LinkedList<>();
        queue.add(new Position1261(0, 0));

        while (!queue.isEmpty()) {
            Position1261 currentPosition = queue.remove();
            int currentRow = currentPosition.row;
            int currentCol = currentPosition.col;

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + rowTemp[i];
                int nextCol = currentCol + colTemp[i];

                if (nextRow >= 0 && nextCol >= 0 && nextCol < col && nextRow < row) {
                    if (info[nextRow][nextCol] == 1) {
                        if (distInfo[nextRow][nextCol] > distInfo[currentRow][currentCol] + 1
                                || !visit[nextRow][nextCol]) {
                            visit[nextRow][nextCol] = true;
                            distInfo[nextRow][nextCol] = distInfo[currentRow][currentCol] + 1;
                            queue.add(new Position1261(nextRow, nextCol));
                        }
                    }
                    if (info[nextRow][nextCol] == 0) {
                        if (distInfo[nextRow][nextCol] > distInfo[currentRow][currentCol] || !visit[nextRow][nextCol]) {
                            visit[nextRow][nextCol] = true;
                            distInfo[nextRow][nextCol] = distInfo[currentRow][currentCol];
                            queue.add(new Position1261(nextRow, nextCol));
                        }
                    }
                }
            }

        }
    }
}

class Position1261 {
    int row;
    int col;

    public Position1261(int row, int col) {
        this.row = row;
        this.col = col;
    }
}