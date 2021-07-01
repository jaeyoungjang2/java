import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon14889 {
    static ArrayList<Integer> ary = new ArrayList<>();
    static int[] posAry = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    static int[] negAry = { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 };

    static int[] finalRes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String test = sc.next();

        int count = 0;
        char[][] info = new char[num][num];
        int[] resAry = new int[num];
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
                info[i][j] = test.charAt(count);
                count++;
            }
        }

        permutation(0, info, resAry, num);
        System.out.println(Arrays.toString(finalRes));

    }

    static boolean check(int num, int[] resAry, char[][] info) {
        for (int i = 0; i < num; i++) {
            int temp = 0;
            for (int j = i; j < num; j++) {
                temp += resAry[j];
                if (info[i][j] == '+' && temp <= 0) {
                    return false;
                } else if (info[i][j] == '-' && temp >= 0) {
                    return false;
                } else if (info[i][j] == '0' && (temp > 0 || temp < 0)) {
                    return false;
                }

            }
        }
        return true;
    }

    static void permutation(int index, char[][] info, int[] resAry, int end) {
        if (index == end) {
            if (check(end, resAry, info)) {
                for (int i = 0; i < resAry.length; i++) {
                    System.out.print(resAry[i] + " ");
                }
                System.out.println();
                System.exit(0);
            }
        }

        if (info[index][index] == '+') {

            for (int i = 0; i < posAry.length; i++) {
                resAry[index] = posAry[i];
                permutation(index + 1, info, resAry, end);
            }
        } else if (info[index][index] == '-') {
            for (int i = 0; i < negAry.length; i++) {
                resAry[index] = negAry[i];
                permutation(index + 1, info, resAry, end);
            }
        } else {
            resAry[index] = 0;
            permutation(index + 1, info, resAry, end);
        }

    }

}
