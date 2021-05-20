import java.util.Scanner;

public class baekjoon11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] ary = new int[1001];
        ary[1] = 1;
        ary[2] = 2;
        if (number < 3) {
            System.out.println(ary[number]);
        } else {
            for (int i = 3; i <= number; i++) {
                ary[i] = ary[i - 1] % 10007 + ary[i - 2] % 10007;
            }
            System.out.println(ary[number] % 10007);
        }

    }
}