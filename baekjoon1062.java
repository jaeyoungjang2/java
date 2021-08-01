import java.util.HashMap;
import java.util.Scanner;

public class baekjoon1062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String basic = "antatica";
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < basic.length(); i++) {
            map.put(basic.charAt(i), true);
        }
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < temp.length(); j++) {

                temp.charAt(j);
            }
        }

    }

}
