import java.util.Scanner;

public class baekjoon11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num + 1];
        int d[] = new int[num + 1];

        for (int i = 1; i < num + 1; i++) {
            ary[i] = sc.nextInt();
            for (int j = 1; j < i + 1; j++) {
                if (ary[i] < ary[j] && d[i] <= d[j]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int res = 0;
        for (int i : d) {
            if (res < i) {
                res = i;
            }
        }
        System.out.println(res + 1);

    }
}
