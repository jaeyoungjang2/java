import java.util.Scanner;

public class backjoon1463 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        dp = new int[x + 2];
        int res = DP(x);
        System.out.println(res);
    }

    static int DP(int target) {
        if (target == 1) {
            return 0;
        }
        if (dp[target] > 0) {
            return dp[target];
        }
        dp[target] = DP(target - 1) + 1;
        if (target % 3 == 0) {
            dp[target] = Math.min(DP(target / 3) + 1, dp[target]);
        }
        if (target % 2 == 0) {
            dp[target] = Math.min(DP(target / 2) + 1, dp[target]);
        }
        return dp[target];
    }
}
