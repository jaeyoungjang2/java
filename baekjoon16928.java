import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class baekjoon16928 {
    static int res = 0;
    static HashMap<Integer, Integer> snake_position_map;
    static HashMap<Integer, Integer> ladder_position_map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ladder = sc.nextInt();
        int snake = sc.nextInt();

        ladder_position_map = new HashMap<>();
        snake_position_map = new HashMap<>();

        for (int i = 0; i < ladder; i++) {
            ladder_position_map.put(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < snake; i++) {
            snake_position_map.put(sc.nextInt(), sc.nextInt());
        }
        dfs(1, 0);
        System.out.println(res);

    }

    static void dfs(int position, int count) {
        // System.out.println("position: " + position);
        // System.out.println("count: " + count);
        if (position == 100) {
            if (res == 0) {
                res = count;
                return;
            }
            Math.min(res, count);
            return;
        }
        if (position > 100) {
            return;
        }

        int numOfLadder = 0;
        ArrayList<Integer> next_ladder_position = new ArrayList<>();
        ArrayList<Integer> next_forward_position = new ArrayList<>();

        for (int i = 6; i > 0; i--) {
            int next_position = position + i;
            // 뱀 위치는 갈 필요가 없고
            // 사다리 포지션은 모두 가봐야 하고
            // 사다리가 아닌 제일 큰 수로도 가보자.
            if (snake_position_map.containsKey(next_position)) {
                continue;
            }
            if (ladder_position_map.containsKey(next_position)) {
                next_ladder_position.add(next_position);
                numOfLadder++;
                continue;
            }
            if (next_forward_position.size() == 1) {
                continue;
            }
            next_forward_position.add(next_position);
        }

        if (numOfLadder > 0) {
            for (Integer next_position : next_ladder_position) {
                dfs(ladder_position_map.get(next_position), count + 1);
            }
        }

        if (next_forward_position.size() == 1) {
            int next_position = next_forward_position.get(0);
            if (next_position >= 100) {
                dfs(100, count + 1);
            } else {
                dfs(next_forward_position.get(0), count + 1);
            }

        }
    }
}
