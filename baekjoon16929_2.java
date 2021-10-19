import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon16929_2 {
    private static int rowSize;
    private static int colSize;
    private static Character[][] info;
    private static boolean[][] visit;
    private static int[] rowTemp = { -1, 1, 0, 0 };
    private static int[] colTemp = { 0, 0, -1, 1 };
    private static int[][] distInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        info = new Character[rowSize][colSize];
        distInfo = new int[rowSize][colSize];
        visit = new boolean[rowSize][colSize];

        // dots 정보 입력
        for (int i = 0; i < rowSize; i++) {
            String temp = br.readLine();
            for (int j = 0; j < colSize; j++) {
                info[i][j] = temp.charAt(j);
            }
        }

        // 모든 행열을 순회하면서, 방문하지 않은 점을 기점으로 dfs 진행
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    dfs16929(i, j);
                }
            }
        }
        System.out.println("No");

    }

    private static void dfs16929(int currentRow, int currentCol) {
        for (int i = 0; i < 4; i++) {
            int nextRow = currentRow + rowTemp[i];
            int nextCol = currentCol + colTemp[i];

            if (nextRow >= 0 && nextCol >= 0 && nextRow < rowSize && nextCol < colSize) {
                // 종료 조건: 거리 차이가 3 이상이고, 방문한 적이 있으며, 다음 글자가 현재 글자와 동일하다면
                if (distInfo[currentRow][currentCol] - distInfo[nextRow][nextCol] >= 3 && visit[nextRow][nextCol]
                        && info[currentRow][currentCol].equals(info[nextRow][nextCol])) {
                    System.out.println("Yes");
                    System.exit(0);
                }
                // 방문한 적이 없으며, 다음글자가 현재 글자와 동일하다면 dfs 진행
                if (!visit[nextRow][nextCol] && info[currentRow][currentCol].equals(info[nextRow][nextCol])) {
                    visit[nextRow][nextCol] = true;
                    distInfo[nextRow][nextCol] = distInfo[currentRow][currentCol] + 1;
                    dfs16929(nextRow, nextCol);
                }
            }
        }
    }
}
