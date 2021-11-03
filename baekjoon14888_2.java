import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon14888_2 {
    private static int n;
    private static int[] info;
    private static boolean[] visit;
    private static int[] type;
    private static List<String> list;
    private static int maxResult = 0;
    private static int minResult = 0;
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            String temp = "";
            if (i == 0) {
                temp = "+";
            } else if (i == 1) {
                temp = "-";
            } else if (i == 2) {
                temp = "*";
            } else if (i == 3) {
                temp = "/";
            }
            for (int j = 0; j < num; j++) {
                list.add(temp);
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

    private static int check14888() {
        int tempResult = calculate14888(info[0], info[1], list.get(type[0]));
        for (int i = 1; i < n - 1; i++) {
            tempResult = calculate14888(tempResult, info[i + 1], list.get(type[i]));
        }
        return tempResult;
    }

    private static void permutation14888(int index) {
        if (index == n - 1) {
            int tempResult = check14888();
            // if (minResult == 0) {
            // minResult = tempResult;
            // } else if (minResult > tempResult) {
            // minResult = tempResult;
            // }
            // if (maxResult < tempResult) {
            // maxResult = tempResult;
            // }
            resultList.add(tempResult);
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