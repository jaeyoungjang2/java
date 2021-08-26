import java.util.Scanner;

public class baekjoon15988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[1000001];
        info[1] = 1;
        info[2] = 2;
        info[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            info[i] = ((info[i - 1] + info[i - 2]) % 1000000009 + info[i - 3]) % 1000000009;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(info[sc.nextInt()]);
        }
    }
}
