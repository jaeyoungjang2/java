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
        ArrayList<Integer>[] res = new ArrayList[n + 1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            info[i] = new ArrayList<>();
            res[i] = new ArrayList<>();
            visit[i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            info[x].add(y);
            info[y].add(x);
        }

        q.add(1);
        res[0].add(1);
        visit[1] = false;
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int temp = q.poll();
            for (int b : info[temp]) {
                if (visit[b]) {
                    visit[b] = false;
                    q.add(b);
                    res[count].add(b);
                }
            }
        }
        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println(res[2]);
        System.out.println(res[3]);

        for (int i = 0; i < n; i++) {
            if (res[i].size() == 0) {
                continue;
            }
            boolean isTrue = false;

        }
    }

}
