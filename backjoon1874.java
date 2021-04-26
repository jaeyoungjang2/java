import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class backjoon1874 {
    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        Stack<Integer> temp = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int lastNumber;

        boolean isTrue = true;
        int number = 1;

        for (int i = 0; i < count; i++) {
            int target = Integer.parseInt(sc.nextLine());
            if (target > number) {
                for (int j = number; j < target + 1; j++) {
                    res.add("+");
                    temp.push(j);
                }
                temp.pop();
                res.add("-");
                number = target + 1;

            } else if (target < number) {
                lastNumber = temp.pop();
                if (target == lastNumber) {
                    res.add("-");

                } else {
                    isTrue = false;
                    System.out.println("NO");
                    break;
                }
            }
        }

        if (isTrue) {
            for (String string : res) {
                System.out.println(string);
            }
        }
        sc.close();
    }
}
