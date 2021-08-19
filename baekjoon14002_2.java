import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon14002_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[n];
        int[] index = new int[n];
        int[] target = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
            target[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (info[i] > info[j] && index[i] <= index[j]) {
                    index[i] = index[j] + 1;
                    target[i] = j;
                }
            }
        }
        int maxTargetIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (index[i] > maxIndex) {
                maxIndex = index[i];
                maxTargetIndex = i;
            }
        }

        while (maxTargetIndex != -1) {
            stack.push(info[maxTargetIndex]);
            maxTargetIndex = target[maxTargetIndex];
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
