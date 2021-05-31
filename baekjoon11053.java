import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ary[] = new int[num];

        ArrayList<Integer> indexList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < num; i++) {
            int target = sc.nextInt();
            if (target > max) {
                indexList.add(i);
                max = target;
            }
        }
        System.out.println(indexList.size());
        System.out.println(indexList);
    }
}
