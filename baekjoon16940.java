import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon16940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] info = new ArrayList[n + 1];
        boolean[] visit = new boolean[n + 1];
        int[] order = new int[n + 1];
        int[] parent = new int[n + 1];
        // 초기화
        for (int i = 1; i < n + 1; i++) {
            info[i] = new ArrayList<>();
            visit[i] = true;
        }

        // 값 입력받기
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            info[x].add(y);
            info[y].add(x);
        }

        for (int i = 1; i < n + 1; i++) {
            order[i] = sc.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(order[1]);
        visit[order[1]] = false;
        int m = 1;

        while (!q.isEmpty()) {
            int x = q.remove();
            int cnt = 0;
            for (Integer y : info[x]) {
                if (visit[y]) {
                    visit[y] = false;
                    parent[y] = x;
                    cnt++;
                }
            }
            for (int i = 1; i < cnt + 1; i++) {
                if (parent[order[m + i]] != x) {
                    System.out.println(0);
                    System.exit(0);
                } else if (parent[order[m + 1]] == x) {
                    q.add(order[m + 1]);
                }
            }
            m += cnt;
        }
        System.out.println(1);

    }

}
