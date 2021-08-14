import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon1874 {
    public static void main(String[] args) {
        // 새로운 숫자가 현재 숫자보다 클 때
        // push를 이용해서 새로운 숫자 까지 넣고, 현재 숫자 = 새로운 숫자
        // 새로운 숫자 pop 하고, 현재 숫자--;

        // 새로운 숫자가 현재 숫자와 동일할 때
        // 현재 숫자 pop, 현재 숫자--;

        // 새로운 숫자가 현재 숫자보다 작을 때
        // pop을 해서 새로운 숫자가 나오면, 현재 숫자--;
        // pop을 해서 새로운 숫자가 안나오면 "NO" 출력 시스템 종료
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        ArrayList<String> resultList = new ArrayList<>();
        stack.push(0);
        boolean[] visit = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp > stack.peek()) {
                for (int j = stack.peek() + 1; j <= temp; j++) {
                    if (!visit[j]) {
                        visit[j] = true;
                        stack.push(j);
                        resultList.add("+");
                    }
                }
                stack.pop();
                resultList.add("-");
            } else if (temp == stack.peek()) {
                stack.pop();
                resultList.add("-");

            } else if (temp < stack.peek()) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        for (String s : resultList) {
            System.out.println(s);
        }
    }
}
