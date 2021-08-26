import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1149_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            info[i][0] = Math.min(info[i - 1][1], info[i - 1][2]) + info[i][0];
            info[i][1] = Math.min(info[i - 1][0], info[i - 1][2]) + info[i][1];
            info[i][2] = Math.min(info[i - 1][0], info[i - 1][1]) + info[i][2];
        }

        int res = info[n - 1][0];
        for (int i = 1; i < 3; i++) {
            res = Math.min(res, info[n - 1][i]);
        }
        System.out.println(res);
    }
}
