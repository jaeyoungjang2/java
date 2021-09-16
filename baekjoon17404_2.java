import java.util.Arrays;
import java.util.Scanner;

public class baekjoon17404_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(info[0]));
        System.out.println(Arrays.toString(info[1]));
        System.out.println(Arrays.toString(info[2]));
    }
}
