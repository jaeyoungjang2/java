import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class baekjoon11722_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n];
        int[] decreaseInfo = new int[n];

        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }

        decreaseInfo[0] = 1;
        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (info[i] < info[j] && index < decreaseInfo[j]) {
                    index = decreaseInfo[j];
                }
                decreaseInfo[i] = index + 1;
            }
        }

        int res = Arrays.stream(decreaseInfo).max().orElse(0);
        System.out.println(res);
    }
}
