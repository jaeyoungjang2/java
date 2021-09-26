import java.util.Scanner;

public class baekjoon10972_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n];

        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }

        int reverse = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (info[reverse] < info[i]) {
                reverse = i;
                continue;
            }
            break;
        }

        if (reverse == 0) {
            System.out.println(-1);
            System.exit(0);
        }

        
    }
}
