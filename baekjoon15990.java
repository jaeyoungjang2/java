import java.util.Scanner;

public class baekjoon15990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[][] ary = new long[100002][4];
        ary[1][1] = 1;
        ary[2][2] = 1;
        ary[3][1] = 1;
        ary[3][2] = 1;
        ary[3][3] = 1;
        for (int i = 4; i <= 100001; i++) {
            ary[i][1] = (ary[i - 1][2] + ary[i - 1][3]) % 1000000009;
            ary[i][2] = (ary[i - 2][1] + ary[i - 2][3]) % 1000000009;
            ary[i][3] = (ary[i - 3][1] + ary[i - 3][2]) % 1000000009;
        }

        for (int i = 0; i < num; i++) {
            int target = sc.nextInt();
            System.out.println((ary[target][1] + ary[target][2] + ary[target][3]));
            System.out.println((ary[target][3] + ary[target][2]) + ary[target][1]);
        }

        sc.close();
    }
}