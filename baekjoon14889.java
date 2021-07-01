import java.util.Arrays;
import java.util.Scanner;

public class baekjoon14889 {
    static char[][] qAry;
    static int[] resAry;
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        resAry = new int[num];
        qAry = new char[num][num];

        String q = sc.next();
        int count = 0;
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
                qAry[i][j] = q.charAt(count);
                count++;
            }
        }
        permutation(0);

    }

    static Boolean check(int index) {
        int temp = 0;
        for (int i = index; i >= 0; i--) {
            temp += resAry[i];
            if (qAry[i][index] == 0) {
                if (temp != 0) {
                    return false;
                }
            } else if (qAry[i][index] == '+') {
                if (temp <= 0) {
                    return false;
                }
            } else if (qAry[i][index] == '-') {
                if (temp >= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void permutation(int index) {
        if (index == num) {
            // toDo 완결 조건 마무리 하기
            for (int i = 0; i < num; i++) {
                System.out.print(resAry[i] + " ");
            }
            System.out.println();
            System.exit(0);

        }

        // if (qAry[index][index] == 0) {
        // resAry[index] = 0;
        // permutation(index + 1);
        // } else if (qAry[index][index] == '+') {
        // for (int i = 1; i <= 10; i++) {
        // resAry[index] = i;
        // if (check(index)) { permutation(index + 1); }
        // }
        // } else if (qAry[index][index] == '-') {
        // for (int i = -1; i >= -10; i--) {
        // resAry[index] = i;
        // if (check(index)) { permutation(index + 1); }
        // }
        // }
        for (int i = -10; i <= 10; i++) {
            resAry[index] = i;
            if (check(index)) {
                permutation(index + 1);
            }
        }
    }
}
