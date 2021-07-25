import java.util.Arrays;
import java.util.Scanner;

public class baekjoon16198 {
    static int n;
    static boolean[] visit;
    static int[] info;
    static int[] dfsAry;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visit = new boolean[n];
        info = new int[n];
        dfsAry = new int[n - 2];
        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }

        dfs(0);
        System.out.println(res);
    }

    static void dfs(int index) {
        if (index == n - 2) {
            findMaxWeight(dfsAry);
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfsAry[index] = i;
                dfs(index + 1);
                visit[i] = false;
            }
        }
    }

    static void findMaxWeight(int[] weightAry) {
        boolean[] check = new boolean[n];
        int tempRes = 0;

        for (int i = 0; i < weightAry.length; i++) {
            int target = weightAry[i];
            int leftTarget = target - 1;
            int rightTarget = target + 1;

            while (check[leftTarget]) {
                leftTarget--;
            }
            while (check[rightTarget]) {
                rightTarget++;
            }

            if (!check[leftTarget] && !check[rightTarget]) {
                check[target] = true;
                tempRes += info[leftTarget] * info[rightTarget];
                if (rightTarget == n - 1) {
                    check[rightTarget] = false;
                }
                if (leftTarget == 0) {
                    check[leftTarget] = false;
                }
            }
        }
        res = Math.max(res, tempRes);
    }
}
