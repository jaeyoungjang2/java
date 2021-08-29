import java.util.Scanner;

public class baekjoon11057_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            info[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            info[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                info[i][j] = (info[i - 1][j] + info[i][j - 1]) % 10007;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += info[n][i];
            res %= 10007;
        }
        System.out.println(res);
        System.out.println(res);
        System.out.println(res);
    }
}
