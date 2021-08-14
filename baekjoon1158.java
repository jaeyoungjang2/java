import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // sb.subSequence(start, end)
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int currentIndex = 1;

        sb.append("<");
        while (!q.isEmpty()) {
            if (currentIndex == k) {
                sb.append(q.remove() + ", ");
                currentIndex = 1;
                continue;
            }
            q.add(q.remove());
            currentIndex++;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
