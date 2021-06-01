import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ary = new int[num];
        int currTotal = sc.nextInt();
        ary[0] = currTotal;

        for (int i = 0; i < num - 1; i++) {
            int currNum = sc.nextInt();
            currTotal += currNum;
            if (currNum > currTotal) {
                currTotal = currNum;
            }
            ary[i + 1] = currTotal;
        }

        int maxNum = ary[0];
        for (int i : ary) {
            if (maxNum < i) {
                maxNum = i;
            }
        }
        System.out.println(maxNum);
    }

}
