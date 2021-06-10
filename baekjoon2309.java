import java.util.Scanner;

public class baekjoon2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nine[] = new int[9];
        int seven[] = new int[7];
        for (int i = 0; i < 9; i++) {
            nine[i] = sc.nextInt();
        }

        permutation(nine, seven, 0);

    }

    static void permutation(int[] nine, int[] seven, int num) {
        System.out.println("HI");
    }
}
