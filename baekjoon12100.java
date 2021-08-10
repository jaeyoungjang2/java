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
        if (count == 5) {
            findMaxCount(info);
            return;
        }
        int copy[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            copy[i] = info[i].clone();
        }
        // System.out.println("count:" + count);
        moveUp(info);
        run(count + 1);
        for (int i = 0; i < n; i++) {
            info[i] = copy[i].clone();
        }
        // System.out.println("count:" + count);
        moveDown(info);
        run(count + 1);
        for (int i = 0; i < n; i++) {
            info[i] = copy[i].clone();
        }
        moveLeft(info);
        run(count + 1);
        for (int i = 0; i < n; i++) {
            info[i] = copy[i].clone();
        }
        moveRight(info);
        run(count + 1);
        for (int i = 0; i < n; i++) {
            info[i] = copy[i].clone();
        }
    }

    static void findMaxCount(int[][] infoArray) {

        for (int i = 0; i < infoArray.length; i++) {
            for (int num : infoArray[i]) {
                if (num > maxNum) {
                    maxNum = num;
                }
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
    }

    static void moveUp(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if (infoArray[j][i] != 0) {
                    if (block == infoArray[j][i]) {
                        infoArray[index - 1][i] = block * 2;
                        block = 0;
                        infoArray[j][i] = 0;
                    } else {
                        block = infoArray[j][i];
                        infoArray[j][i] = 0;
                        infoArray[index][i] = block;
                        index++;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
        // System.out.println("UP");
        // System.out.println();
    }

    static void moveDown(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = n - 1;
            int block = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (infoArray[j][i] != 0) {
                    if (block == infoArray[j][i]) {
                        infoArray[index + 1][i] = block * 2;
                        block = 0;
                        infoArray[j][i] = 0;
                    } else {
                        block = infoArray[j][i];
                        infoArray[j][i] = 0;
                        infoArray[index][i] = block;
                        index--;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // System.out.println(Arrays.toString(infoArray[3]));
        // System.out.println("DOWN");

        // System.out.println();
    }

    static void moveLeft(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if (infoArray[i][j] != 0) {
                    if (block == infoArray[i][j]) {
                        infoArray[i][index - 1] = block * 2;
                        block = 0;
                        infoArray[i][j] = 0;
                    } else {
                        block = infoArray[i][j];
                        infoArray[i][j] = 0;
                        infoArray[i][index] = block;
                        index++;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // // System.out.println(Arrays.toString(infoArray[3]));
        // System.out.println();
    }

    static void moveRight(int[][] infoArray) {

        for (int i = 0; i < n; i++) {
            int index = n - 1;
            int block = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (infoArray[i][j] != 0) {
                    if (block == infoArray[i][j]) {
                        infoArray[i][index + 1] = block * 2;
                        block = 0;
                        infoArray[i][j] = 0;
                    } else {
                        block = infoArray[i][j];
                        infoArray[i][j] = 0;
                        infoArray[i][index] = block;
                        index--;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(infoArray[0]));
        // System.out.println(Arrays.toString(infoArray[1]));
        // System.out.println(Arrays.toString(infoArray[2]));
        // // System.out.println(Arrays.toString(infoArray[3]));
        // System.out.println();
    }

}
