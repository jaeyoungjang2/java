import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class baekjoon10819 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list = list.stream().sorted().collect(Collectors.toList());

        int firstIndex = 0;
        int lastIndex = n - 1;

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(list.get(lastIndex));
        lastIndex--;
        dq.addLast(list.get(firstIndex));
        firstIndex++;

        while (firstIndex <= lastIndex) {
            if (Math.abs(dq.getFirst() - list.get(firstIndex)) >= Math.abs(dq.getLast() - list.get(firstIndex))) {
                dq.addFirst(list.get(firstIndex));
            } else {
                dq.addLast(list.get(firstIndex));
            }
            firstIndex++;
            if (firstIndex > lastIndex) {
                break;
            }
            if (Math.abs(dq.getFirst() - list.get(lastIndex)) <= Math.abs(dq.getLast() - list.get(lastIndex))) {
                dq.addLast(list.get(lastIndex));
            } else {
                dq.addFirst(list.get(lastIndex));
            }
            lastIndex--;
        }

        int res = 0;
        int first = dq.removeFirst();
        while (!dq.isEmpty()) {
            int second = dq.removeFirst();
            res += Math.abs(first - second);
            first = second;

        }
        System.out.println(res);
    }
}
