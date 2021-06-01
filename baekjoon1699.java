import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            ary[i] = i;
            for (int j = 0; j * j <= i; j++) {
                if (ary[i - j * j] + 1 < ary[i]) {
                    ary[i] = ary[i - j * j] + 1;
                }
            }
        }
        System.out.println(ary[num]);
    }
}
