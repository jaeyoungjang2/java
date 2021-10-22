import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2146_2 {
    private static int n;
    private static int[][] info;
    private static boolean[][] visit;
    private static int[][] distInfo;
    private static int[][] territoryInfo;
    private static int[] rowTemp = { -1, 1, 0, 0 };
    private static int[] colTemp = { 0, 0, -1, 1 };
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 10
        // 1 1 1 0 0 0 0 1 1 1
        // 1 1 1 1 0 0 0 0 1 1
        // 1 0 1 1 0 0 0 0 1 1
        // 0 0 1 1 1 0 0 0 0 1
        // 0 0 0 1 0 0 0 0 0 1
        // 0 0 0 0 0 0 0 0 0 1
        // 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 1 1 0 0 0 0
        // 0 0 0 0 1 1 1 0 0 0
        // 0 0 0 0 0 0 0 0 0 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new int[n][n];
        visit = new boolean[n][n];
        distInfo = new int[n][n];
        territoryInfo = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Position2146> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (info[i][j] == 1) {
                    queue.add(new Position2146(i, j));
                }
            }
        }

        int terriyToryNumber = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && info[i][j] == 1) {
                    setTerritoryInfo(i, j, terriyToryNumber);
                    territoryInfo[i][j] = terriyToryNumber;
                    terriyToryNumber++;
                }
            }
        }

        findMinimumDistance(queue);
        System.out.println(Collections.min(result));
    }

    private static void setTerritoryInfo(int row, int col, int terriyToryNumber) {
        Queue<Position2146> q = new LinkedList<>();
        q.add(new Position2146(row, col));

        while (!q.isEmpty()) {
            Position2146 position = q.remove();
            int currentRow = position.row;
            int currentCol = position.col;

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + rowTemp[i];
                int nextCol = currentCol + colTemp[i];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n) {
                    if (!visit[nextRow][nextCol] && info[nextRow][nextCol] == 1) {
                        visit[nextRow][nextCol] = true;
                        territoryInfo[nextRow][nextCol] = terriyToryNumber;
                        q.add(new Position2146(nextRow, nextCol));
                    }
                }
            }
        }
    }

    private static void findMinimumDistance(Queue<Position2146> queue) {
        while (!queue.isEmpty()) {
            Position2146 position = queue.remove();
            int currentRow = position.row;
            int currentCol = position.col;

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + rowTemp[i];
                int nextCol = currentCol + colTemp[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n) {
                    if (!visit[nextRow][nextCol]) {
                        visit[nextRow][nextCol] = true;
                        distInfo[nextRow][nextCol] = distInfo[currentRow][currentCol] + 1;
                        territoryInfo[nextRow][nextCol] = territoryInfo[currentRow][currentCol];
                        queue.add(new Position2146(nextRow, nextCol));
                    } else if (info[nextRow][nextCol] == 0
                            && territoryInfo[nextRow][nextCol] != territoryInfo[currentRow][currentCol]) {
                        result.add(distInfo[nextRow][nextCol] + distInfo[currentRow][currentCol]);
                    }
                }
            }
        }
    }
}

class Position2146 {
    int row;
    int col;

    public Position2146(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
