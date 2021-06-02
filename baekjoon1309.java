import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1309 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long ary[][] = new long[num + 1][3];
        ary[1][0] = 1;
        ary[1][1] = 1;
        ary[1][2] = 1;

        for (int i = 2; i < num + 1; i++) {
            ary[i][0] = (ary[i - 1][0] + ary[i - 1][1] + ary[i - 1][2]) % 9901;
            ary[i][1] = (ary[i - 1][0] + ary[i - 1][2]) % 9901;
            ary[i][2] = (ary[i - 1][0] + ary[i - 1][1]) % 9901;
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            res += ary[num][i];
        }
        System.out.println(res % 9901);
    }
}