import java.util.Scanner;

public class baekjoon1576 {
    public static void main(String[] args) {
        // 1 16 16
        // 16
        Scanner sc = new Scanner(System.in);
        int targetE = sc.nextInt();
        int targetS = sc.nextInt();
        int targetM = sc.nextInt();

        int e = 0;
        int s = 0;
        int m = 0;
        int total = 0;

        while (true) {
            if (e == targetE && s == targetS && m == targetM) {
                break;
            }
            e++;
            s++;
            m++;
            total++;
            if (e > 15) {
                e = 1;
            }
            if (s > 28) {
                s = 1;
            }
            if (m > 19) {
                m = 1;
            }
        }
        System.out.println(total);
    }
}
