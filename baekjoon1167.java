import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1167 {
    private static int[][] distanceInfo;
    private static ArrayList<ArrayList<Integer>> info;
    private static boolean[] visit;
    public static void main(String[] args) throws IOException {
        // 5
        // 1 3 2 -1
        // 2 4 4 -1
        // 3 1 2 4 3 -1
        // 4 2 4 3 3 5 6 -1
        // 5 4 6 -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        distanceInfo = new int[n +1][n +1];
        visit = new boolean[n + 1];
        info = new ArrayList<>();

        for (int i = 0; i < n +1; i++) {
            info.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            while (true) {
                int node2 = Integer.parseInt(st.nextToken());
                if (node2 == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                distanceInfo[node1][node2] = distance;
                distanceInfo[node2][node1] = distance;
                info.get(node1).add(node2);
                info.get(node2).add(node1);
            }
        }
    }
    private static Integer postOrder1167(int currentNode) {
        ArrayList<Integer> currentNodeDistance = new ArrayList<>();
        for (int childNode : info.get(currentNode)) {
            if (!visit[childNode]) {
                visit[childNode] = true;
                postOrder1167(childNode);
            }
        }
    }
}
