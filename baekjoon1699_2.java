import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1699_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n + 1];
        boolean[] visit = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int num = q.remove();
            if (num == n) {
                break;
            }
            for (int i = 1; num + Math.pow(i, 2) <= n; i++) {
                if (!visit[num + (int) Math.pow(i, 2)]) {
                    q.add(num + (int) Math.pow(i, 2));
                    info[num + (int) Math.pow(i, 2)] = info[num] + 1;
                    visit[num + (int) Math.pow(i, 2)] = true;
                }
            }
        }
        System.out.println(info[n]);
    }

}
