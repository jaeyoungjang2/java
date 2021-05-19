import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon1463 {
    public static void main(String[] args) {
        int[] numbers = { 2, 3 };
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int res = 0;
        boolean isTure = true;
        ArrayList<Integer> ary = new ArrayList<Integer>();
        ary.add(x);
        while (isTure) {
            res++;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (Integer integer : ary) {
                if (integer % 2 == 0) {
                    if (integer / 2 == 1) {
                        isTure = false;
                    }
                    temp.add(integer / 2);
                }
                if (integer % 3 == 0) {
                    if (integer / 3 == 1) {
                        isTure = false;
                    }
                    temp.add(integer / 3);
                }
                if (integer - 1 == 1) {
                    isTure = false;
                }
                temp.add(integer - 1);
            }
            ary = temp;
        }
        System.out.println(res);
    }

}
