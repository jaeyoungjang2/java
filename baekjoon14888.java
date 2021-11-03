import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon14888 {
    private static int n;
    private static int[] info;
    private static boolean[] visit;
    private static int[] type;
    private static List<String> list;
    private static int maxResult = 0;
    private static int minResult = 0;
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 3
        // 3 4 5
        // 1 0 1 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n - 1];
        type = new int[n - 1];
        info = new int[n];
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        String[] operator = { "+", "-", "*", "/" };
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                list.add(operator[i]);
            }
        }

        permutation14888(0);
        Collections.sort(resultList);
        System.out.println(resultList.get(resultList.size() - 1));
        System.out.println(resultList.get(0));
    }

    private static int calculate14888(int num1, int num2, String symbol) {
        if (symbol.equals("+")) {
            return num1 + num2;
        }
        if (symbol.equals("-")) {
            return num1 - num2;
        }
        if (symbol.equals("*")) {
            return num1 * num2;
        }
        if (symbol.equals("/")) {
            return num1 / num2;
        }
        throw new IllegalArgumentException("적절하지 않은 기호가 들어왔습니다.");
    }

    private static void check14888() {
        int tempResult = info[0];
        for (int i = 1; i < n; i++) {
            tempResult = calculate14888(tempResult, info[i], list.get(type[i - 1]));
        }
        resultList.add(tempResult);
    }

    private static void permutation14888(int index) {
        if (index == n - 1) {
            check14888();
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                type[index] = i;
                permutation14888(index + 1);
                visit[i] = false;
            }
        }
    }
}
