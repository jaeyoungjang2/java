import java.util.Scanner;

public class baekjoon1107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = sc.nextInt();
        int ary[] = new int[count];
        for (int i = 0; i < count; i++) {
            ary[i] = sc.nextInt();
        }

        int plusNum = num;
        int minusNum = num;
        // 입력 받은 수와 비교
        if (condition) {
            
        }
        ;

        // 입력 받은 수에서 제외해야 하는 수가 존재하지 않으면 바로 결과 보내주기

        // 입력 받은 수에서 제외해야 하는 수가 존재하면 + 값 1개와 - 값 1개 생성

        // +값과 -값 각각 제외하는 수가 존재하는 지 확인

        // 제외해야 하는 수가 존재하면 + 값 1개와 - 값 1개 다시 생성

        // 없으면 입력받은 수와 크기 비교 + 현재 수의 길이를 더한 값을 결과로 보내줌

    }

    static Boolean check(int[] ary, int num) {
        while (num / 10 > 0) {
            
            int temp = num % 10;
            for (int i = 0; i < ary.length; i++) {
                if (ary[i] == temp) {
                    return false;
                }
            }
            num /= 10;
        }
        return true;
    }

}
