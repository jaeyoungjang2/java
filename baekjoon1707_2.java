import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1707_2 {
    // 방문 여부 확인 및, 이분 결과 저장
    // 0 == 방문한 적 없음
    // 1 == 방문한 적 있고, 이분하였을 때의 결과를 저장
    // 2 == 방문한 적 있고, 이분하였을 때의 결과를 저장
    private static int[] visit;
    private static ArrayList<ArrayList<Integer>> info;
    private static boolean isTrue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int vertex;
        int edge;

        int from;
        int to;
        for (int i = 0; i < n; i++) {
            isTrue = true;
            st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            visit = new int[vertex + 1];

            // Arraylist 초기화
            info = new ArrayList<>();
            for (int j = 0; j < vertex + 1; j++) {
                info.add(new ArrayList<>());
            }

            // 단방향 간선 관계 정보 입력
            for (int j = 0; j < edge; j++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());

                info.get(from).add(to);
                info.get(to).add(from);
            }

            for (int j = 1; j < vertex + 1; j++) {
                if (visit[j] == 0) {
                    dfs1707(j, 1);
                }
            }
            if (isTrue) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static void dfs1707(int currentVertex, int bipartite) {
        visit[currentVertex] = bipartite;
        for (int nextVertex : info.get(currentVertex)) {
            if (visit[nextVertex] == 0) {
                dfs1707(nextVertex, 2 / bipartite);
            } else if (visit[nextVertex] != 2 / bipartite) {
                isTrue = false;

            }
        }
    }
}
