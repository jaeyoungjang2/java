import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon1967 {
    static ArrayList<Integer>[] nodeInfo;
    static int[][] dist;

    static void postorder(int node,int depth){
        for (int i = 0; i < ; i++) {
            
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodeInfo = new ArrayList[n + 1];
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            nodeInfo[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int nodeP = sc.nextInt();
            int nodeC = sc.nextInt();
            int depth = sc.nextInt();
            nodeInfo[nodeP].add(nodeC);
            dist[nodeP][nodeC] = depth;
        }

        postorder(1, 0);

    }
}

class Node{
    int long = 0;
    int total = 0;
}