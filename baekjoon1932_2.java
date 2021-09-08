import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class baekjoon1932_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();

        info.add(new ArrayList<>());
        info.get(0).add(sc.nextInt());

        for (int i = 1; i < n; i++) {
            info.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                info.get(i).add(sc.nextInt());
                // 맨 왼쪽에 있는 case
                if (j == 0) {
                    info.get(i).set(j, info.get(i - 1).get(j) + info.get(i).get(j));
                    continue;
                }
                // 맨 오른쪽에 있는 case
                if (j == i) {
                    info.get(i).set(j, info.get(i - 1).get(j - 1) + info.get(i).get(j));
                    continue;
                }
                // 중간에 있는 case
                info.get(i).set(j, Math.max(info.get(i - 1).get(j - 1), info.get(i - 1).get(j)) + info.get(i).get(j));
            }
        }

        Integer a = info.get(n - 1).stream().max(Comparator.comparing(x -> x)).orElse(1);
        System.out.println(a);
    }
}
