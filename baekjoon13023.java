import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon13023 {
    static ArrayList<ArrayList<Integer>> ary;
    static int result = 0;
    static boolean[] visit;
    static int memberNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        memberNum = sc.nextInt();
        ary = new ArrayList<>();
        visit = new boolean[memberNum];

        for (int i = 0; i < memberNum; i++) {
            visit[i] = true;
        }

        for (int i = 0; i < memberNum; i++) {
            ary.add(new ArrayList<>());
        }

        int nodeNum = sc.nextInt();
        int edge1;
        int edge2;

        for (int i = 0; i < nodeNum; i++) {
            edge1 = sc.nextInt();
            edge2 = sc.nextInt();
            ary.get(edge1).add(edge2);
            ary.get(edge2).add(edge1);
        }
        for (int i = 0; i < memberNum; i++) {
            visit[i] = false;
            permutation(0, i);
            visit[i] = true;
        }

        System.out.println(result);

    }

    static void permutation(int count, int target) {
        if (count == 4) {
            System.out.println(1);
            System.exit(0);
            // toDo : 결과 프린트
            result = 1;
        }

        for (Integer linkdEdge : ary.get(target)) {
            if (visit[linkdEdge]) {
                visit[linkdEdge] = false;
                permutation(count + 1, linkdEdge);
                visit[linkdEdge] = true;
            }
        }
    }
}
