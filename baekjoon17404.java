import java.util.Scanner;

public class baekjoon17404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[][] = new int[num][3];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                ary[i][j] = sc.nextInt();
            }
        }
    }
}
