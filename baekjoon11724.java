import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon11724 {
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> ary;

    public static void main(String[] args) {
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int edgeNum = sc.nextInt();
        int nodeNum = sc.nextInt();
        ary = new ArrayList<>();

        visit = new boolean[edgeNum + 1];
        for (int i = 0; i < edgeNum + 1; i++) {
            visit[i] = true;
            ary.add(new ArrayList<>());
            ary.get(i).add(0);
        }

        int edge1;
        int edge2;
        for (int i = 1; i < nodeNum + 1; i++) {
            edge1 = sc.nextInt();
            edge2 = sc.nextInt();
            ary.get(edge1).add(edge2);
            ary.get(edge2).add(edge1);
        }

        for (int i = 1; i < edgeNum + 1; i++) {
            if (visit[i]) {
                visit[i] = false;
                count++;
                // toDo: permutation 함수 실행 예정
                permutation(i);
            }
        }
        System.out.println(count);
    }

    static void permutation(int targetEdge) {
        for (int edge : ary.get(targetEdge)) {
            if (visit[edge]) {
                visit[edge] = false;
                permutation(edge);
            }
        }
    }

}
