import java.util.Scanner;

public class baekjoon14501_2 {
    static int n;
    static int[] timeAry;
    static int[] payAry;
    static int res = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        timeAry = new int[n];
        payAry = new int[n];

        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int pay = sc.nextInt();
            timeAry[i] = time;
            payAry[i] = pay;
        }

        dfs(0, 0);
        System.out.println(res);
    }

    static void dfs(int index, int totalPay) {
        if (index == n) {
            if (totalPay > res) {
                res = totalPay;
            }
            return;
        }
        if (index > n) {
            return;
        }
        int currTime = timeAry[index];
        int currPay = payAry[index];
        dfs(index + currTime, totalPay + currPay);
        dfs(index + 1, totalPay);
    }
}
