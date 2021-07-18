import java.util.Scanner;

class Node {
    public int order, depth;
    int left, right;

    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class baekjoon2250 {
    static Node[] nodeInfo;
    static int order = 0;
    static int[] cnt = new int[10001];

    static void inorder(int node, int depth) {
        if (node == -1) {
            return;
        }
        // left로 이동 (depth 추가)
        inorder(nodeInfo[node].left, depth + 1);
        // order 추가
        nodeInfo[node].order = order++;
        nodeInfo[node].depth = depth;
        // right로 이동 (depth 추가)
        inorder(nodeInfo[node].right, depth + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        nodeInfo = new Node[n + 1];
        boolean[] hasParent = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            nodeInfo[node] = new Node(left, right);
            if (left != -1)
                cnt[left] += 1;
            if (right != -1)
                cnt[right] += 1;
        }

        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                root = i;
            }
        }
        inorder(root, 1);

        // find max depth
        int maxDepth = 0;
        int[] orderLeft = new int[n + 1];
        int[] orderRight = new int[n + 1];
        for (int node = 1; node <= n; node++) {
            int order = nodeInfo[node].order;
            int depth = nodeInfo[node].depth;
            if (orderLeft[depth] == 0) {
                orderLeft[depth] = order;
            } else {
                orderLeft[depth] = Math.min(orderLeft[depth], order);
            }
            orderRight[depth] = Math.max(orderRight[depth], order);
            maxDepth = Math.max(maxDepth, depth);
        }
        int ans = 0;
        int ans_level = 0;
        for (int i = 1; i <= maxDepth; i++) {
            if (ans < orderRight[i] - orderLeft[i] + 1) {
                ans = orderRight[i] - orderLeft[i] + 1;
                ans_level = i;
            }
        }
        System.out.println(ans_level + " " + ans);
    }
}
