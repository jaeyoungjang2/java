import java.util.Arrays;
import java.util.Scanner;

public class baekjoon12100 {
    static int maxNum = 0;
    static int n;

    public static void main(String[] args) {
        // 3
        // 2 2 2
        // 4 4 4
        // 8 8 8
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] info = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        moveUp(info);
        System.out.println(Arrays.asList(info));
        moveUp(info);

        // 한번 합치는 순간 게임이 끝난다.
        // 0이 아닌 모든 좌판에서 케이스를 검사해본다.
        // 상, 하, 좌, 우로 모든 좌판이 이동
    }

    static void moveUp(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = 1;
            int beforeNumber = infoArray[0][i];
            for (int j = 1; j < n; j++) {
                if (infoArray[j][i] == 0) {
                    continue;
                }
                if (infoArray[j][i] != 0) {
                    if (infoArray[j][i] == beforeNumber) {
                        infoArray[index - 1][i] = infoArray[j][i] + beforeNumber;
                        beforeNumber = 0;
                        infoArray[j][i] = 0;
                        continue;
                    }
                    // 이전 숫자와 다를 경우
                    infoArray[index][i] = infoArray[j][i];
                    beforeNumber = infoArray[j][i];
                    infoArray[j][i] = 0;

                    index++;
                }

            }
        }
        System.out.println(Arrays.toString(infoArray[0]));
        System.out.println(Arrays.toString(infoArray[1]));
        System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
    }

    static void moveDown(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = n - 2;
            int beforeNumber = infoArray[n - 1][i];
            for (int j = n - 2; j >= 0; j--) {
                if (infoArray[j][i] == 0) {
                    continue;
                }
                if (infoArray[j][i] != 0) {
                    if (infoArray[j][i] == beforeNumber) {
                        infoArray[index + 1][i] = infoArray[j][i] + beforeNumber;
                        beforeNumber = 0;
                        infoArray[j][i] = 0;
                        continue;
                    }
                    // 이전 숫자와 다를 경우
                    infoArray[index][i] = infoArray[j][i];
                    beforeNumber = infoArray[j][i];
                    infoArray[j][i] = 0;
                    index--;
                }

            }
        }
        System.out.println(Arrays.toString(infoArray[0]));
        System.out.println(Arrays.toString(infoArray[1]));
        System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
    }
}
