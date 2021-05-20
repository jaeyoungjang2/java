import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[12];
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 4;
        numbers[4] = 7;
        for (int i = 5; i <= 11; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
        }

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int target = sc.nextInt();
            System.out.println(numbers[target]);
        }

    }
}
