import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon14501 {
    static ArrayList<Integer> ary = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int aryT[] = new int[N + 1];
        int aryP[] = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            aryT[i] = sc.nextInt();
            aryP[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(aryT));
        // System.out.println(Arrays.toString(aryP));

        permutation(1, 0, aryT, aryP, N);

        // T(i) + i <= N+1 상담 가능
        // T(i) + i > N+1 일 경우 상담을 할 수 없다.
        int res = 0;
        for (int i : ary) {
            if (i > res) {
                res = i;
            }
        }
        // System.out.println(ary);
        System.out.println(res);
    }

    public static void permutation(int index, int temp, int[] aryT, int aryP[], int N) {

        if (index == N + 1) {
            ary.add(temp);
            return;
        }

        if (index > N + 1) {
            return;
        }
        permutation(index + 1, temp, aryT, aryP, N);
        permutation(index + aryT[index], temp + aryP[index], aryT, aryP, N);
    }

}
