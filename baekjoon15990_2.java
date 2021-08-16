import java.util.Arrays;
import java.util.Scanner;

public class baekjoon15990_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[100001][4];

        info[1][1] = 1;
        info[2][2] = 1;
        info[3][1] = 1;
        info[3][2] = 1;
        info[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            info[i][1] = (info[i - 1][3] + info[i - 1][2]) % 1000000009;
            info[i][2] = (info[i - 2][1] + info[i - 2][3]) % 1000000009;
            info[i][3] = (info[i - 3][1] + info[i - 3][2]) % 1000000009;
        }

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            System.out.println(((info[temp][1] + info[temp][2])% 1000000009 + info[temp][3]) % 1000000009);
        }

    }
}
