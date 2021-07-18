import java.util.ArrayDeque;
import java.util.Scanner;

public class baekjoon13549 {
    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int max = 200000;
        boolean visit[] = new boolean[max];
        int dist[] = new int[max];

        dq.addFirst(n);
        while (!dq.isEmpty()) {
            int cur = dq.removeFirst();
            if (cur == k) {
                break;
            }
            for (Integer next : new int[] { cur * 2, cur + 1, cur - 1 }) {
                if (next == cur * 2 && next < max && visit[next] == false) {
                    visit[next] = true;
                    dist[next] = dist[cur];
                    dq.addFirst(next);
                    continue;
                }
                if (0 <= next && next < max && visit[next] == false) {
                    visit[next] = true;
                    dist[next] = dist[cur] + 1;
                    dq.addLast(next);
                }
            }
        }
        System.out.println(dist[k]);
    }

}
