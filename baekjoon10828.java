import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon10828 {
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            if (temp[0].equals("push")) {
                Push(temp);
            } else if (temp[0].equals("pop")) {
                sb.append(Pop()).append("\n");
            } else if (temp[0].equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (temp[0].equals("top")) {
                sb.append(Top()).append("\n");
            } else if (temp[0].equals("empty")) {
                sb.append(Empty()).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int Pop() {
        if (stack.size() == 0) {
            return -1;
        }
        return stack.pop();
    }

    static void Push(String[] temp) {
        stack.push(Integer.parseInt(temp[1]));
    }

    static int Empty() {
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    static int Top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
}