import java.util.Scanner;

public class baekjoon14500 {
    private static int row;
    private static int column;
    private static int[][] info;
    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();
        info = new int[row][column];
        max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        type1();
        type1_2();
        type2();
        type3();
        type3_1();
        type3_2();
        type3_3();
        type3_4();
        type3_5();
        type3_6();
        type3_7();
        type4();
        type4_1();
        type4_2();
        type4_3();
        type5();
        type5_1();
        type5_2();
        type5_3();
        System.out.println(max);
    }

    static void type1() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column - 3; j++) {
                int temp = info[i][j] + info[i][j + 1] + info[i][j + 2] + info[i][j + 3];
                max = Math.max(temp, max);
            }
        }
    }

    static void type1_2() {
        for (int i = 0; i < row - 3; i++) {
            for (int j = 0; j < column; j++) {
                int temp = info[i][j] + info[i + 1][j] + info[i + 2][j] + info[i + 3][j];
                max = Math.max(temp, max);
            }
        }
    }

    static void type2() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j] + info[i + 1][j] + info[i][j + 1] + info[i + 1][j + 1];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j] + info[i + 1][j] + info[i + 2][j] + info[i + 2][j + 1];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3_1() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j] + info[i][j + 1] + info[i + 1][j + 1] + info[i + 2][j + 1];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3_2() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i][j] + info[i + 1][j] + info[i + 1][j + 1] + info[i + 1][j + 2];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3_3() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i][j] + info[i][j + 1] + info[i][j + 2] + info[i + 1][j + 2];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3_4() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i + 2][j] + info[i + 2][j + 1] + info[i + 1][j + 1] + info[i][j + 1];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3_5() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j] + info[i][j + 1] + info[i + 1][j] + info[i + 2][j];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3_6() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i + 1][j] + info[i + 1][j + 1] + info[i + 1][j + 2] + info[i][j + 2];
                max = Math.max(temp, max);
            }
        }
    }

    static void type3_7() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i][j] + info[i][j + 1] + info[i][j + 2] + info[i + 1][j];
                max = Math.max(temp, max);
            }
        }
    }

    static void type4() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j] + info[i + 1][j] + info[i + 1][j + 1] + info[i + 2][j + 1];
                max = Math.max(temp, max);
            }
        }
    }

    static void type4_1() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j + 1] + info[i + 1][j + 1] + info[i + 1][j] + info[i + 2][j];
                max = Math.max(temp, max);
            }
        }
    }

    static void type4_2() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i + 1][j] + info[i + 1][j + 1] + info[i][j + 1] + info[i][j + 2];
                max = Math.max(temp, max);
            }
        }
    }

    static void type4_3() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i][j] + info[i][j + 1] + info[i + 1][j + 1] + info[i + 1][j + 2];
                max = Math.max(temp, max);
            }
        }
    }

    static void type5() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j + 1] + info[i + 1][j + 1] + info[i + 1][j] + info[i + 2][j + 1];
                max = Math.max(temp, max);
            }
        }
    }

    static void type5_1() {
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 1; j++) {
                int temp = info[i][j] + info[i + 1][j + 1] + info[i + 1][j] + info[i + 2][j];
                max = Math.max(temp, max);
            }
        }
    }

    static void type5_2() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i + 1][j] + info[i + 1][j + 1] + info[i][j + 1] + info[i + 1][j + 2];
                max = Math.max(temp, max);
            }
        }
    }

    static void type5_3() {
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                int temp = info[i][j] + info[i + 1][j + 1] + info[i][j + 1] + info[i][j + 2];
                max = Math.max(temp, max);
            }
        }
    }
}
