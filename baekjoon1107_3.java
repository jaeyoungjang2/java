import java.util.Scanner;

public class baekjoon1107_3 {
    private static int[] brokenButtoninfo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetChannel = sc.nextInt();
        int n = sc.nextInt();
        brokenButtoninfo = new int[10];
        ;
        for (int i = 0; i < n; i++) {
            brokenButtoninfo[sc.nextInt()] = 1;
        }

        int distance = Math.abs(100 - targetChannel);

        for (int i = 0; i < 1_000_000; i++) {
            int length = getLength(i);
            if (length > 0) {
                distance = Math.min(Math.abs(i - targetChannel) + length, distance);
            }
        }
        System.out.println(distance);
    }

    static int getLength(int num) {
        int length = 0;

        if (num == 0) {
            return brokenButtoninfo[0] == 1 ? 0 : 1;
        }

        while (num > 0) {
            if (brokenButtoninfo[num % 10] == 1) {
                return 0;
            }
            length++;
            num /= 10;
        }

        return length;
    }
}
