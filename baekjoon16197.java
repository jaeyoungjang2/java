import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon16197 {
    static int[] aryH = { 0, 0, -1, 1 };
    static int[] aryW = { -1, 1, 0, 0 };
    static int n;
    static int m;
    static int res = -1;
    static String[][] info;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int h1 = 0;
        int w1 = 0;
        int h2 = 0;
        int w2 = 0;
        boolean firstCoin = true;
        boolean[][][] visit = new boolean[n][m][2];
        info = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] tempAry = sc.next().split("");
            for (int j = 0; j < tempAry.length; j++) {
                info[i][j] = tempAry[j];
                if (tempAry[j].equals("o") && firstCoin) {
                    h1 = i;
                    w1 = j;
                    firstCoin = false;
                } else if (tempAry[j].equals("o") && !firstCoin) {
                    h2 = i;
                    w2 = j;
                }
            }
        }

        coinTracking(new CoinPosition(h1, w1, h2, w2), 1);
        System.out.println(res);

    }

    static void coinTracking(CoinPosition cp, int cnt) {
        int curH1 = cp.h1;
        int curW1 = cp.w1;
        int curH2 = cp.h2;
        int curW2 = cp.w2;
        if (cnt >= 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int canFall = 0;
            int nextH1 = curH1 + aryH[i];
            int nextW1 = curW1 + aryW[i];
            int nextH2 = curH2 + aryH[i];
            int nextW2 = curW2 + aryW[i];

            // 첫번째 코인이 떨어지는 경우
            if (nextH1 < 0 || nextH1 >= n || nextW1 < 0 || nextW1 >= m) {
                canFall++;
            } else if (info[nextH1][nextW1].equals("#")) {
                nextH1 = curH1;
                nextW1 = curW1;
            }
            // 두번째 코인이 떨어지는 경우
            if (nextH2 < 0 || nextH2 >= n || nextW2 < 0 || nextW2 >= m) {
                canFall++;
            } else if (info[nextH2][nextW2].equals("#")) {
                nextH2 = curH2;
                nextW2 = curW2;
            }

            // 하나만 떨어진 경우
            if (canFall == 1) {
                if (res == -1) {
                    res = cnt;
                } else {
                    res = Math.min(res, cnt);
                }
            } else if (canFall == 0) {
                coinTracking(new CoinPosition(nextH1, nextW1, nextH2, nextW2), cnt + 1);
            }
        }

    }
}

class CoinPosition {
    int h1;
    int w1;
    int h2;
    int w2;

    CoinPosition(int h1, int w1, int h2, int w2) {
        this.h1 = h1;
        this.w1 = w1;
        this.h2 = h2;
        this.w2 = w2;
    }
}