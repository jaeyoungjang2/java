import java.util.Scanner;

public class baekjoon9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            int threthold = 0;
            boolean isTrue = true;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '(') {
                    threthold++;
                } else if (temp.charAt(j) == ')') {
                    threthold--;
                }
                if (threthold < 0) {
                    isTrue = false;
                }
            }
            if (threthold != 0) {
                isTrue = false;
            }
            if (isTrue) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
