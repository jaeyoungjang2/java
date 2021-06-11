import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nine[] = new int[9];
        int seven[] = new int[7];
        for (int i = 0; i < 9; i++) {
            nine[i] = sc.nextInt();
        }

        permutation(nine, seven, 0);

    }

    static void permutation(int[] nine, int[] seven, int num) {
        int total = 0;
        if (num > 9) {
            return;
        }
        if (num == 9) {
            return;
        }
        System.out.println(Arrays.toString(seven));
        if (total == 100) {
            Arrays.sort(seven);
            for (int i = 0; i < seven.length; i++) {
                System.out.println(seven[i]);
            }
        }
        if (seven.length >= 7) {
            return;
        }
        permutation(nine, seven, num + 1);
        seven[seven.length] = nine[num];

        permutation(nine, seven, num);
    }
}
