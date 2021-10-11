import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14391 {
    private static int row;
    private static int col;
    private static Character[][] info;
    private static int[][] bit;
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        info = new Character[row][col];
        bit = new int[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                info[i][j] = temp.charAt(j);
            }
        }
        permutation(0);
        System.out.println(result);
    }

    private static void permutation(int index) {
        if (index == row * col) {

            // 0은 가로 1은 세로
            int currentTotal = 0;
            for (int i = 0; i < row; i++) {
                int tempRowTotal = 0;
                for (int j = 0; j < col; j++) {
                    if (bit[i][j] == 0) {
                        tempRowTotal *= 10;
                        tempRowTotal += Character.getNumericValue(info[i][j]);
                    } else if (bit[i][j] == 1) {
                        currentTotal += tempRowTotal;
                        tempRowTotal = 0;
                    }
                }
                currentTotal += tempRowTotal;
                tempRowTotal = 0;
            }

            for (int i = 0; i < col; i++) {
                int tempColTotal = 0;
                for (int j = 0; j < row; j++) {
                    if (bit[j][i] == 0) {
                        currentTotal += tempColTotal;
                        tempColTotal = 0;
                    } else if (bit[j][i] == 1) {
                        tempColTotal *= 10;
                        tempColTotal += Character.getNumericValue(info[j][i]);
                    }
                }
                currentTotal += tempColTotal;
                tempColTotal = 0;
            }
            if (currentTotal > result) {
                result = currentTotal;
            }
            return;
        }
        int tempRow = index / col;
        int tempCol = index % col;

        bit[tempRow][tempCol] = 0;
        permutation(index + 1);
        bit[tempRow][tempCol] = 1;
        permutation(index + 1);
    }
}
