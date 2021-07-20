import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon2529_2 {
    static String[] infoAry = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    // static String[] infoAry = { "0", "1", "2" };

    static boolean[] visit = new boolean[10];
    static String[] info;
    static int n;
    static ArrayList<String> ary = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        info = new String[n];

        for (int i = 0; i < n; i++) {
            info[i] = sc.next();
        }

        // 부등호를 만족하는 최소 값과 최대 값을 출력하라
        // 첫 자리가 0인 경우도 정수에 포함
        permutation(0, "");
        // System.out.println(ary);
        System.out.println(ary.get(ary.size() - 1));
        System.out.println(ary.get(0));

    }

    static void permutation(int index, String res) {
        // System.out.println(res);
        if (index == n + 1) {
            // System.out.println("res");
            if (check(res)) {
                ary.add(res);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(index + 1, res + infoAry[i]);
                visit[i] = false;
            }
        }
    }

    static boolean check(String temp) {
        for (int i = 0; i < n; i++) {
            int a = temp.charAt(i) - '0';
            int b = temp.charAt(i + 1) - '0';
            if (info[i].equals(">") && a < b) {
                return false;
            }
            if (info[i].equals("<") && a > b) {
                return false;
            }
        }
        return true;
    }
}
