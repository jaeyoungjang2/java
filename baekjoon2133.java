import java.util.Arrays;
import java.util.Scanner;

public class baekjoon2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[31];
        int totAry[] = new int[31];
        ary[0] = 1;
        ary[2] = 3;
        totAry[0] = 1;
        totAry[2] = 3;

        if (num % 2 == 1 || num == 1) {
            System.out.println(0);
        } else {
            for (int i = 4; i < num + 1; i += 2) {
                ary[i] = 2;
            }
            for (int i = 4; i <= num; i += 2) {
                for (int j = 2; j <= i; j++) {
                    totAry[i] += totAry[i - j] * ary[j];
                }

            }
            System.out.println(totAry[num]);
        }
        // System.out.println(Arrays.toString(totAry));
        // System.out.println(Arrays.toString(ary));
    }
}