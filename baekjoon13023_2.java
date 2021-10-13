import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon13023_2 {
    private static boolean[] visit;
    private static int isTrue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        visit = new boolean[vertex];
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();

        // 어레이 리스트 초기화
        for (int i = 0; i < vertex; i++) {
            info.add(new ArrayList<>());
        }

        // 양방향 간선 정보 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            info.get(from).add(to);
            info.get(to).add(from);
        }

        // 정점마다 모든 간선 확인
        for (int i = 0; i < vertex; i++) {
            visit[i] = true;
            dfs(info, i, 1);
            visit[i] = false;
        }

        System.out.println(0);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> info, int currentVertex, int index) {
        if (index == 5) {
            System.out.println(1);
            System.exit(0);
            return;
        }
        for (int nextVertex : info.get(currentVertex)) {
            if (!visit[nextVertex]) {
                visit[nextVertex] = true;
                dfs(info, nextVertex, index + 1);
                visit[nextVertex] = false;
            }
        }
    }
}
