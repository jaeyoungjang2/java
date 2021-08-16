import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1463_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Number number = new Number(n, 0);

        Queue<Number> q = new LinkedList<>();
        q.add(number);

        while (!q.isEmpty()) {
            Number temp = q.remove();
            int num = temp.num;
            int count = temp.count;
            if (num == 1) {
                System.out.println(count);
                break;
            }

            if (num % 3 == 0) {
                q.add(new Number(num / 3, count + 1));
            }
            if (num % 2 == 0) {
                q.add(new Number(num / 2, count + 1));
            }
            q.add(new Number(num - 1, count + 1));
        }
    }
}

class Number {
    int num;
    int count;

    Number(int num, int count) {
        this.num = num;
        this.count = count;
    }
}