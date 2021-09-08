import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class baekjoon11055_2 {
    public static void main(String[] args) {
        // 10
        // 1 100 2 50 60 3 5 6 7 8
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n + 1];
        int[] maxSumInfo = new int[n + 1];

        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }

        maxSumInfo[0] = info[0];
        for (int i = 0; i < n; i++) {
            int maxNum = 0;
            for (int j = 0; j < i; j++) {
                if (info[i] > info[j] && maxNum < maxSumInfo[j]) {
                    maxNum = maxSumInfo[j];
                }
                maxSumInfo[i] = maxNum + info[i];
            }
        }
        int result = Arrays.stream(maxSumInfo).max().orElse(0);

        System.out.println(result);
    }
}
