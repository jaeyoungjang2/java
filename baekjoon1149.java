import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] curAry = new int[num][3];
        int[][] totAry = new int[num][3];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                curAry[i][j] = sc.nextInt();
                if (i == 0) {
                    totAry[0][j] = curAry[0][j];
                }
            }
        }

        for (int i = 1; i < num; i++) {
            totAry[i][0] = Math.min(totAry[i - 1][1], totAry[i - 1][2]) + curAry[i][0];
            totAry[i][1] = Math.min(totAry[i - 1][0], totAry[i - 1][2]) + curAry[i][1];
            totAry[i][2] = Math.min(totAry[i - 1][0], totAry[i - 1][1]) + curAry[i][2];
        }
        int res = totAry[num - 1][0];
        for (int i = 0; i < 3; i++) {
            if (res > totAry[num - 1][i]) {
                res = totAry[num - 1][i];
            }
        }
        System.out.println(res);
        System.out.println(Arrays.toString(totAry[num - 1]));

    }
}
