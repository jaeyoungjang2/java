import java.util.Scanner;

public class backjoon9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] array1;

        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            array1 = line.split(" ");
            String result = "";
            for (String string : array1) {
                for (int j = string.length() - 1; j >= 0; j--) {
                    result += string.charAt(j);
                }
                result += " ";
            }
            System.out.println(result);
        }
        sc.close();
    }

}
