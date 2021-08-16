import java.util.Scanner;

public class baekjoon11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[1001];
        info[1] = 1;
        info[2] = 3;
        for (int i = 3; i <= n; i++) {
            info[i] = (info[i - 2] * 2 + info[i - 1]) % 10007;
        }

        System.out.println(info[n]);
    }
}
