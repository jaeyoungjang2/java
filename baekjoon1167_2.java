import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1167_2 {
    private static int[][] distancInfo;
    // private static ArrayList<ArrayList<Integer>> edgeInfo;
    private static boolean[] visit;
    private static int maximumDistance = 0;
    private static int maximumDistanceNode = 0;
    private static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // edgeInfo = new ArrayList<>();
        distancInfo = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        // for (int i = 0; i < n + 1; i++) {
        // edgeInfo.add(new ArrayList<>());
        // }

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
                // edgeInfo.get(node1).add(node2);
                // edgeInfo.get(node2).add(node1);
            }
        }

        visit[1] = true;
        bfs1167_findMaximumDistance(1, 0);

        maximumDistance = 0;
        visit = new boolean[n + 1];
        visit[maximumDistanceNode] = true;
        bfs1167_findMaximumDistance(maximumDistanceNode, 0);
        System.out.println(maximumDistance);
    }

    private static void bfs1167_findMaximumDistance(int currentNode, int distance) {
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(currentNode, 0));

        while (!queue.isEmpty()) {
            NodeInfo node = queue.remove();
            distance = node.distance;
            currentNode = node.node;

            if (maximumDistance < distance) {
                maximumDistance = distance;
                maximumDistanceNode = currentNode;
            }

            for (int nextNode = 0; nextNode < n + 1; nextNode++) {
                if (!visit[nextNode] && distancInfo[currentNode][nextNode] != 0) {
                    visit[nextNode] = true;
                    int nextDistance = distance + distancInfo[currentNode][nextNode];
                    queue.add(new NodeInfo(nextNode, nextDistance));
                }
            }
        }
    }
}

class NodeInfo {
    int distance;
    int node;

    public NodeInfo(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public void setDistance(int distnace) {
        this.distance += distnace;
    }
}