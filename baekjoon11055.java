import java.util.Arrays;
import java.util.Scanner;

public class baekjoon11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num + 1];
        int d[] = new int[num + 1];
        int tot[] = new int[num + 1];
        d[1] = 1;
        for (int i = 1; i < num + 1; i++) {
            ary[i] = sc.nextInt();
            for (int j = 1; j < i + 1; j++) {
                if (ary[i] > ary[j] & d[i] <= d[j]) {
                    d[i] = d[j] + 1;
                    tot[i] += ary[j];
                }
            }
            tot[i] += ary[i];
        }

        int res = 0;
        for (int i = 1; i < num + 1; i++) {
            if (res < tot[i]) {
                res = tot[i];
            }
        }
        System.out.println(Arrays.toString(tot));
        System.out.println(res);

    }
}
