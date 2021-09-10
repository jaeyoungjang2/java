import java.util.Scanner;

public class baekjoon2156_2 {
    static int maxResult = 0;
    static int[] info;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        info = new int[num];

        for (int i = 0; i < num; i++) {
            info[i] = sc.nextInt();
        }

        int[][] drinkInfo = new int[num][3];

        drinkInfo = calculateDrinkAmount(info, drinkInfo);
        for (int i = 0; i < 3; i++) {
            if (drinkInfo[num - 1][i] > maxResult) {
                maxResult = drinkInfo[num - 1][i];
            }
        }
        System.out.println(maxResult);
    }

    static int[][] calculateDrinkAmount(int[] info, int[][] drinkInfo) {
        if (drinkInfo.length == 1) {
            maxResult = info[0];
            return drinkInfo;
        }

        drinkInfo[0][1] = info[0];
        for (int i = 1; i < drinkInfo.length; i++) {
            int beforeDrink = Math.max(drinkInfo[i - 1][2], drinkInfo[i - 1][1]);
            drinkInfo[i][0] = Math.max(beforeDrink, drinkInfo[i - 1][0]);
            drinkInfo[i][1] = drinkInfo[i - 1][0] + info[i];
            drinkInfo[i][2] = drinkInfo[i - 1][1] + info[i];
        }
        return drinkInfo;
    }

}
