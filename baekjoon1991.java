import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon1991 {
    private static Map<String, Node1991> info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // Node1991[] info = new Node1991[n];
        info = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String leftEdge = st.nextToken();
            String rightEdge = st.nextToken();
            info.put(node, new Node1991(leftEdge, rightEdge));
        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    private static void preOrder(String currentNode) {
        if (currentNode.equals(".")) {
            return;
        }
        System.out.print(currentNode);
        preOrder(info.get(currentNode).left);
        preOrder(info.get(currentNode).right);
    }

    private static void inOrder(String currentNode) {
        if (currentNode.equals(".")) {
            return;
        }
        inOrder(info.get(currentNode).left);
        System.out.print(currentNode);
        inOrder(info.get(currentNode).right);
    }

    private static void postOrder(String currentNode) {
        if (currentNode.equals(".")) {
            return;
        }
        postOrder(info.get(currentNode).left);
        postOrder(info.get(currentNode).right);
        System.out.print(currentNode);
    }
}

class Node1991 {
    String left;
    String right;

    public Node1991(String left, String right) {
        this.left = left;
        this.right = right;
    }
}
