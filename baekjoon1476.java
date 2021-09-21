import java.util.Scanner;

public class baekjoon1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        int index = 0;
        int total = 0;

        while (true) {
            total = 15 * index + e;
            if ((total % 28 - m == 0 || total % 28 - m == -28) && (total % 19 - s == 0 || total % 19 - s == -19)) {
                break;
            }
            index++;

        }
        System.out.println(total);
    }
}
