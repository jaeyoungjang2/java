import java.util.Scanner;

public class baekjoon9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            String[] tempArray = temp.split(" ");
            for (String string : tempArray) {
                sb.append(getReverseString(string)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static String getReverseString(String string) {
        String reverseString = "";
        for (int j = string.length() - 1; j >= 0; j--) {
            reverseString += string.charAt(j);
        }
        return reverseString;
    }
}
