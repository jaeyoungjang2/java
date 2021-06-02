import java.util.Arrays;
import java.util.Scanner;

public class baekjoon13398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num + 1];
        int forAry[] = new int[num + 1];
        int revAry[] = new int[num + 1];

        for (int i = 1; i < num + 1; i++) {
            ary[i] = sc.nextInt();
        }

        forAry[1] = ary[1];
        revAry[num] = ary[num];

        for (int i = 2; i < num + 1; i++) {
            forAry[i] = ary[i];
            revAry[num - i + 1] = ary[num - i + 1];
            if (forAry[i] < forAry[i - 1] + ary[i]) {
                forAry[i] = forAry[i - 1] + ary[i];
            }
            if (revAry[num - i + 1] < revAry[num - i + 2] + ary[num - i + 1]) {
                revAry[num - i + 1] = revAry[num - i + 2] + ary[num - i + 1];
            }
        }
        int res = ary[1];
        for (int i = 1; i < num + 1; i++) {
            if (forAry[i] > res) {
                res = forAry[i];
            }
        }

        for (int j = 1; j <= num - 2; j++) {
            if (res < forAry[j] + revAry[j + 2]) {
                res = forAry[j] + revAry[j + 2];
            }
        }
        System.out.println(res);
        System.out.println(Arrays.toString(forAry));
        System.out.println(Arrays.toString(revAry));
    }
}
