import java.util.Scanner;

public class baekjoon1912_2 {
    public static void main(String[] args) {
        // 10
        // 10 -4 3 1 5 6 -35 12 21 -1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n];
        int[] resultArray = new int[n];
        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }

        resultArray[0] = info[0];
        int res = resultArray[0];
        for (int i = 1; i < n; i++) {
            resultArray[i] = Math.max(resultArray[i - 1] + info[i], info[i]);
            res = Math.max(res, resultArray[i]);
        }
        System.out.println(res);
    }
}
