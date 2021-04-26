import java.util.ArrayList;
import java.util.Scanner;

public class backjoon9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());

        String ps;
        boolean check;
        ArrayList<String> array;
        for (int i = 0; i < count; i++) {
            check = true;
            ps = sc.nextLine();
            array = new ArrayList<>();
            for (int j = 0; j < ps.length(); j++) {
                if (ps.charAt(j) == '(') {
                    array.add("(");
                } else if (ps.charAt(j) == ')' && array.size() == 0) {
                    check = false;
                } else {
                    array.remove(0);
                    continue;
                }
            }
            if (array.size() > 0) {
                check = false;
            }
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

}
