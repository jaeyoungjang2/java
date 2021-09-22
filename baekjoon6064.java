import java.util.Scanner;

public class baekjoon6064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int count = 1;
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            while (count <= 80_000) {
                int tempX = count % m;
                int tempY = count % n;
                if (tempX == 0) {
                    tempX = m;
                }
                if (tempY == 0) {
                    tempY = n;
                }
                if (tempX == x && tempY == y) {
                    break;
                }
                count++;
            }

            if (count == 80_001) {
                System.out.println(-1);
            } else {
                System.out.println(count);
            }
        }
    }
}
