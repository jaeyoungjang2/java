import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1167_2 {
    private static ArrayList<ArrayList<NodeRelationInfo>> nodeRelationInfos;
    private static boolean[] visit;
    private static int maximumDistance = 0;
    private static int maximumDistanceNode = 0;
    private static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodeRelationInfos = new ArrayList<>();
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            nodeRelationInfos.add(new ArrayList<>());
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
                nodeRelationInfos.get(node1).add(new NodeRelationInfo(node2, distance));
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
        Queue<NodeRelationInfo> queue = new LinkedList<>();
        queue.add(new NodeRelationInfo(currentNode, distance));

        while (!queue.isEmpty()) {
            NodeRelationInfo nodeRelationInfo = queue.remove();
            currentNode = nodeRelationInfo.node;
            distance = nodeRelationInfo.distance;

            for (NodeRelationInfo nextNodeRelationInfo : nodeRelationInfos.get(currentNode)) {
                int nextNode = nextNodeRelationInfo.node;
                int nextNodeDistance = nextNodeRelationInfo.distance;

                if (!visit[nextNode]) {
                    visit[nextNode] = true;
                    queue.add(new NodeRelationInfo(nextNode, distance + nextNodeDistance));
                    if (maximumDistance < distance + nextNodeDistance) {
                        maximumDistance = distance + nextNodeDistance;
                        maximumDistanceNode = nextNode;
                    }
                }
            }
        }
    }
}

class NodeRelationInfo {
    int distance;
    int node;

    public NodeRelationInfo(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public void setDistance(int distnace) {
        this.distance += distnace;
    }
}