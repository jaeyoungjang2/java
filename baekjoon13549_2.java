import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class baekjoon13549_2 {
    private static int start;
    private static int end;
    private static int[] distInfo;
    private static boolean[] visit;
    private static int max = 100_000;

    public static void main(String[] args) throws IOException {
        // 5 17
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        visit = new boolean[max * 2 + 1];
        distInfo = new int[max * 2 + 1];
        bfs13549();
    }

    private static void bfs13549() {
        Deque<Integer> dq = new ArrayDeque<>();
        visit[start] = true;
        dq.addLast(start);

        while (!dq.isEmpty()) {
            int current = dq.removeFirst();
            if (current == end) {
                System.out.println(distInfo[current]);
                System.exit(0);
            }

            int next = current * 2;
            if (next < max * 2 + 1 && !visit[next]) {
                visit[next] = true;
                distInfo[next] = distInfo[current];
                dq.addFirst(next);
            }

            next = current + 1;
            if (next < max * 2 + 1 && !visit[next]) {
                visit[next] = true;
                distInfo[next] = distInfo[current] + 1;
                dq.addLast(next);
            }

            next = current - 1;
            if (next >= 0 && !visit[next]) {
                visit[next] = true;
                distInfo[next] = distInfo[current] + 1;
                dq.addLast(next);
            }
        }

    }
}
