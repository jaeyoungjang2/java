import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class baekjoon1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ary = br.readLine().split(" ");
        int[] numbers = new int[2];
        HashSet<Integer> allSet = new HashSet<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(ary[i]);
        }

        for (int i = 2; i <= numbers[1]; i++) {
            allSet.add(i);
        }

        for (int i = 2; i < Math.sqrt(numbers[1]) + 1; i++) {
            for (int j = i; j < numbers[1]; j++) {
                if (j * i > numbers[1]) {
                    break;
                }
                set.add(i * j);
            }
        }

        allSet.removeAll(set);
        ArrayList<Integer> res = new ArrayList<Integer>(allSet);
        Collections.sort(res);
        for (int j = 0; j < res.size(); j++) {
            if (numbers[0] <= res.get(j)) {
                System.out.println(res.get(j));
            }

        }
    }
}
