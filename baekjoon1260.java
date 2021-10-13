import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon1260 {
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 4 5 1
        // 1 2
        // 1 3
        // 1 4
        // 2 4
        // 3 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visit = new boolean[vertex + 1];
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();

        // 어레이 리스트 초기화
        for (int i = 0; i < vertex + 1; i++) {
            info.add(new ArrayList<>());
        }

        int from;
        int to;
        // 양방향 간선 정보 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            info.get(from).add(to);
            info.get(to).add(from);
        }

        dfs(start, info);
        sb.append("\n");

        // 방문 정보 초기화
        visit = new boolean[vertex + 1];
        bfs(start, info);
        System.out.println(sb);
    }

    private static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> info) {
        visit[currentVertex] = true;
        sb.append(currentVertex + " ");

        Collections.sort(info.get(currentVertex));
        for (int nextVertex : info.get(currentVertex)) {
            if (!visit[nextVertex]) {
                dfs(nextVertex, info);
            }
        }
    }

    private static void bfs(int currentVertex, ArrayList<ArrayList<Integer>> info) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentVertex);
        visit[currentVertex] = true;

        while (!queue.isEmpty()) {
            currentVertex = queue.remove();
            sb.append(currentVertex + " ");
            for (Integer nextVertex : info.get(currentVertex)) {
                if (!visit[nextVertex]) {
                    visit[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }
}
