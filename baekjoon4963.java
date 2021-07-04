import java.util.Scanner;

public class baekjoon4963 {
    static Boolean[][] visit;
    static int[][] landState;
    static int w;
    static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            landState = new int[h][w];
            visit = new Boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    landState[i][j] = sc.nextInt();
                    visit[i][j] = true;
                }
            }
            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visit[i][j] && landState[i][j] == 1) {

                        // toDo: permutation (섬의 개수 찾기)
                        // 방문 여부 확인 visit[i][j] == true
                        // 해당 지역이 '땅' 일 경우만 진행 landState[i][j] == 1
                        // permutation 진행
                        permutation(j, i);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }

    static void permutation(int col, int row) {

        visit[row][col] = false;
        // +1 0
        // +1 +1
        // 0 +1
        // -1 +1
        // -1 0
        // -1 -1
        // 0 -1
        // +1 -1

        if (row + 1 < h && visit[row + 1][col] && landState[row + 1][col] == 1) {
            permutation(col, row + 1);
        }
        if (row + 1 < h && col + 1 < w && visit[row + 1][col + 1] && landState[row + 1][col + 1] == 1) {
            permutation(col + 1, row + 1);
        }
        if (col + 1 < w && visit[row][col + 1] && landState[row][col + 1] == 1) {
            permutation(col + 1, row);
        }
        if (row - 1 >= 0 && col + 1 < w && visit[row - 1][col + 1] && landState[row - 1][col + 1] == 1) {
            permutation(col + 1, row - 1);
        }
        if (row - 1 >= 0 && visit[row - 1][col] && landState[row - 1][col] == 1) {
            permutation(col, row - 1);
        }
        if (row - 1 >= 0 && col - 1 >= 0 && visit[row - 1][col - 1] && landState[row - 1][col - 1] == 1) {
            permutation(col - 1, row - 1);
        }
        if (col - 1 >= 0 && visit[row][col - 1] && landState[row][col - 1] == 1) {
            permutation(col - 1, row);
        }
        if (row + 1 < h && col - 1 >= 0 && visit[row + 1][col - 1] && landState[row + 1][col - 1] == 1) {
            permutation(col - 1, row + 1);
        }
        // 상 하 좌 우 대각선,
        // 모든 경로는 0 보다 커야하고, w, h 보다는 작아야 함
        // 방문하지 않았을 경우 방문하기
        //
    }

}
