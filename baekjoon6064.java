import java.util.Scanner;

public class baekjoon6064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {

            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int gcd = GCD(m, n);
            int lcd = m * n / gcd;

            boolean isTrue = false;

            for (int j = x; j <= lcd; j += m) {
                int tempY = j % n == 0 ? n : j % n;
                if (tempY == y) {
                    isTrue = true;
                    System.out.println(j);
                    break;
                }
            }

            if (!isTrue) {
                System.out.println(-1);
            }
        }
    }

    static Integer GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
