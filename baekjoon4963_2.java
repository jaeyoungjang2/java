import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon4963_2 {
    private static int[][] info;
    private static boolean[][] visit;
    private static int count;
    private static int row;
    private static int col;
    private static int[] rowTemp = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static int[] colTemp = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            info = new int[row][col];
            visit = new boolean[row][col];

            if (row == 0 && col == 0) {
                break;
            }

            // 문제 정보 입력
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    info[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 섬의 개수 초기화
            count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (info[i][j] != 0 && !visit[i][j]) {
                        count++;
                        dfs4963(i, j);
                    }
                }
            }
            // 섬의 개수 저장
            sb.append(count + "\n");
        }
        // 섬의 개수 출력
        System.out.println(sb);
    }

    private static void dfs4963(int height, int width) {
        visit[height][width] = true;

        int nextHeight;
        int nextWidth;

        // 현재 섬에서 상, 하, 좌, 우, 대각선에 위치한 모든 섬을 확인할 예정
        for (int i = 0; i < 8; i++) {

            nextHeight = height + rowTemp[i];
            nextWidth = width + colTemp[i];

            // 다음 섬의 위치가 범위 내에 존재하여야 하며
            if (nextHeight >= 0 && nextWidth >= 0 && nextHeight < row && nextWidth < col) {
                // 방문한 적이 없으면서, 섬인 곳만 확인할 예정이다.
                if (!visit[nextHeight][nextWidth] && info[nextHeight][nextWidth] != 0) {
                    dfs4963(nextHeight, nextWidth);
                }
            }
        }
    }
}
