import java.util.Arrays;
import java.util.Scanner;

public class baekjoon11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num + 1];
        int forAry[] = new int[num + 1];
        int revAry[] = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            revAry[i] = 1;
            forAry[i] = 1;
        }
        forAry[1] = 1;
        revAry[num] = 1;

        for (int i = 1; i < num + 1; i++) {
            ary[i] = sc.nextInt();
            for (int j = 1; j < i; j++) {
                if (ary[i] > ary[j] && forAry[i] <= forAry[j]) {
                    forAry[i] = forAry[j] + 1;
                }
            }
        }

        for (int i = num; i >= 1; i--) {
            for (int j = num; j > i; j--) {
                if (ary[i] > ary[j] && revAry[i] <= revAry[j]) {
                    revAry[i] = revAry[j] + 1;
                }
            }
        }
        int res = 0;

        for (int i = 1; i < num + 1; i++) {
            if (res < forAry[i] + revAry[i]) {
                res = forAry[i] + revAry[i];
            }
        }
        System.out.println(res - 1);
        // System.out.println(Arrays.toString(forAry));
        // System.out.println(Arrays.toString(revAry));
    }
}
