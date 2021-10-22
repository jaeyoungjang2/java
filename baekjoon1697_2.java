import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697_2 {
    private static int start;
    private static int end;
    private static int[] roundInfo;
    private static boolean[] visit;
    private static int max = 100_000;

    public static void main(String[] args) throws IOException {
        // 5 17
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        roundInfo = new int[2 * max + 1];
        visit = new boolean[2 * max + 1];
        bfs1697();
        System.out.println(roundInfo[end]);
    }

    private static void bfs1697() {
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            // +1, -1, *2 로 이동이 가능하다.
            int currentPostiion = queue.remove();
            if (currentPostiion == end) {
                return;
            }
            int nextPosition = currentPostiion - 1;
            if (nextPosition >= 0 && !visit[nextPosition]) {
                visit[nextPosition] = true;
                queue.add(nextPosition);
                roundInfo[nextPosition] = roundInfo[currentPostiion] + 1;
            }
            nextPosition = currentPostiion * 2;
            if (nextPosition <= 2 * max && !visit[nextPosition]) {
                visit[nextPosition] = true;
                queue.add(nextPosition);
                roundInfo[nextPosition] = roundInfo[currentPostiion] + 1;
            }
            nextPosition = currentPostiion + 1;
            if (nextPosition <= max && !visit[nextPosition]) {
                visit[nextPosition] = true;
                queue.add(nextPosition);
                roundInfo[nextPosition] = roundInfo[currentPostiion] + 1;
            }

        }
    }
}
