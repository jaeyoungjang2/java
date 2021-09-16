import java.util.Arrays;
import java.util.Scanner;

public class baekjoon13398_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n];
        int[] forward = new int[n];
        int[] reverse = new int[n];
        int[] total = new int[n];

        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }

        forward[0] = info[0];
        for (int i = 1; i < n; i++) {
            forward[i] = info[i];
            if (forward[i - 1] >= 0) {
                forward[i] = forward[i - 1] + forward[i];
                continue;
            }
        }

        reverse[n - 1] = info[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            reverse[i] = info[i];
            if (reverse[i + 1] >= 0) {
                reverse[i] = reverse[i + 1] + reverse[i];
            }
        }

        int res = Arrays.stream(forward).max().getAsInt();

        for (int i = 1; i < n - 1; i++) {
            if (res < forward[i - 1] + reverse[i + 1]) {
                res = forward[i - 1] + reverse[i + 1];
            }
            total[i] = forward[i - 1] + reverse[i + 1];
        }

        System.out.println(res);
    }
}
