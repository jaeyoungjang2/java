import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon16947 {
    static boolean[] visit;
    static ArrayList<Integer>[] info;
    static int[] dist;
    static boolean[] isCycle;
    static Stack<Integer> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visit = new boolean[n + 1];
        info = new ArrayList[n + 1];
        dist = new int[n + 1];
        isCycle = new boolean[n + 1];
        stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            info[i] = new ArrayList<>();
            visit[i] = true;
            isCycle[i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            info[x].add(y);
            info[y].add(x);
        }

        for (int i = 1; i < n + 1; i++) {
            if (visit[i]) {
                dfs(i, 1);
                // toDO : dfs
            }
        }
        // System.out.println(info[3]);
        // System.out.println(Arrays.toString(isCycle));
        // System.out.println(Arrays.toString(dist));

        for (int i = 1; i < n + 1; i++) {
            if (isCycle[i]) {
                System.out.print("0 ");
            } else {
                Queue<Integer> q = new LinkedList<>();
                int[] d = new int[n + 1];
                q.add(i);
                while (!q.isEmpty()) {
                    int temp = q.poll();
                    if (isCycle[temp]) {
                        System.out.print(d[temp] + " ");
                        break;
                    }
                    for (Integer target : info[temp]) {
                        if (d[target] == 0) {
                            d[target] = d[temp] + 1;
                            q.add(target);
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(isCycle));
        System.out.println();
    }

    static int dfs(int x, int cnt) {
        stack.push(x);
        dist[x] = cnt;
        visit[x] = false;
        int res = -1;
        for (int target : info[x]) {
            // System.out.println(x);
            // System.out.println(target);

            if (visit[target]) {
                // System.out.println("go dfs");
                // System.out.println();
                res = dfs(target, cnt + 1);
            } else if (cnt - dist[target] >= 2) {
                // System.out.println("find cycle");
                // System.out.println();
                isCycle[target] = true;
                res = target;
            } else {
                // System.out.println("continue");
                // System.out.println();
                continue;
            }
            // System.out.println(stack);
            // System.out.println("sub res" + res);
            // System.out.println();
            if (res != -1) {
                while (stack.size() > 0) {
                    // System.out.println("HI");
                    int temp = stack.pop();
                    isCycle[temp] = true;
                    if (temp == res) {
                        res = -1;
                        break;
                    }
                }
            }
        }
        // System.out.println("total res" + res);
        // System.out.println();
        if (stack.size() > 0) {
            stack.pop();
        }

        return res;
    }

}
