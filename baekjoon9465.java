import java.util.Arrays;
import java.util.Scanner;

public class baekjoon9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();

        for (int i = 0; i < cycle; i++) {
            int res;
            int num = sc.nextInt();
            int ary[][] = new int[num + 1][3];
            for (int j = 1; j < 3; j++) {
                for (int j2 = 1; j2 < num + 1; j2++) {
                    ary[j2][j] = sc.nextInt();
                }
            }
            int resAry[][] = new int[num + 1][3];
            resAry[1][0] = 0;
            resAry[1][1] = ary[1][1];
            resAry[1][2] = ary[1][2];
            for (int j = 2; j < num + 1; j++) {
                resAry[j][0] = Math.max(resAry[j - 1][1], resAry[j - 1][2]);
                resAry[j][1] = Math.max(resAry[j - 1][0], resAry[j - 1][2]) + ary[j][1];
                resAry[j][2] = Math.max(resAry[j - 1][0], resAry[j - 1][1]) + ary[j][2];
            }
            System.out.println(Math.max(resAry[num][1], resAry[num][2]));
        }
    }
}