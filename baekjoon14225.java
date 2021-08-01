import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class baekjoon14225 {
    static HashSet<Integer> set = new HashSet<>();
    static int n;
    static int[] info;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        info = new int[n];
        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
        }
        dfs(0, 0);
        Arrays.toString(info);
        List<Integer> resAry = new ArrayList<>(set);
        Collections.sort(resAry);

        int res = 1;
        boolean isTrue = false;
        for (int i = 1; i < resAry.size(); i++) {
            if (res != resAry.get(i)) {
                isTrue = true;
                break;
            }
            if (res == resAry.get(i)) {
                res++;
                continue;
            }
        }
        System.out.println(res);

    }

    static void dfs(int index, int currTotal) {
        if (index == n) {
            set.add(currTotal);
            return;
        }

        dfs(index + 1, currTotal + info[index]);
        dfs(index + 1, currTotal);
    }
}
