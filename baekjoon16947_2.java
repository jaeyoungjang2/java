import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon16947_2 {
    static int n;
    static int[] dist;
    static ArrayList<Integer>[] info;
    static boolean visit[];
    static Stack<Integer> stack;
    static boolean[] isCycle;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        info = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        isCycle = new boolean[n + 1];
        dist = new int[n + 1];
        stack = new Stack<>();
        for (int i = 1; i < n + 1; i++) {
            info[i] = new ArrayList<>();
            visit[i] = true;

        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            info[a].add(b);
            info[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            if (visit[i]) {
                visit[i] = false;
                // toDo : dfs;

                int temp = dfs(i, 1);
            }
        }
        System.out.println(Arrays.toString(isCycle));
        System.out.println(Arrays.toString(dist));
        System.out.println(stack);
    }

    static int dfs(int x, int cnt) {
        // cycle이 성립하지 않는 경우를 -1로 표현
        // cycle이 성립하는 경우 cycle의 첫부분을 res에 저장
        int res = -1;
        visit[x] = false;
        dist[x] = cnt;
        stack.push(x);

        for (int target : info[x]) {

            if (visit[target]) {
                res = dfs(target, cnt + 1);
            } else if (cnt - dist[target] >= 2) {
                // System.out.println("HI");
                // cycle이 성립
                // System.out.println("toDo: cycle 성립했을 경우,,");
                res = target;
            } else {
                continue;
            }
            // cycle이 성립하지 않았을 경우
            // stack에서 제거
            // System.out.println(stack);
            // System.out.println(res);

            // cycle에 속해 있을 경우, stack에서 뺀 수는 cycle에 포함되는 수이다.
            if (res != -1) {
                while (stack.size() >= 0) {
                    int temp = stack.pop();
                    isCycle[temp] = true;
                    if (temp == res) {
                        break;
                    }
                }
                // cycle의 시작점인 경우, 그 뒤의 스택은 사이클에 포함되지 않도록 한다.
            }
        }
        System.out.println(x);
        System.out.println("res: " + res);
        System.out.println(stack);
        if (res == -1 && stack.size() > 0) {
            stack.pop();
        }
        System.out.println();
        return res;
    }

}
