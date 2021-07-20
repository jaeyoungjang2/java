import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class baekjoon1339 {
    static String[] intAry = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    static boolean[] visit = new boolean[10];
    static HashMap<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        visit[0] = true;
        System.out.println(Arrays.toString(visit));

        // 알파뱃은 최대 10개이고
        // 수의 길이는 8
        int[] info = new int[10];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 임의의 세자리 수와
        // 임의의 다섯자리 수를 생성
        // 알파뱃 포맷과 일치하는지 확인
        // permutation(0, "", 2);
        System.out.println(permutation(0, "", 2));
    }

    static String permutation(int index, String res, int resLength) {
        // 임의의 수를 생성
        if (res.length() == resLength) {
            // System.out.println(res);
            return res;
        }
        for (int i = 0; i < 10; i++) {
            permutation(index + 1, res + intAry[i], resLength);
        }
        return res;

    }
}
