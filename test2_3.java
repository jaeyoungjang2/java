import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test2_3 {
    // 표준입력을 수행할 Scanner를 선언한다
    public static Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseNum) {
        // 하나의 테스트케이스를 처리하는 함수
        // 각 테스트케이스에 대하여 데이터를 입력받고 정답을 출력하세요
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int customerOrderNumber = 0;
        String[] customerPhoneNumbers = scanner.nextLine().split(" ");
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            customerOrderNumber++;
            set.add(customerPhoneNumbers[i]);
            if (set.size() == m) {
                break;
            }
        }
        System.out.println(customerOrderNumber);
    }

    public static void main(String[] args) { // 프로그램의 시작부
        int tn = scanner.nextInt(); // 테스트케이스의 수를 입력받는다
        scanner.nextLine();
        for (int caseNum = 1; caseNum <= tn; caseNum++) {
            // 테스트케이스의 수 만큼 반복 수행한다
            testCase(caseNum);
        }
    }
}
