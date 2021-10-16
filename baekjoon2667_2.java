import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon2667_2 {
    private static int n;
    private static int count;
    private static int[][] info;
    private static boolean[][] visit;
    private static int result = 0;
    private static ArrayList<Integer> resultList = new ArrayList<>();
    private static int[] rowTemp = { -1, 1, 0, 0 };
    private static int[] colTemp = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        info = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                info[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문한 적이 없는 (!visit[i][j]) 집이 있는 곳 (info[i][j] != 0) 을 모두 확인
                if (!visit[i][j] && info[i][j] != 0) {
                    // count는 단지 내 집의 수를 의미
                    count = 1;
                    // resultList에는 단지 내 집의 수를 저장.
                    resultList.add(count);
                    // 현재 집과 인접한 집을 모두 검색 (단지)
                    bfs2667(i, j);
                    result++;
                }
            }
        }
        // 총 단지수 출력
        System.out.println(result);
        // 오름 차순 정렬
        Collections.sort(resultList);
        // 단지 내 집의 수를 오름차순으로 출력
        resultList.forEach(System.out::println);

    }

    private static void bfs2667(int row, int col) {
        visit[row][col] = true;
        resultList.set(result, count);
        count++;

        int nextRow;
        int nextCol;
        // 현재 집의 위치에서 상, 하, 좌, 우에 위치한 모든 집을 방문
        for (int i = 0; i < 4; i++) {
            nextRow = row + rowTemp[i];
            nextCol = col + colTemp[i];
            // 방문하려는 집의 위치가 범위 내에 존재하여야 하며
            if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n) {
                // 방문 하려는 집은 이전에 방문한 적이 없었어야 하며, 집이 있는 곳이어야 한다.
                if (!visit[nextRow][nextCol] && info[nextRow][nextCol] != 0) {
                    bfs2667(nextRow, nextCol);
                }
            }
        }
    }
}
