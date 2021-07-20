import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visit = new boolean[n + 1];

        ArrayList<Integer>[] nodeInfo = new ArrayList[n + 1];
        int[] parentInfo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeInfo[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            nodeInfo[node1].add(node2);
            nodeInfo[node2].add(node1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (Integer nextNode : nodeInfo[node]) {
                if (!visit[nextNode]) {
                    q.add(nextNode);
                    parentInfo[nextNode] = node;
                    visit[nextNode] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(parentInfo[i]);
        }
    }

}
