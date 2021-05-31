import java.util.Scanner;

public class baekjoon10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = 0;
        long[][] ary = new long[101][10];
        for (int i = 1; i < 10; i++) {
            ary[1][i] = 1;
        }

        for (int i = 2; i <= num; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    ary[i][j] = ary[i - 1][1];
                } else if (j == 9) {
                    ary[i][j] = ary[i - 1][8];
                } else {
                    ary[i][j] = (ary[i - 1][j + 1] + ary[i - 1][j - 1]) % 1000000000;
                }
            }
        }

        for (int k = 0; k <= 9; k++) {
            res += ary[num][k];
            res = res % 1000000000;
        }
        System.out.println(res);

    }
}
