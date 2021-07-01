import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon2529 {
    static ArrayList<String> resAry = new ArrayList<>();

    static boolean[] check = { true, true, true, true, true, true, true, true, true, true };
    static char[] numList = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] ary = new String[num];

        for (int i = 0; i < ary.length; i++) {
            ary[i] = sc.next();
        }

        permutation("", num + 1, ary);

        System.out.println(resAry.get(resAry.size() - 1));
        System.out.println(resAry.get(0));

    }

    static Boolean check(String[] ary, String temp) {
        for (int i = 0; i < ary.length; i++) {
            if (ary[i].equals("<")) {
                if ((int) temp.charAt(i) > (int) temp.charAt(i + 1)) {
                    return false;
                }
            } else if (ary[i].equals(">")) {
                if ((int) temp.charAt(i) < (int) temp.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;

    }

    static void permutation(String temp, int terminate, String[] ary) {
        if (temp.length() == terminate) {
            if (check(ary, temp)) {
                resAry.add(temp);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (check[i]) {
                check[i] = false;
                permutation(temp + numList[i], terminate, ary);
                check[i] = true;
            }
        }

    }

}
