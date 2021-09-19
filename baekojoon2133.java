import java.util.Arrays;
import java.util.Scanner;

public class baekojoon2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[31];

        info[0] = 1;
        info[2] = 3;
        for (int i = 4; i <= 30; i += 2) {
            info[i] = info[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                info[i] += info[j] * 2;
            }

        }

        System.out.println(info[n]);
    }
}
