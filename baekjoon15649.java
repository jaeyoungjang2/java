import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon15649 {
    static int n;
    static int m;
    static int[] info;
    static boolean[] visit;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");
        n = Integer.parseInt(string[0]);
        m = Integer.parseInt(string[1]);

        info = new int[n];
        visit = new boolean[n];

        for (int i = 1; i <= n; i++) {
            info[i - 1] = i;
        }
        combination(0);

    }

    static void combination(int index) {
        if (stack.size() == m) {
            for (int i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                stack.add(info[i]);
                combination(index + 1);
                stack.pop();
                visit[i] = false;
            }
        }

    }
}
