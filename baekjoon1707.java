import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon1707 {
    static ArrayList<ArrayList<Integer>> ary;
    static ArrayList<ArrayList<Integer>> test;
    static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();

        int vertex;
        int edge;
        int edge1;
        int edge2;

        for (int i = 0; i < cycle; i++) {
            edge = sc.nextInt();
            vertex = sc.nextInt();
            visit = new int[edge + 1];
            test = new ArrayList<>();
            for (int j = 0; j < edge + 1; j++) {
                test.add(new ArrayList<>());
            }

            for (int j = 0; j < vertex; j++) {
                edge1 = sc.nextInt();
                edge2 = sc.nextInt();
                test.get(edge1).add(edge2);
                test.get(edge2).add(edge1);
            }
            boolean res = true;
            for (int j = 1; j < edge + 1; j++) {
                if (visit[j] == 0) {
                    if (permutation(1, j) == false) {
                        res = false;
                    }
                }
            }
            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    static Boolean permutation(int curGroup, int curEdge) {
        visit[curEdge] = curGroup;
        for (int nextEdge : test.get(curEdge)) {
            int nextGroup = 3 - curGroup;
            if (visit[nextEdge] == 0) {
                if (permutation(nextGroup, nextEdge) == false) {
                    return false;
                }
            } else if (visit[nextEdge] == curGroup) {
                return false;
            }
        }
        return true;
    }
}
