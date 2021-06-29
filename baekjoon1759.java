import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1759 {
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();
        String ary[] = new String[C];
        for (int i = 0; i < C; i++) {
            ary[i] = sc.next();
        }
        Arrays.sort(ary);

        // 증가하는 permutation
        permutation(ary, 0, L, "");

        for (String string : res) {
            // 최소 1개의 모음 (a, e, i, o, u), 2개의 자음으로 구성
            if (check(string)) {
                System.out.println(string);
            }
        }
        sc.close();

    }

    public static Boolean check(String temp) {

        Character moAry[] = { 'a', 'e', 'i', 'o', 'u' };
        int mo = 0;
        for (int i = 0; i < temp.length(); i++) {
            for (Character string : moAry) {
                if (temp.charAt(i) == string) {
                    mo++;
                }
            }
        }
        int ja = temp.length() - mo;
        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }

    public static void permutation(String[] ary, int index, int end, String temp) {

        if (temp.length() == end) {
            res.add(temp);
            return;
        }
        if (index == ary.length) {
            return;
        }
        String temp2 = temp + ary[index];
        permutation(ary, index + 1, end, temp2);
        permutation(ary, index + 1, end, temp);
    }
}
