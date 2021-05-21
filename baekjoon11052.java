import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] numbers = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < i; j++) {
                numbers[i] = Math.max(numbers[i], numbers[i - j] + numbers[j]);
            }
        }
        System.out.println(numbers[num]);
        // for (int i : numbers) {
        // System.out.println(i);
        // }

    }
}