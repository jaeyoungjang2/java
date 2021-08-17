import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon17298_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> valueStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] inputArray = new int[n];
        int[] resultArray = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            inputArray[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < n; i++) {
            while (!valueStack.isEmpty() && valueStack.peek() < inputArray[i]) {
                resultArray[indexStack.pop()] = inputArray[i];
                valueStack.pop();
            }
            valueStack.push(inputArray[i]);
            indexStack.push(i);
        }

        while (!valueStack.isEmpty()) {
            resultArray[indexStack.pop()] = -1;
            valueStack.pop();
        }

        for (int i : resultArray) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
