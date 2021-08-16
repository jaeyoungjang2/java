import java.util.Scanner;

public class baekjoon11052_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            info[i] = sc.nextInt();
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                info[i] = Math.max(info[i], info[i - j] + info[j]);
            }
        }

        System.out.println(info[n]);
    }
}
