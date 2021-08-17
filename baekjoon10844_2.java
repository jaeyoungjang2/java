import java.util.Scanner;

public class baekjoon10844_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[101][10];

        for (int i = 1; i <= 9; i++) {
            info[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    info[i][j] = info[i - 1][1];
                    continue;
                } else if (j == 9) {
                    info[i][j] = info[i - 1][8];
                    continue;
                }
                info[i][j] = (info[i - 1][j - 1] + info[i - 1][j + 1]) % 1000000000;
            }
        }
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            res += info[n][i];
            res %= 1000000000;
        }
        System.out.println(res);
    }
}
