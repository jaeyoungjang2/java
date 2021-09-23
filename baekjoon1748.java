import java.util.Scanner;

public class baekjoon1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = length(n);
        int res = (int) (n - Math.pow(10, length - 1) + 1) * length;
        length--;
        for (int i = length; i >= 0; i--) {
            res += 9 * Math.pow(10, i - 1) * i;
        }
        System.out.println(res);
    }

    static int length(int n) {
        int len = 0;
        while (n != 0) {
            n /= 10;
            len++;
        }
        return len;
    }
}
