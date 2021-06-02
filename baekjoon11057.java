import java.util.Scanner;

public class baekjoon11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long ary[][] = new long[num + 1][10];
        for (int i = 0; i < 10; i++) {
            ary[1][i] = 1;
        }
        for (int i = 2; i < num + 1; i++) {
            ary[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                ary[i][j] = (ary[i - 1][j] + ary[i][j - 1]) % 10007;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += ary[num][i];
            res %= 10007;
        }
        System.out.println(res);
        sc.close();
    }
}