import java.util.Scanner;

public class baekjoon2250_4 {
    static int order = 1;
    static Node[] nodeInfo;

    static void inorder(int node, int depth) {
        if (node == -1) {
            return;
        }
        inorder(nodeInfo[node].left, depth + 1);
        nodeInfo[node].depth = depth;
        nodeInfo[node].order = order++;
        inorder(nodeInfo[node].right, depth + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] hasParent = new boolean[n + 1];
        nodeInfo = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            nodeInfo[node] = new Node(left, right);
            if (left != -1) {
                hasParent[left] = true;
            }
            if (right != -1) {
                hasParent[right] = true;
            }
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (!hasParent[i]) {
                root = i;
                break;
            }
        }
        inorder(root, 1);

        int[] orderLeft = new int[n + 1];
        int[] orderRight = new int[n + 1];
        // find max depth
        // 모든 노드를 순회하면서 가장 깊은 depth를 찾는다
        int maxDepth = 0;
        for (int node = 1; node <= n; node++) {
            int depth = nodeInfo[node].depth;
            maxDepth = Math.max(maxDepth, depth);

            int order = nodeInfo[node].order;
            if (orderLeft[depth] == 0) {
                orderLeft[depth] = order;
            } else {
                orderLeft[depth] = Math.min(orderLeft[depth], order);
            }
            orderRight[depth] = Math.max(orderRight[depth], order);
        }
        int maxWidth = 0;
        int maxWidthDepth = 0;
        for (int depth = 1; depth <= maxDepth; depth++) {
            int currWidth = orderRight[depth] - orderLeft[depth] + 1;
            if (maxWidth < currWidth) {
                maxWidth = currWidth;
                maxWidthDepth = depth;
            }
        }
        System.out.println(maxWidthDepth + " " + maxWidth);
    }
}

class Node {
    int left;
    int right;
    int depth;
    int order;

    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}