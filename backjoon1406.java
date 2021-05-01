import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class backjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        int count = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<Character>();
        Stack<Character> rigthStack = new Stack<Character>();

        for (int i = 0; i < string.length(); i++) {
            leftStack.add(string.charAt(i));
        }

        for (int i = 0; i < count; i++) {
            String fullCmd = br.readLine();
            Character cmd = fullCmd.charAt(0);
            switch (cmd) {
                case 'L':
                    if (leftStack.size() > 0)
                        rigthStack.add(leftStack.pop());
                    break;
                case 'D':
                    if (rigthStack.size() > 0) {
                        leftStack.add(rigthStack.pop());
                    }
                    break;
                case 'P':
                    leftStack.add(fullCmd.charAt(2));
                    break;
                case 'B':
                    if (leftStack.size() > 0)
                        leftStack.pop();
                    break;
                default:
                    break;
            }
        }
        while (!rigthStack.isEmpty()) {
            leftStack.add(rigthStack.pop());
        }
        for (Character character : leftStack) {
            // System.out.print(character);
            bw.write(character);
        }
        bw.flush();
        bw.close();
    }

}
