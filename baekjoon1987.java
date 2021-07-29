import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1987 {
    static int h;
    static int w;
    static char[][] info;
    static HashMap<Character, Boolean> visit = new HashMap<Character, Boolean>();
    static int[] aryY = { 0, 0, -1, 1 };
    static int[] aryX = { -1, 1, 0, 0 };
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        info = new char[h][w];

        for (int i = 0; i < h; i++) {
            String temp = sc.next();
            for (int j = 0; j < w; j++) {
                info[i][j] = temp.charAt(j);
                visit.put(temp.charAt(j), false);
            }
        }
        visit.put(info[0][0], true);
        dfs(0, 0, 1);
        System.out.println(res);
    }

    static void dfs(int y, int x, int count) {

        if (count > res) {
            res = count;
        }
        for (int i = 0; i < 4; i++) {
            int newY = y + aryY[i];
            int newX = x + aryX[i];

            if (newX >= 0 && newY >= 0 && newY < h && newX < w) {
                if (!visit.get(info[newY][newX])) {
                    visit.put(info[newY][newX], true);
                    dfs(newY, newX, count + 1);
                    visit.put(info[newY][newX], false);
                }
            }
        }
    }
}
