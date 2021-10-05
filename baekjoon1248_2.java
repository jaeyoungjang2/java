import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class baekjoon1248_2 {
    private static int n;
    private static String s;
    private static Character[] info;
    private static int[] indexInfo;
    private static List<Integer> res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        info = new Character[n];
        indexInfo = new int[n];
        res = new ArrayList<>();

        int targetIndex = 0;
        int nextTarget = n;
        for (int i = 0; i < n; i++) {
            info[i] = s.charAt(targetIndex);
            indexInfo[i] = targetIndex;
            targetIndex += nextTarget;
            nextTarget--;
        }

        nextPermutation(0);

    }

    private static void nextPermutation(int index) {
        if (index == n) {
            if (check()) {
                for (int i : res) {
                    System.out.print(i + " ");
                }
                System.exit(0);
            }
            return;
        }
        for (int i = 1; i < 11; i++) {
            if (info[index] == '+') {
                res.add(i);
                if (check()) {
                    nextPermutation(index + 1);

                }
                res.remove(res.size() - 1);
            } else if (info[index] == '-') {
                res.add(-i);
                if (check()) {
                    nextPermutation(index + 1);
                }
                res.remove(res.size() - 1);
            } else {
                res.add(0);
                if (check()) {
                    nextPermutation(index + 1);
                }
                res.remove(res.size() - 1);
            }
        }
    }

    private static boolean check() {

        for (int i = 0; i < res.size(); i++) {
            for (int j = i; j < res.size(); j++) {
                if (!check2(i, j, indexInfo[i] + j - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check2(int start, int end, int infoIndex) {

        int infoSum = 0;
        for (int i = start; i < end + 1; i++) {
            infoSum += res.get(i);
        }

        if (infoSum > 0 && s.charAt(infoIndex) == '+') {
            return true;
        }
        if (infoSum < 0 && s.charAt(infoIndex) == '-') {
            return true;
        }
        if (infoSum == 0 && s.charAt(infoIndex) == '0') {
            return true;
        }
        return false;
    }
}
