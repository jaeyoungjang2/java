import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon15650 {
    private static int n;
    private static int m;
    private static int[] info;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");

        int n = Integer.parseInt(string[0]);
        int m = Integer.parseInt(string[1]);

        info = new int[n];

        for (int i = 0; i < n; i++) {
            info[i] = i + 1;
        }

        combination15650(0, n, m);
    }

    private static void combination15650(int index, int n, int m) {
        if (stack.size() == m) {
            for (int i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < n; i++) {
            stack.add(info[i]);
            combination15650(i + 1, n, m);
            stack.pop();
        }
    }
}
