import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class backjoon10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputString = br.readLine();

        Integer left = 0;
        Integer res = 0;
        Character lastTarget = ')';
        for (int i = 0; i < inputString.length(); i++) {
            Character target = inputString.charAt(i);
            if (target == ')' && lastTarget == '(') {
                res += left - 1;
                left -= 1;
            } else if (target == '(') {
                left += 1;
            } else if (target == ')' && lastTarget != '(') {
                res += 1;
                left -= 1;
            }
            lastTarget = target;
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
