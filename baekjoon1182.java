import java.util.Scanner;

public class baekjoon1182 {
    static int s;
    static int k;
    static int[] info;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        k = sc.nextInt();
        info = new int[s];
        for (int i = 0; i < s; i++) {
            info[i] = sc.nextInt();
        }
        permutation(0, 0, 0);
        System.out.println(cnt);
    }

    static void permutation(int point, int index, int res) {
        if (index != 0 && res == k) {
            cnt++;
        }
        if (index == s) {
            return;
        }
        for (int i = point; i < s; i++) {
            permutation(i + 1, index + 1, res + info[i]);
        }
    }
}