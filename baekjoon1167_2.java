import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1167_2 {
    private static int[][] distancInfo;
    private static ArrayList<ArrayList<Integer>> edgeInfo;
    private static boolean[] visit;
    private static int maximumDistance = 0;
    private static int maximumDistanceNode = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        edgeInfo = new ArrayList<>();
        distancInfo = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            edgeInfo.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int node2 = Integer.parseInt(st.nextToken());
                if (node2 == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                distancInfo[node1][node2] = distance;
                edgeInfo.get(node1).add(node2);
                edgeInfo.get(node2).add(node1);
            }
        }
        visit[1] = true;
        dfs1167_findMaximumDistance(1, 0);
        maximumDistance = 0;
        visit = new boolean[n + 1];
        visit[maximumDistanceNode] = true;
        dfs1167_findMaximumDistance(maximumDistanceNode, 0);
        System.out.println(maximumDistance);
    }

    private static void dfs1167_findMaximumDistance(int currentNode, int distance) {
        if (maximumDistance < distance) {
            maximumDistanceNode = currentNode;
            maximumDistance = distance;
        }
        for (int nextNode : edgeInfo.get(currentNode)) {
            if (!visit[nextNode]) {
                visit[nextNode] = true;
                distance += distancInfo[currentNode][nextNode];
                dfs1167_findMaximumDistance(nextNode, distance);
                distance -= distancInfo[currentNode][nextNode];
            }
        }
    }
}
