import java.util.Scanner;

public class baekjoon13460 {
    static int n;
    static int m;
    static char[][] info;

    static boolean[][] visitBlue;
    static boolean[][] visitRed;
    static int[] aryH = new int[] {-1, 1, 0, 0};
    static int[] aryW = new int[] {0, 0, -1, 1};

    static int[] targetPosition = new int[2];

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
        visitBlue = new boolean[n][m];
        visitRed = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < m; j++) {
                info[i][j] = temp.charAt(j);
                if (temp.charAt(j) == 'B') {
                    bluePosition = new int[] { i, j };
                    visitBlue[i][j] = true;
                }
                if (temp.charAt(j) == 'R') {
                    redPosition = new int[] { i, j };
                    visitRed[i][j] = true;
                }
                if (temp.charAt(j) == 'o') {
                    targetPosition = new int[] { i, j };
                }
            }
        }
        System.out.println(bluePosition[0]);
        System.out.println(bluePosition[1]);
        // dfs(bluePosition, redPosition);

    }

    static void dfs(int[] bluePosition, int[] redPosition) {
        if (redPosition[0] == targetPosition[0] && redPosition[1] == targetPosition[1]) {
            System.out.println("HI");
            return;
        }
        
    }
}
