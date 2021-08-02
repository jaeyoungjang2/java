import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class baekjoon1062 {
    static String[] info;
    static int n;
    static int k;
    static ArrayList<Character> ary = new ArrayList<>();
    static HashMap<Character, Boolean> visit;
    static HashSet<Character> set = new HashSet<>();
    static List<Character> list;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        info = new String[n];
        String basic = "antatica";
        visit = new HashMap<>();
        for (int i = 0; i < basic.length(); i++) {
            visit.put(basic.charAt(i), true);
        }
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            // info[i] = temp.substring(4, temp.length() - 4);
            info[i] = temp;
            for (int j = 4; j < temp.length() - 4; j++) {
                if (!visit.containsKey(temp.charAt(j))) {
                    set.add(temp.charAt(j));
                }

            }
        }
        list = new ArrayList<>(set);
        if (k - 5 > list.size()) {
            res = k;
        } else {
            dfs(0, 0);
        }
        System.out.println(res);

    }

    static void dfs(int index, int count) {

        if (count == k - 5) {
            System.out.println(visit);
            System.out.println(list);
            System.out.println(index);
            System.out.println();
            int currRes = 0;
            for (int i = 0; i < n; i++) {
                Boolean isTrue = true;
                String temp = info[i];
                for (int j = 4; j < info[i].length() - 4; j++) {
                    if (visit.containsKey(temp.charAt(j)) && !visit.get(temp.charAt(j))) {
                        isTrue = false;
                        break;
                    } else if (!visit.containsKey(temp.charAt(j))) {
                        isTrue = false;
                        break;
                    }
                }
                if (isTrue) {
                    currRes++;
                }
                if (currRes > res) {
                    res = currRes;
                }
            }
            return;
        }
        if (index >= list.size()) {
            return;
        }

        visit.put(list.get(index), true);
        dfs(index + 1, count + 1);
        visit.put(list.get(index), false);
        dfs(index + 1, count);

    }

}
