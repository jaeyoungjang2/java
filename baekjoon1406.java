import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon1406 {
    public static void main(String[] args) throws IOException {

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            leftStack.push(input.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            String[] tempArray = temp.split(" ");
            Character cmd = tempArray[0].charAt(0);
            if (cmd.equals('P')) {
                leftStack.push(tempArray[1].charAt(0));
            } else if (cmd.equals('L') && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            } else if (cmd.equals('B') && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (cmd.equals('D') && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
        }
        while (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }

        for (Character character : leftStack) {
            sb.append(character);
        }
        System.out.println(sb);
    }
}
