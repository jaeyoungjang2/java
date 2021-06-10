import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nine[] = new int[9];
        Stack<Integer> seven = new Stack<>();
        for (int i = 0; i < 9; i++) {
            nine[i] = sc.nextInt();
        }

        permutation(nine, seven, 0);

    }

    static void permutation(int[] nine, Stack seven, int num) {
        int total = 0;
        if (num > 9) {
            break;
        }
        if (num == 9) {
            while (seven.size() > 0) {
                total += seven.pop();
            }
        }
        if (total == 100) {
            Arrays.sort(seven);
            for (int i = 0; i < seven.length; i++) {
                System.out.println(seven[i]);
            }
        }
        if (seven.length >= 7) {
            break;
        }
        permutation(nine, seven, num+1);
        seven[num] = nine[num];
        
        permutation(nine, seven, num);
    }
}
