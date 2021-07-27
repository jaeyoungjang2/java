import java.util.Arrays;
import java.util.Scanner;

public class baekjoon9663_2 {
    static int[] info;
    static int n;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        info = new int[n];
        dfs(0);
        System.out.println(res);
    }

    static void dfs(int index) {
        if (index == n) {
            res++;

            return;
        }
        for (int i = 0; i < n; i++) {
            info[index] = i;
            if (possible(index)) {
                dfs(index + 1);
            }
            // 방문할 수 있는 위치인지 확인 (백트래킹)
            // 가능하면 다음 인덱스로 이동

        }

    }

    static boolean possible(int index) {
        // g
        for (int i = 1; i <= index; i++) {
            if (info[index - i] == info[index] + i || info[index - i] == info[index] - i
                    || info[index - i] == info[index]) {
                return false;
            }
        }
        return true;
        // 이전 열에 대해서만 확인
        // 대각선 또는 가로 행에 방문한 적이 있는지 확인.
        // 방문한 적이 없다면 true를 돌려줌
        // 방문한 적이 있으면 false를 돌려줌
    }
}
