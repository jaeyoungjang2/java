import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon1167_3 {
    private static ArrayList<ArrayList<CurrentNodeToNextNodeRelationInfo1167_3>> nodeInfo;
    private static boolean[] visit;
    private static int maximumDistance = 0;
    private static int maximumDistanceNode = 0;
    private static int n;
    private static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodeInfo = new ArrayList<>();
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            nodeInfo.add(new ArrayList<>());
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
                nodeInfo.get(node1).add(new CurrentNodeToNextNodeRelationInfo1167_3(node2, distance));
            }
        }
        visit[1] = true;
        NodeInfo1167_3 nodeInfo = dfs1167_3(1);
        System.out.println(Math.max(Math.max(nodeInfo.radius, nodeInfo.diaMeter), result));
    }

    private static NodeInfo1167_3 dfs1167_3(int currentNode) {

        // 하위 노드들의 정보를 취합
        ArrayList<Integer> radiuses = new ArrayList<>();
        for (CurrentNodeToNextNodeRelationInfo1167_3 cur2nextInfo : nodeInfo.get(currentNode)) {
            int nextNode = cur2nextInfo.node;
            int distance = cur2nextInfo.distance;

            if (!visit[nextNode]) {
                visit[nextNode] = true;
                NodeInfo1167_3 nextNodeInfo = dfs1167_3(nextNode);
                int radius = nextNodeInfo.radius;
                int diaMeter = nextNodeInfo.diaMeter;
                radiuses.add(radius + distance);

                if (diaMeter > result) {
                    result = diaMeter;
                }
            }
        }

        Collections.sort(radiuses, Collections.reverseOrder());
        int currentNodeMaximumRadius = 0;
        int currentNodeMaximumDiamMeter = 0;

        if (radiuses.size() >= 1) {
            currentNodeMaximumRadius = radiuses.get(0);
        }

        if (radiuses.size() >= 2) {
            currentNodeMaximumDiamMeter = radiuses.get(0) + radiuses.get(1);
        }

        return new NodeInfo1167_3(currentNodeMaximumDiamMeter, currentNodeMaximumRadius);
    }
}

class NodeInfo1167_3 {
    int diaMeter;
    int radius;

    public NodeInfo1167_3(int diaMeter, int radius) {
        this.diaMeter = diaMeter;
        this.radius = radius;
    }
}

class CurrentNodeToNextNodeRelationInfo1167_3 {
    // 현재 노드로 부터 떨어진 targetNode의 정보
    int distance;
    int node;

    public CurrentNodeToNextNodeRelationInfo1167_3(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public void setDistance(int distnace) {
        this.distance += distnace;
    }
}