import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[][] = new int[num + 1][num + 1];
        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                ary[i][j] = sc.nextInt();
            }
        }
        int totAry[][] = new int[num + 1][num + 1];
        totAry[1][1] = ary[1][1];
        for (int i = 2; i < num + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                totAry[i][j] = Math.max(totAry[i - 1][j - 1], totAry[i - 1][j]) + ary[i][j];
            }
        }
        int res = 0;
        for (int i = 1; i < num + 1; i++) {
            if (res < totAry[num][i]) {
                res = totAry[num][i];
            }
        }
        System.out.println(res);
    }
}
