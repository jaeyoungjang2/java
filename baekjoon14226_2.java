import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon14226_2 {
    private static boolean[][] visit;
    private static int[] distInfo;
    private static int max = 1_000;
    private static int endPostiion;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        endPostiion = Integer.parseInt(br.readLine());
        visit = new boolean[max * 2 + 1][max * 2 + 1];
        distInfo = new int[max * 2 + 1];
        bfs14226();
    }

    private static void bfs14226() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 1, 0, 0 });
        visit[1][0] = true;
        distInfo[1] = 0;

        while (!queue.isEmpty()) {
            int[] state = queue.remove();
            int currentPosition = state[0];
            int copyStat = state[1];
            int dist = state[2];

            distInfo[currentPosition] = dist;

            if (currentPosition == endPostiion) {
                System.out.println(dist);
                System.exit(0);
            }

            // 붙여넣기
            int nextPostion = currentPosition + copyStat;
            if (nextPostion <= max * 2 && !visit[nextPostion][copyStat]) {
                visit[nextPostion][copyStat] = true;

                queue.add(new int[] { nextPostion, copyStat, distInfo[currentPosition] + 1 });
            }

            // 이모티콘 삭제
            nextPostion = currentPosition - 1;
            if (nextPostion >= 0 && !visit[nextPostion][copyStat]) {
                visit[nextPostion][copyStat] = true;
                queue.add(new int[] { nextPostion, copyStat, distInfo[currentPosition] + 1 });
            }

            // 복사 & 붙여 넣기
            nextPostion = currentPosition;
            copyStat = currentPosition;
            if (nextPostion <= max * 2 && !visit[nextPostion][copyStat]) {
                visit[nextPostion][copyStat] = true;
                queue.add(new int[] { nextPostion, copyStat, distInfo[currentPosition] + 1 });
            }
        }
    }
}
