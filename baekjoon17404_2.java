import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class baekjoon17404_2 {
    private static final int MAX = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[n][3];
        int[] temp = new int[3];
        int[] res = new int[3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            res[0] = MAX + 1;
            res[1] = MAX + 1;
            res[2] = MAX + 1;
            res[i] = info[0][i];

            for (int j = 1; j < n; j++) {
                int res0 = Math.min(res[1], res[2]) + info[j][0];
                int res1 = Math.min(res[0], res[2]) + info[j][1];
                int res2 = Math.min(res[1], res[0]) + info[j][2];
                res[0] = res0;
                res[1] = res1;
                res[2] = res2;
            }

            if (i == 0) {
                temp[0] = Math.min(res[1], res[2]);
            }
            if (i == 1) {
                temp[1] = Math.min(res[0], res[2]);
            }
            if (i == 2) {
                temp[2] = Math.min(res[0], res[1]);
            }
        }
        int min = Arrays.stream(temp).min().getAsInt();
        System.out.println(min);
    }
}
