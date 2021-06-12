import java.util.Arrays;
import java.util.Scanner;

public class baekjoon2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nine[] = new int[9];
        int seven[] = new int[7];
        for (int i = 0; i < 9; i++) {
            nine[i] = sc.nextInt();
        }

        permutation(nine, seven, 0, 0);

    }

    static void permutation(int[] nine, int[] seven, int nineNum, int sevenNum) {
        int total = 0;

        for (int i = 0; i < seven.length; i++) {
            total += seven[i];
        }
        if (total == 100 && sevenNum == 7) {
            Arrays.sort(seven);

            for (int i = 0; i < seven.length; i++) {
                System.out.println(seven[i]);
            }
        }
        if (nineNum >= 9 || sevenNum >= 7) {
            return;
        }

        permutation(nine, seven, nineNum + 1, sevenNum);
        seven[sevenNum] = nine[nineNum];
        permutation(nine, seven, nineNum + 1, sevenNum + 1);
    }
}
