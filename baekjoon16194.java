import java.util.Scanner;

public class baekjoon11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ary = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ary[i] = sc.nextInt();
        }

        for (int i = 2; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                ary[i] = Math.min(ary[i], ary[j] + ary[i - j]);
            }
        }
        System.out.println(ary[num]);
        sc.close();

    }
}