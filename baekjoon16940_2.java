import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16940_2 {
    private static boolean[] visit;
    private static int[] expect;
    private static ArrayList<ArrayList<Integer>> info;
    private static int n;
    private static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 4
        // 1 2
        // 1 3
        // 2 4
        // 1 2 3 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new ArrayList<>();
        visit = new boolean[n + 1];
        expect = new int[n];
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            info.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            info.get(from).add(to);
            info.get(to).add(from);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            expect[i] = Integer.parseInt(st.nextToken());
        }

        bfs16940();
    }

    private static void bfs16940() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        if (expect[0] != 1) {
            System.out.println(0);
            System.exit(0);
        }
        int checkIndex = 1;

        while (!queue.isEmpty()) {
            int currentBfsNumber = queue.remove();

            // 종료 조건
            int count = 0;
            for (Integer nextBfsNumber : info.get(currentBfsNumber)) {
                if (!visit[nextBfsNumber]) {
                    visit[nextBfsNumber] = true;
                    parent[nextBfsNumber] = currentBfsNumber;
                    count++;
                }
            }

            for (int i = 0; i < count; i++) {
                int expectBfsNumber = expect[checkIndex];
                if (parent[expectBfsNumber] != currentBfsNumber) {
                    System.out.println(0);
                    System.exit(0);
                }
                queue.add(expectBfsNumber);
                checkIndex++;
            }

        }
        System.out.println(1);
    }
}
