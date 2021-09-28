import java.util.Scanner;

public class baekjoon10974 {
    private static int num;
    private static int[] info;
    private static int[] res;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        info = new int[num];
        res = new int[num];
        visit = new boolean[num];
        for (int i = 0; i < num; i++) {
            info[i] = i + 1;
        }

        allPermutation(0);
        System.out.println(sb);
    }

    private static void allPermutation(int index) {
        if (index == num) {
            for (int i : res) {
                sb.append(i + " ㅠㅁ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < num; i++) {
            if (!visit[i]) {
                visit[i] = true;
                res[index] = info[i];
                allPermutation(index + 1);
                visit[i] = false;
            }
        }
    }
}
