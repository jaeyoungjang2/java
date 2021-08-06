import java.util.Scanner;

public class baekjoon13460 {
    static int n;
    static int m;
    static char[][] info;

    static boolean[][] visitBlue;
    static boolean[][] visitRed;
    static int[] aryH = new int[] { -1, 1, 0, 0 };
    static int[] aryW = new int[] { 0, 0, -1, 1 };
    static int res = -1;

    public static void main(String[] args) {
        int[] bluePosition = new int[2];
        int[] redPosition = new int[2];
        // 5 5
        // #####
        // #..B#
        // #.#.#
        // #RO.#
        // #####
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        info = new char[n][m];
        int h1 = 0;
        int h2 = 0;
        int w1 = 0;
        int w2 = 0;
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < m; j++) {
                info[i][j] = temp.charAt(j);
                if (temp.charAt(j) == 'B') {
                    h2 = i;
                    w2 = j;
                }
                if (temp.charAt(j) == 'R') {
                    h1 = i;
                    w1 = j;
                }
            }
        }
        Position position = new Position(h1, w1, h2, w2);
        dfs(position, 1);
        System.out.println(res);

    }

    static void dfs(Position position, int count) {
        if (count == 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int redH = position.h1 + aryH[i];
            int redW = position.w1 + aryW[i];
            int blueH = position.h2 + aryH[i];
            int blueW = position.w2 + aryW[i];

            int goodPosition = 0;
            boolean isBreak = false;
            if (redH >= 0 && redW >= 0 && redH < n && redW < m) {
                goodPosition++;
                if (info[redH][redW] == '.') {
                    while (redH >= 0 && redW >= 0 && redH < n && redW < m && info[redH][redW] != '#') {
                        redH += aryH[i];
                        redW += aryW[i];

                        if (info[redH][redW] == 'O') {
                            // System.out.println("HI");
                            isBreak = true;
                        }
                    }
                    redH -= aryH[i];
                    redW -= aryW[i];
                }

                if (info[redH][redW] == '#') {
                    redH = position.h1;
                    redW = position.w1;
                }
            }

            if (blueH >= 0 && blueW >= 0 && blueH < n && blueW < m) {
                goodPosition++;
                if (info[blueH][blueW] == '.') {
                    while (blueH >= 0 && blueW >= 0 && blueH < n && blueW < m && info[blueH][blueW] == '.') {
                        blueH += aryH[i];
                        blueW += aryW[i];
                        if (info[blueH][blueW] == 'O') {
                            isBreak = false;
                        }
                    }
                    blueH -= aryH[i];
                    blueW -= aryW[i];
                }

                if (info[blueH][blueW] == '#') {
                    blueH = position.h2;
                    blueW = position.w2;
                }
            }

            if (isBreak) {
                System.out.println("count: " + count);
                System.out.println(aryH[i]);
                System.out.println(aryW[i]);
                System.out.println("redH: " + redH);
                System.out.println("redW: " + redW);
                System.out.println("blueH: " + blueH);
                System.out.println("blueW: " + blueW);
                System.out.println(isBreak);
                System.out.println();
                if (res == -1) {
                    res = count;
                } else {
                    res = Math.min(res, count);
                }
            }

            if (goodPosition == 2) {
                dfs(new Position(redH, redW, blueH, blueW), count + 1);
            }
        }

    }
}

class Position {
    int h1;
    int w1;
    int h2;
    int w2;

    Position(int h1, int w1, int h2, int w2) {
        this.h1 = h1;
        this.w1 = w1;
        this.h2 = h2;
        this.w2 = w2;
    }
}