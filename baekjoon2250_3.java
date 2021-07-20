import java.util.Scanner;

class Node {
    int left, right;
    public int order, depth;

    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class baekjoon2250_3 {
    static Node[] a;
    static int[] left;
    static int[] right;
    static boolean[] cnt;
    static int order = 0;

    static void inorder(int node, int depth) {
        if (node == -1)
            return;
        inorder(a[node].left, depth + 1);
        a[node].order = ++order;
        a[node].depth = depth;
        inorder(a[node].right, depth + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new Node[n + 1];
        left = new int[n + 1];
        right = new int[n + 1];
        cnt = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x] = new Node(y, z);
            if (y != -1)
                cnt[y] = true;
            if (z != -1)
                cnt[z] = true;
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (!cnt[i]) {
                root = i;
            }
        }
        inorder(root, 1);
        int maxdepth = 0;
        for (int i = 1; i <= n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;
            if (depth > maxdepth) {
                maxdepth = depth;
            }
            if (left[depth] == 0) {
                left[depth] = order;
            } else if (order < left[depth]) {
                left[depth] = order;
            }
            right[depth] = Math.max(right[depth], order);

        }
        int ans = 0;
        int ans_level = 0;
        for (int i = 1; i <= maxdepth; i++) {
            int curwidth = right[i] - left[i];
            if (ans < curwidth + 1) {
                ans = curwidth + 1;
                ans_level = i;
            }
        }

        System.out.println(ans_level + " " + ans);

    }
}
