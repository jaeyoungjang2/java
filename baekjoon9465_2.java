import java.util.Scanner;

public class baekjoon9465_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int column = sc.nextInt();
            int[][] info = new int[column][2];

            for (int j = 0; j < 2; j++) {
                for (int j2 = 0; j2 < column; j2++) {
                    info[j2][j] = sc.nextInt();
                }
            }

            if (column >= 2) {
                info[1][1] = info[0][0] + info[1][1];
                info[1][0] = info[0][1] + info[1][0];
            }

            for (int j = 2; j < column; j++) {
                info[j][0] = Math.max(info[j - 1][1], info[j - 2][1]) + info[j][0];
                info[j][1] = Math.max(info[j - 1][0], info[j - 2][0]) + info[j][1];
            }
            System.out.println(Math.max(info[column - 1][0], info[column - 1][1]));
        }

    }
}
