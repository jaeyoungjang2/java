import java.util.Arrays;
import java.util.Scanner;

public class baekjoon2225_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] info = new int[k + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            info[1][i] = 1;
        }

        for (int i = 2; i <= k; i++) {
            info[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                info[i][j] = info[i][j - 1]%1000000000 + info[i - 1][j]%1000000000;
            }
        }
        System.out.println(info[k][n]%1000000000);
    }
}
