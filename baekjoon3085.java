import java.util.Arrays;
import java.util.Scanner;

public class baekjoon3085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        char[][] ary = new char[num][num];
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                ary[i][j] = str.charAt(j);
            }
        }
        int res = 0;
        // 인접한 가로 두개의 값이 하나씩 자리를 옮기고
        // 가로와 세로의 최대 개수를 구함
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - 1; j++) {
                // 인접한 두개의 수가 서로 자리를 옮기고, 가로 세로 최대값을 저장
                int tempAry[] = new int[3];

                // 문자열 임시 저장
                char temp = ary[i][j];
                ary[i][j] = ary[i][j + 1];
                ary[i][j + 1] = temp;

                tempAry[0] = calMaxNum(ary[i]);
                char[][] revAry = makeRevAry(ary);
                tempAry[1] = calMaxNum(revAry[j]);
                tempAry[2] = calMaxNum(revAry[j + 1]);
                for (int k = 0; k < 3; k++) {
                    if (tempAry[k] > res) {
                        res = tempAry[k];
                    }
                }

                ary[i][j + 1] = ary[i][j];
                ary[i][j] = temp;
            }
        }

        // 인접한 세로 두개의 값이 하나씩 자리를 바꾸고
        // 가로와 세로의 최대 개수를 구함
        char[][] revAry = makeRevAry(ary);

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - 1; j++) {
                // 인접한 두개의 수가 서로 자리를 옮기고, 가로 세로 최대값을 저장
                int tempAry[] = new int[3];

                // 문자열 임시 저장
                char temp = revAry[i][j];
                revAry[i][j] = revAry[i][j + 1];
                revAry[i][j + 1] = temp;

                tempAry[0] = calMaxNum(revAry[i]);
                char[][] forAry = makeRevAry(revAry);
                tempAry[1] = calMaxNum(forAry[j]);
                tempAry[2] = calMaxNum(forAry[j + 1]);

                for (int k = 0; k < 3; k++) {
                    if (tempAry[k] > res) {
                        res = tempAry[k];
                    }
                }

                revAry[i][j + 1] = revAry[i][j];
                revAry[i][j] = temp;
            }
        }
        System.out.println(res);
    }

    static char[][] makeRevAry(char[][] ary) {
        int num = ary.length;
        char[][] revAry = new char[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                revAry[i][j] = ary[j][i];
            }
        }
        return revAry;
    }

    static int calMaxNum(char ary[]) {
        int maxNum = 0;
        int num = 0;
        char temp = 'A';
        for (int i = 0; i < ary.length; i++) {
            if (temp == ary[i]) {
                num++;
            } else {
                temp = ary[i];
                num = 1;
            }
            if (maxNum < num) {
                maxNum = num;
            }
        }
        return maxNum;
    }
}
