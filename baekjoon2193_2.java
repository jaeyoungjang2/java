import java.util.Scanner;

public class baekjoon2193_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] info = new long[91][2];

        info[1][0] = 0;
        info[1][1] = 1;
        for (int i = 2; i <= 90; i++) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    info[i][j] = info[i - 1][0] + info[i - 1][1];
                    continue;
                }
                info[i][j] = info[i - 1][0];
            }
        }

        long res = 0;
        res = info[n][0] + info[n][1];
        System.out.println(res);
    }
}
