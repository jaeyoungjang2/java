import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon13913_2 {
    private static int start;
    private static int end;
    private static boolean[] visit;
    private static int[] routeInfo;
    private static int[] distInfo;
    private static int max = 100_000;
    private static ArrayList<Integer> routeResult;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visit = new boolean[max * 2 + 1];
        routeInfo = new int[max * 2 + 1];
        distInfo = new int[max * 2 + 1];

        bfs13913();

        sb.append(distInfo[end] + "\n");
        routeResult = new ArrayList<>();
        findRoute13913(end);
        System.out.println(sb);
    }

    private static void findRoute13913(int position) {
        routeResult.add(position);
        if (position == start) {
            Collections.reverse(routeResult);
            for (int i : routeResult) {
                sb.append(i + " ");
            }
            return;
        }
        int beforePosition = routeInfo[position];
        findRoute13913(beforePosition);
    }

    private static void bfs13913() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int currentPosition = queue.remove();
            if (currentPosition == end) {
                return;
            }

            int nextPosition = currentPosition + 1;
            if (nextPosition < max && !visit[nextPosition]) {
                queue.add(nextPosition);
                visit[nextPosition] = true;
                distInfo[nextPosition] = distInfo[currentPosition] + 1;
                routeInfo[nextPosition] = currentPosition;
            }

            nextPosition = currentPosition - 1;
            if (nextPosition >= 0 && !visit[nextPosition]) {
                queue.add(nextPosition);
                visit[nextPosition] = true;
                distInfo[nextPosition] = distInfo[currentPosition] + 1;
                routeInfo[nextPosition] = currentPosition;
            }

            nextPosition = currentPosition * 2;
            if (nextPosition <= max * 2 && !visit[nextPosition]) {
                queue.add(nextPosition);
                visit[nextPosition] = true;
                distInfo[nextPosition] = distInfo[currentPosition] + 1;
                routeInfo[nextPosition] = currentPosition;
            }
        }
    }
}
