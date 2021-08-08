import java.util.Arrays;
import java.util.Scanner;

public class baekjoon12100 {
    static int maxNum = 0;
    static int n;
    static int[][] info;

    public static void main(String[] args) {
        // 3
        // 2 2 2
        // 4 4 4
        // 8 8 8
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        info = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        run(0);
        System.out.println(maxNum);

        // 한번 합치는 순간 게임이 끝난다.
        // 0이 아닌 모든 좌판에서 케이스를 검사해본다.
        // 상, 하, 좌, 우로 모든 좌판이 이동
    }

    static void run(int count) {
        if (count == 1) {
            findMaxCount(info);
            return;
        }
        int copy[][] = new int[n][n];

        copy = info.clone();
        moveUp(info);
        run(count + 1);
        info = copy.clone();
        // moveDown(info);
        // run(count + 1);
        // info = copy.clone();
        // moveLeft(info);
        // run(count + 1);
        // info = copy.clone();
        // moveRight(info);
        // run(count + 1);
        // info = copy.clone();
    }

    static void findMaxCount(int[][] infoArray) {

        for (int i = 0; i < infoArray.length; i++) {
            for (int num : infoArray[i]) {
                if (num > maxNum) {
                    maxNum = num;
                }
            }
        }
    }

    static void moveUp(int[][] infoArray) {
        System.out.println(Arrays.toString(infoArray[0]));
        System.out.println(Arrays.toString(infoArray[1]));
        System.out.println(Arrays.toString(infoArray[2]));
        System.out.println(Arrays.toString(infoArray[3]));
        System.out.println();
        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 1; j < n; j++) {
                if (infoArray[j][i] == 0) {
                    continue;
                }

                // 현재 숫자가 0이 아닌 경우
                // index의 숫자와 같은 경우 ( 합치고 , idnex 번호 수정하고, 기존 자리 값 0으로 변환)
                if (infoArray[j][i] == infoArray[index][i]) {
                    infoArray[index][i] = infoArray[j][i] + infoArray[index][i];
                    infoArray[j][i] = 0;
                    index++;
                    continue;
                }
                // index의 숫자와 다른 경우
                if (infoArray[index][i] == 0) {
                    infoArray[index][i] = infoArray[j][i];
                    infoArray[j][i] = 0;
                    continue;
                }
                index++;
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
    }

    static void moveDown(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = n - 1;
            for (int j = n - 2; j >= 0; j--) {
                if (infoArray[j][i] == 0) {
                    continue;
                }

                // 현재 숫자가 0이 아닌 경우
                // index의 숫자와 같은 경우 ( 합치고 , idnex 번호 수정하고, 기존 자리 값 0으로 변환)
                if (infoArray[j][i] == infoArray[index][i]) {
                    infoArray[index][i] = infoArray[j][i] + infoArray[index][i];
                    infoArray[j][i] = 0;
                    index--;
                    continue;
                }
                // index의 숫자와 다른 경우
                if (infoArray[index][i] == 0) {
                    infoArray[index][i] = infoArray[j][i];
                    infoArray[j][i] = 0;
                    continue;
                }
                index--;
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
    }

    static void moveLeft(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 1; j < n; j++) {
                if (infoArray[i][j] == 0) {
                    continue;
                }

                // 현재 숫자가 0이 아닌 경우
                // index의 숫자와 같은 경우 ( 합치고 , idnex 번호 수정하고, 기존 자리 값 0으로 변환)
                if (infoArray[i][j] == infoArray[i][index]) {
                    infoArray[i][index] = infoArray[i][j] + infoArray[i][index];
                    infoArray[i][j] = 0;
                    index++;
                    continue;
                }
                // index의 숫자와 다른 경우
                if (infoArray[i][index] == 0) {
                    infoArray[i][index] = infoArray[i][j];
                    infoArray[i][j] = 0;
                    continue;
                }
                index++;
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
    }

    static void moveRight(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = n - 1;
            for (int j = n - 2; j >= 0; j--) {
                if (infoArray[i][j] == 0) {
                    continue;
                }

                // 현재 숫자가 0이 아닌 경우
                // index의 숫자와 같은 경우 ( 합치고 , idnex 번호 수정하고, 기존 자리 값 0으로 변환)
                if (infoArray[i][j] == infoArray[i][index]) {
                    infoArray[i][index] = infoArray[i][j] + infoArray[i][index];
                    infoArray[i][j] = 0;
                    index--;
                    continue;
                }
                // index의 숫자와 다른 경우
                if (infoArray[i][index] == 0) {
                    infoArray[i][index] = infoArray[i][j];
                    infoArray[i][j] = 0;
                    continue;
                }
                index--;
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
    }

}
