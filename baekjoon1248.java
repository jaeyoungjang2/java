import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1248 {
    private static int n;
    private static String s;
    private static int[] tempRes;
    private static String[] info;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        tempRes = new int[n];

        info = new String[n];
        int tempN = n;
        int total = n;
        int tempIndex = 1;

        info[0] = s.substring(0, 1);
        while (total < s.length()) {
            info[tempIndex] = s.substring(total, total + 1);
            tempIndex++;
            tempN--;
            total += tempN;
        }
        permutation1248(0);
    }

    private static void permutation1248(int index) {
        if (index == n) {
            System.out.println(Arrays.toString(tempRes));
            check1248();
            return;
        }

        if (info[index].equals("0")) {
            tempRes[index] = 0;
        }
        for (int i = 0; i < 10; i++) {
            if (info[index].equals("-")) {
                tempRes[index] = -i;
                permutation1248(index + 1);
            } else if (info[index].equals("+")) {
                tempRes[index] = i;
                permutation1248(index + 1);
            }
        }
    }

    private static void check1248() {
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (!check1248_2(i, j).equals(s.charAt(index))) {
                    return;
                }
                index++;
            }
        }
        for (Integer integer : tempRes) {
            System.out.print(integer + " ");
        }
        System.exit(0);
    }

    private static Character check1248_2(int start, int end) {

        int temp = 0;
        for (int i = start; i <= end; i++) {
            temp += tempRes[i];
        }
        if (temp > 0) {
            return '+';
        } else if (temp < 0) {
            return '-';
        } else {
            return '0';
        }
    }
}
