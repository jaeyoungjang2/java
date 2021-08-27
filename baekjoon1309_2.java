import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1309_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[n + 1][3];

        for (int i = 0; i < 3; i++) {
            info[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            info[i][0] = ((info[i - 1][0] + info[i - 1][1]) % 9901 + info[i - 1][2]) % 9901;
            info[i][1] = (info[i - 1][0] + info[i - 1][2]) % 9901;
            info[i][2] = (info[i - 1][0] + info[i - 1][1]) % 9901;
        }
        System.out.println((info[n][0] + info[n][1] + info[n][2]) % 9901);
    }
}
