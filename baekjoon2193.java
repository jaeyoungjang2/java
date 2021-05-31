import java.util.Scanner;

public class baekjoon2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[][] ary = new long[92][2];
        ary[1][1] = 1;
        for (int i = 2; i <= 91; i++) {
            ary[i][0] = ary[i - 1][1] + ary[i - 1][0];
            ary[i][1] = ary[i - 1][0];
        }
        System.out.println(ary[num][0] + ary[num][1]);
    }
}
