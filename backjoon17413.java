import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();
        boolean bool = false;
        String temp = "";

        for (int i = 0; i < problem.length(); i++) {
            if (problem.charAt(i) == '<') {
                StringBuffer sb = new StringBuffer(temp);
                System.out.print(sb.reverse());
                temp = "";
                bool = true;
                temp += problem.charAt(i);
                continue;
            }
            if (problem.charAt(i) == '>') {
                temp += problem.charAt(i);
                System.out.print(temp);
                temp = "";
                bool = false;
                continue;
            }
            if (bool) {
                temp += problem.charAt(i);
                continue;
            }

            if (problem.charAt(i) == ' ') {
                StringBuffer sb = new StringBuffer(temp);
                System.out.print(sb.reverse() + " ");
                temp = "";
                continue;

            }
            temp += problem.charAt(i);
        }
        if (temp.length() > 0) {
            StringBuffer sb = new StringBuffer(temp);
            System.out.print(sb.reverse());
        }

    }
}
