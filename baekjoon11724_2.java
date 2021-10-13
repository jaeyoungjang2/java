import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11724_2 {
    private static boolean[] visit;
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        visit = new boolean[vertex + 1];
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();

        // 어레이 리스트 초기화
        for (int i = 0; i < vertex + 1; i++) {
            info.add(new ArrayList<>());
        }

        int from;
        int to;

        // 단방향 간선 정보 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            info.get(from).add(to);
        }

        for (int i = 0; i < vertex + 1; i++) {
            bfs(i, info);
        }
        System.out.println(result);
    }

    private static void bfs(int currentVertex, ArrayList<ArrayList<Integer>> info) {
        Queue<Integer> queue = new LinkedList<>();
        if (!visit[currentVertex]) {
            System.out.println(currentVertex);
            queue.add(currentVertex);
            while (!queue.isEmpty()) {
                currentVertex = queue.remove();
                visit[currentVertex] = true;
                for (Integer nextVertex : info.get(currentVertex)) {
                    if (!visit[nextVertex]) {
                        queue.add(nextVertex);
                    }
                }
            }
            result++;
        }
    }
}
