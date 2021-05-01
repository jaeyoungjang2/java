import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class backjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        int count = Integer.parseInt(br.readLine());

        ArrayList<Character> res = new ArrayList<Character>();

        for (int i = 0; i < string.length(); i++) {
            res.add(string.charAt(i));
        }
        int index = res.size();

        for (int i = 0; i < count; i++) {
            String fullCmd = br.readLine();
            Character cmd = fullCmd.charAt(0);
            switch (cmd) {
                case 'L':
                    if (index > 0) {
                        index--;
                    }
                    break;
                case 'D':
                    if (index < res.size()) {
                        index++;
                    }
                    break;
                case 'P':
                    res.add(index, fullCmd.charAt(2));
                    index++;
                    break;
                case 'B':
                    if (index > 0) {
                        res.remove(index - 1);
                        index--;
                    }
                    break;
                default:
                    break;
            }
        }
        for (Character character : res) {
            // System.out.print(character);
            bw.write(character);
        }
        bw.flush();
        bw.close();
    }

}
