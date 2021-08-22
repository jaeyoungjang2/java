import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class wadid {
    public static void main(String[] args) {
        // String s = "101#1234#102#654321#51#203#201#202#1#";
        // int[][] passWord = { { 101, 1234 }, { 102, 54321 }, { 201, 202 }, { 202, 1 }
        // };

        // String s = "101#1234#102#654321#51#203#201#202#1#";
        // int[][] passWord = { { 101, 1234 }, { 102, 54321 }, { 201, 202 }, { 202, 1 }
        // };

        String s = "101#1234#102#654321#51#203#201#202#1#";
        int[][] passwords = { { 101, 1234 }, { 102, 54321 }, { 201, 202 }, { 202, 1 } };

        List<Integer> hosuList = new ArrayList<>();
        Map<Integer, Integer> hosuMap = new HashMap<>();

        for (int[] passWordArray : passwords) {

            hosuList.add(passWordArray[0]);
            hosuMap.put(passWordArray[0], passWordArray[1]);
        }

        String[] inputStringArray = s.split("#");
        Queue<String> q = new LinkedList<>();
        for (String string : inputStringArray) {
            q.add(string);
        }

        int res = 0;
        while (!q.isEmpty()) {
            int hosuPassword = 0;
            int currentHosu = Integer.parseInt(q.remove());
            if (!q.isEmpty() && hosuMap.containsKey(currentHosu)) {
                hosuPassword = hosuMap.get(currentHosu);
            } else {
                continue;
            }
            if (!q.isEmpty() && hosuPassword == Integer.parseInt(q.remove())) {
                res++;
            }
        }

        System.out.println(res);

    }
}
