import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class baekjoon17404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[][] = new int[num + 1][3];

        // 색상별 가격
        for (int i = 1; i < num + 1; i++) {
            for (int j = 0; j < 3; j++) {
                ary[i][j] = sc.nextInt();
            }
        }

        int totAry[][] = new int[num + 1][3];
        int resAry[] = new int[3];
        for (int i = 0; i < 3; i++) {
            totAry[1][i] = ary[1][i];
            if (i == 0) {
                totAry[1][1] = 1001;
                totAry[1][2] = 1001;
            } else if (i == 1) {
                totAry[1][0] = 1001;
                totAry[1][2] = 1001;
            } else if (i == 2) {
                totAry[1][0] = 1001;
                totAry[1][1] = 1001;
            }
            for (int j = 2; j < num + 1; j++) {
                totAry[j][0] = Math.min(totAry[j - 1][1], totAry[j - 1][2]) + ary[j][0];
                totAry[j][1] = Math.min(totAry[j - 1][0], totAry[j - 1][2]) + ary[j][1];
                totAry[j][2] = Math.min(totAry[j - 1][0], totAry[j - 1][1]) + ary[j][2];
            }
            if (i == 0) {
                resAry[0] = Math.min(totAry[num][1], totAry[num][2]);
            } else if (i == 1) {
                resAry[1] = Math.min(totAry[num][0], totAry[num][2]);
            } else if (i == 2) {
                resAry[2] = Math.min(totAry[num][0], totAry[num][1]);
            }
        }
        int res = 1000 * num;
        for (int i = 0; i < 3; i++) {
            if (res > resAry[i]) {
                res = resAry[i];
            }
        }
        System.out.println(res);
    }
}
