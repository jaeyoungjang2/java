import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon2250_5 {
    // 트리 구조 문제 풀이
    private static Map<String, Node2250> info;
    private static Width2250[] widthInfo;
    private static int order = 1;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        info = new HashMap<>();
        widthInfo = new Width2250[n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();
            info.put(node, new Node2250(leftNode, rightNode));
            widthInfo[i] = new Width2250();
        }
        String root = findRoot();
        inOrder2250(root, 1);

        int maxDepth = 0;
        int maxWidth = 0;

        for (int i = 1; i < n + 1; i++) {
            if (widthInfo[i].getWidth() > maxWidth) {
                maxWidth = widthInfo[i].getWidth();
                maxDepth = i;
            }
        }
        System.out.printf("%s %s", maxDepth, maxWidth);
    }

    private static void inOrder2250(String currentNode, Integer depth) {
        if (currentNode.equals("-1")) {
            return;
        }
        // System.out.println(info.get(currentNode).left);
        inOrder2250(info.get(currentNode).left, depth + 1);
        Width2250 currentWidth = widthInfo[depth];
        currentWidth.setLeft(order);
        currentWidth.setRight(order);
        order++;
        inOrder2250(info.get(currentNode).right, depth + 1);
    }

    private static String findRoot() {
        ArrayList<String> rootInfo = new ArrayList<>();
        for (String parent : info.keySet()) {
            String leftChild = info.get(parent).left;
            String rightChild = info.get(parent).right;
            rootInfo.add(leftChild);
            rootInfo.add(rightChild);
        }

        for (String parent : info.keySet()) {
            if (!rootInfo.contains(parent)) {
                return parent;
            }
        }
        throw new IllegalArgumentException("root find error");
    }
}

class Node2250 {
    String left;
    String right;

    public Node2250(String left, String right) {
        this.left = left;
        this.right = right;
    }
}

class Width2250 {
    int left;
    int right;

    public Width2250() {
        this.left = 0;
        this.right = 0;
    }

    public void setLeft(int left) {
        if (this.left == 0) {
            this.left = left;
            return;
        }
        if (this.left >= left) {
            this.left = left;
        }
    }

    public void setRight(int right) {
        if (this.right == 0) {
            this.right = right;
            return;
        }
        if (this.right <= right) {
            this.right = right;
        }
    }

    public int getWidth() {
        return right - left + 1;
    }
}