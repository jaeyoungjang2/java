import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2718 {
    private static int targetRow;
    private static int targetCol;
    private static int[] rowTemp = { -1, 1, 0, 0 };
    private static int[] colTemp = { 0, 0, -1, 1 };
    private static int[][] info;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        targetRow = Integer.parseInt(st.nextToken());
        targetCol = Integer.parseInt(st.nextToken());

        // 미로 정보를 담을 공간 초기화!!
        info = new int[targetRow][targetCol];
        // 방문 여부 확인
        visit = new boolean[targetRow][targetCol];

        // 미로 정보 저장
        for (int i = 0; i < targetRow; i++) {
            String temp = br.readLine();
            for (int j = 0; j < targetCol; j++) {
                info[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        bfs2718();
    }

    private static void bfs2718() {
        Queue<Maze> queue = new LinkedList<>();
        queue.add(new Maze(0, 0, 1));
        visit[0][0] = true;

        int row;
        int col;
        int count;
        int nextRow;
        int nextCol;

        while (!queue.isEmpty()) {
            Maze maze = queue.remove();
            row = maze.height;
            col = maze.width;
            count = maze.count;

            if (row == targetRow - 1 && col == targetCol - 1) {
                System.out.println(count);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                nextRow = row + rowTemp[i];
                nextCol = col + colTemp[i];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < targetRow && nextCol < targetCol) {
                    if (info[nextRow][nextCol] != 0 && !visit[nextRow][nextCol]) {
                        visit[nextRow][nextCol] = true;
                        queue.add(new Maze(nextRow, nextCol, count + 1));
                    }
                }
            }
        }
    }
}

class Maze {
    int height;
    int width;
    int count;

    Maze(int height, int width, int count) {
        this.height = height;
        this.width = width;
        this.count = count;
    }
}
