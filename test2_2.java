import java.util.Scanner;

public class test2_2 {
    // 10
    // SMS 010-1234-5678
    // CALL 010-1234-5678
    // CALL 010-1234-5678
    // SMS 010-1111-1111
    // SMS 010-5555-5555
    // CALL 010-5555-5555
    // CALL 010-5555-5555
    // CALL 010-4444-4444
    // SMS 010-5555-5555
    // CALL 010-5555-5555
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] logs = new String[n];
        String[] resultLogs = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            logs[i] = scanner.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        String callType = logs[0].split(" ")[0];
        String callNumber = logs[0].split(" ")[1];
        String currentCallType = "";
        String currentCallNumber = "";
        int tempCount = 1;
        for (int i = 1; i < n; i++) {
            currentCallType = logs[i].split(" ")[0];
            currentCallNumber = logs[i].split(" ")[1];

            if (callType.equals(currentCallType) && callNumber.equals(currentCallNumber)) {
                tempCount++;
                continue;
            }
            if (tempCount != 1) {
                sb.append(callType + " " + callNumber + " (" + tempCount + ")" + "\n");
            } else {
                sb.append(callType + " " + callNumber + "\n");
            }
            callType = currentCallType;
            callNumber = currentCallNumber;
            count++;
            tempCount = 1;
        }

        if (tempCount != 1) {
            sb.append(callType + " " + callNumber + " (" + tempCount + ")" + "\n");
        } else {
            count++;
            sb.append(currentCallType + " " + callNumber + "\n");
        }
        sb.insert(0, count + "\n");
        System.out.println(sb);
    }
}
