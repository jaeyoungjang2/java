import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon14002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num];
        int indexAry[] = new int[num];
        int vAry[] = new int[num];
        for (int i = 0; i < vAry.length; i++) {
            vAry[i] = -1;
        }

        for (int i = 0; i < num; i++) {
            ary[i] = sc.nextInt();
            indexAry[i] = 1;
            for (int j = 0; j < i; j++) {
                if (ary[i] > ary[j] && indexAry[i] <= indexAry[j]) {
                    indexAry[i] = indexAry[j] + 1;
                    vAry[i] = j;
                }
            }
        }
        int maxValue = 0;
        int maxIndex = 0;

        ArrayList<Integer> res = new ArrayList<>();

        // 가장 긴 증가하는 부분을 확인
        for (int i = 0; i < indexAry.length; i++) {
            if (maxValue < indexAry[i]) {
                maxValue = indexAry[i];
                maxIndex = i;
            }
        }

        while (maxIndex != -1) {
            res.add(ary[maxIndex]);
            maxIndex = vAry[maxIndex];
        }

        System.out.println(maxValue);
        for (int i = res.size(); i > 0; i--) {
            System.out.print(res.get(i - 1) + " ");
        }
        System.out.println();
    }
}