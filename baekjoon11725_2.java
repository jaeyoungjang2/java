import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11725_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();
        int[] treeInfo = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        int rootNode = 1;

        for (int i = 0; i < n + 1; i++) {
            info.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            info.get(node1).add(node2);
            info.get(node2).add(node1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        visit[rootNode] = true;

        while (!queue.isEmpty()) {
            int parentNode = queue.remove();
            for (Integer childNode : info.get(parentNode)) {
                if (!visit[childNode]) {
                    visit[childNode] = true;
                    queue.add(childNode);
                    treeInfo[childNode] = parentNode;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            sb.append(treeInfo[i] + "\n");
        }
        System.out.println(sb);
    }
}
