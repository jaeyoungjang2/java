import java.util.Arrays;
import java.util.Scanner;

public class baekjoon3085_2 {
    private static String[][] info;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        info = new String[n][n];
        for (int i = 0; i < n; i++) {
            info[i] = sc.nextLine().split("");
        }

        // 가로 2개의 값을 변경
        int max = Math.max(calculateMaxHeight(), calculateMaxRow());
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (!info[i][j - 1].equals(info[i][j])) {
                    String tempString = info[i][j];
                    info[i][j] = info[i][j - 1];
                    info[i][j - 1] = tempString;
                    int tempMax = Math.max(calculateMaxHeight(), calculateMaxRow());
                    if (max < tempMax) {
                        max = tempMax;
                    }
                    info[i][j - 1] = info[i][j];
                    info[i][j] = tempString;
                }
            }
        }

        // 세로 2개의 값을 변경
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (!info[j - 1][i].equals(info[j][i])) {
                    String tempString = info[j][i];
                    info[j][i] = info[j - 1][i];
                    info[j - 1][i] = tempString;
                    int tempMax = Math.max(calculateMaxHeight(), calculateMaxRow());
                    if (max < tempMax) {
                        max = tempMax;
                    }
                    info[j - 1][i] = info[j][i];
                    info[j][i] = tempString;
                }
            }
        }
        System.out.println(max);

    }

    private static int calculateMaxRow() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            String tempString = info[i][0];
            int tempMax = 1;
            for (int j = 1; j < n; j++) {
                if (info[i][j].equals(tempString)) {
                    tempMax++;
                    if (tempMax > max) {
                        max = tempMax;
                    }
                    continue;
                }
                tempString = info[i][j];
                tempMax = 1;
            }
        }
        return max;
    }

    private static int calculateMaxHeight() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            String tempString = info[0][i];
            int tempMax = 1;
            for (int j = 1; j < n; j++) {
                if (info[j][i].equals(tempString)) {
                    tempMax++;
                    if (tempMax > max) {
                        max = tempMax;
                    }
                    continue;
                }
                tempString = info[j][i];
                tempMax = 1;
            }
        }
        return max;
    }
}
