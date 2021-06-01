import java.util.Scanner;

public class baekjoon11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num];
        int aryIndex[] = new int[num];
        for (int i = 0; i < num; i++) {
            ary[i] = sc.nextInt();
            aryIndex[i] = 1;
            for (int j = 0; j < i; j++) {
                // 현재 값보다 작으면서 인덱스가 높으면 인덱스 += 1
                if ((ary[i] > ary[j]) & (aryIndex[i] <= aryIndex[j])) {
                    aryIndex[i] = aryIndex[j] + 1;
                }
            }
        }

        int res = 0;
        for (int i : aryIndex) {
            if (res < i) {
                res = i;
            }
        }

        System.out.println(res);

        sc.close();
    }
}