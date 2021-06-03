import java.util.Arrays;
import java.util.Scanner;

public class baekjoon2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            ary[i] = sc.nextInt();
        }

        int totAry[][] = new int[num + 1][3];
        totAry[1][1] = ary[1];
        for (int i = 2; i < num + 1; i++) {
            int bef = Math.max(totAry[i - 1][1], totAry[i - 1][2]);
            totAry[i][0] = Math.max(totAry[i - 1][0], bef);
            totAry[i][1] = totAry[i - 1][0] + ary[i];
            totAry[i][2] = totAry[i - 1][1] + ary[i];
        }

        int res = 0;
        for (int i = 0; i < 3; i++) {
            if (totAry[num][i] > res) {
                res = totAry[num][i];
            }
        }
        System.out.println(res);
    }
}