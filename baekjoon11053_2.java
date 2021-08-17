import java.util.Arrays;
import java.util.Scanner;

public class baekjoon11053_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] info = new int[n];
        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
            int maxIndex = 1;
            for (int j = 0; j < i; j++) {
                if (info[i] > info[j] && maxIndex <= index[j]) {
                    maxIndex = index[j] + 1;
                }
            }
            index[i] = maxIndex;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, index[i]);
        }
        System.out.println(res);
    }
}
