import java.util.Scanner;

public class baekjoon9095_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[12];
        info[1] = 1;
        info[2] = 2;
        info[3] = 4;
        for (int i = 4; i <= 11; i++) {
            info[i] = info[i - 1] + info[i - 2] + info[i - 3];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(info[sc.nextInt()]);
        }
    }
}
