import java.util.Scanner;

public class baekjoon10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfIronStick = 0;
        int result = 0;
        String inputString = sc.nextLine();
        char beforeCmd = ')';
        for (int i = 0; i < inputString.length(); i++) {
            char cmd = inputString.charAt(i);
            if (cmd == '(') {
                numOfIronStick++;
                beforeCmd = '(';
                continue;
            }
            numOfIronStick--;
            if (beforeCmd == '(') {
                beforeCmd = ')';
                result += numOfIronStick;
                continue;
            }
            result++;
        }
        result += numOfIronStick;
        System.out.println(result);
    }
}
