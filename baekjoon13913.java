import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon13913 {
    public static void main(String[] args) {

        // 수빈이와 동생의 숨바꼭질 (동생을 찾아라)
        // 수빈이는 +1, -1, *2 로 이동을 할 수 있다.
        // 수빈이가 동생을 찾는데 걸리는 최소시간과, 최단경로를 나타내라
        // 4, 5, 6, 7 경로로 이동하였을 때
        // 최단 경로를 구하는 방법
        // dist[5] = 4
        // dist[6] = 5
        // dist[7] = 6
        // dist[4] = 0
        // stack에 넣어주고 stack에서 하나씩 프린트를 해주자
        // 최단 시간을 구하는 방법
        // bfs를 이용해서 구하자

        int max = 1000000;
        int[] time = new int[max];
        int[] dist = new int[max];
        boolean[] visit = new boolean[max];
        visit[5] = true;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int n = q.remove();
            if (n == y) {
                break;
            }
            // n+1 로 이동했을 때
            if (n + 1 < max && visit[n + 1] == false) {
                visit[n + 1] = true;
                time[n + 1] = time[n] + 1;
                dist[n + 1] = n;
                q.add(n + 1);
            }
            if (n - 1 >= 0 && visit[n - 1] == false) {
                visit[n - 1] = true;
                time[n - 1] = time[n] + 1;
                dist[n - 1] = n;
                q.add(n - 1);
            }
            if (2 * n < max && visit[2 * n] == false) {
                visit[2 * n] = true;
                time[2 * n] = time[n] + 1;
                dist[2 * n] = n;
                q.add(2 * n);
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(y);
        int tempY = y;

        while (true) {
            tempY = dist[tempY];
            if (tempY == 0) {
                break;
            }
            stack.add(tempY);
        }
        System.out.println(time[y]);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
