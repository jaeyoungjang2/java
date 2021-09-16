import java.util.Arrays;
import java.util.Scanner;

public class baekjoon11054_2 {
    public static void main(String[] args) {
        // 10
        // 1 5 2 1 4 3 4 5 2 1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n];
        int[] increase = new int[n];
        int[] decrease = new int[n];
        int[] total = new int[n];

        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (info[i] > info[j] && increase[i] <= increase[j]) {
                    increase[i] = increase[j] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {

                if (info[i] > info[j] && decrease[i] <= decrease[j]) {
                    decrease[i] = decrease[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            total[i] = increase[i] + decrease[i] + 1;
        }

        int max = Arrays.stream(total).max().getAsInt();
        System.out.println(max);
    }
}
