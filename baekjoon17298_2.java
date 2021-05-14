import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon17298_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] numbers = new int[num];
        int[] res = new int[num];

        for (int i = 0; i < num; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }

        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                res[stk.pop()] = numbers[i];
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            res[stk.pop()] = -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb.toString());

    }
}
