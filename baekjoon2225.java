import java.util.Arrays;
import java.util.Scanner;

public class baekjoon2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ary[][] = new long[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            ary[i][1] = 1;
            for (int j = 2; j < k + 1; j++) {
                for (int l = 0; l < i + 1; l++) {
                    ary[i][j] += ary[i - l][j - 1];
                    ary[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(ary[n][k]);

    }
}
