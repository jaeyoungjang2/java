import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        // toDO: 랜덤 값 받기
        String randomNumber = "369";

        // 랜덤으로 받은 값을 리스트로 변환
        ArrayList<Integer> randList = new ArrayList<>();
        for (char ch : randomNumber.toCharArray()) {
            int digit = ch - '0';
            randList.add(digit);
        }

        // 사용자의 값을 받기 위함
        Scanner sc = new Scanner(System.in);

        // 사용자가 결과를 맞출때 까지 계속해서 돌아감
        while (true) {
            // 변수 초기화
            int ball = 0;
            int strike = 0;

            // 사용자의 값을 받음
            String userNumber = sc.next();
            ArrayList<Integer> answer = new ArrayList<>();

            // 사용자에게 받은 값을 리스트 형태로 변경
            for (char ch : userNumber.toCharArray()) {
                int digit = ch - '0';
                answer.add(digit);
            }
            // 사용자의 값과 랜덤 값이 완벽하게 일치할 경우 종료
            if (answer.equals(randList)) {
                System.out.println("3S!!!!!");
                break;
            }

            // 완벽하게 일치 하지 않을 경우, xSxB 로 표시
            Iterator<Integer> answerIt = answer.iterator();
            Iterator<Integer> randIt = randList.iterator();
            while (answerIt.hasNext()) {
                int ansTemp = answerIt.next();
                int ranTemp = randIt.next();
                if (ansTemp == ranTemp) {
                    strike++;
                } else if (randList.contains(ansTemp)) {
                    ball++;
                }

            }
            System.out.println(strike + "S" + ball + "B");

        }
    }
}
