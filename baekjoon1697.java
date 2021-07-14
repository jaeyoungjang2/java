import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1697 {
    public static void main(String[] args) {
        // 수빈이와 동생의 좌표가 주어진다.
        // 수빈이는 x+1, x-1, 2x로 이동할 수 있다.
        // 동생을 찾는 가장 빠른 시간을 구하라
        Scanner sc = new Scanner(System.in);
        // 수빈이의 좌표
        int x = sc.nextInt();
        // 동생의 좌표
        int y = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int max = 1000000;
        int[] dist = new int[max];
        boolean[] visit = new boolean[max];
        q.add(x);

        while (!q.isEmpty()) {
            int k = q.remove();
            if (k == y) {
                break;
            }

            int x1 = k + 1;
            int x2 = k - 1;
            int x3 = 2 * k;
            // 수빈이가 x+1로 이동했을 경우
            if (x1 < max && visit[x1] == false) {
                visit[x1] = true;
                q.add(x1);
                dist[x1] = dist[k] + 1;
            }
            // 수빈이가 x-1로 이동했을 경우
            if (x2 < max && visit[x2] == false) {
                visit[x2] = true;
                q.add(x2);
                dist[x2] = dist[k] + 1;
            }
            // 수빈이가 2*x로 이동했을 경우
            if (x3 < max && visit[x3] == false) {
                visit[x3] = true;
                q.add(x3);
                dist[x3] = dist[k] + 1;
            }
        }
        System.out.println(dist[y]);
    }
}
