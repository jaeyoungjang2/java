import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon2309_2 {
    private static final int USER_NUMBER = 9;
    private static final int TARGET_USER_NUMBER = 7;
    private static final int[] info = new int[USER_NUMBER];

    public static void main(String[] args) {
        // 20
        // 7
        // 23
        // 19
        // 10
        // 15
        // 25
        // 8
        // 13
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < USER_NUMBER; i++) {
            info[i] = sc.nextInt();
        }
        Stack<Integer> res = new Stack<>();
        permutation(res, 0);

    }

    private static void permutation(Stack<Integer> res, int index) {
        if (res.size() == TARGET_USER_NUMBER && res.stream().reduce(0, (a, b) -> a + b) == 100) {
            res.stream().sorted().forEach(System.out::println);
            System.exit(0);
        }

        if (index == USER_NUMBER) {
            return;
        }

        res.add(info[index]);
        permutation(res, index + 1);
        res.pop();
        permutation(res, index + 1);
    }
}
