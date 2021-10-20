import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon16947_3 {
    private static ArrayList<ArrayList<Integer>> info;
    private static int[] distInfo;
    private static boolean[] visit;
    private static boolean[] isCycle;
    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 4
        // 1 3
        // 4 3
        // 4 2
        // 1 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        distInfo = new int[n + 1];
        visit = new boolean[n + 1];
        isCycle = new boolean[n + 1];
        info = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            info.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            info.get(from).add(to);
            info.get(to).add(from);
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        visit[1] = true;
        findCycle16947(stack, 1);

        distInfo = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (isCycle[i]) {
                calculateDistance(i);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(distInfo[i] + " ");
        }
        System.out.println(sb);
    }

    private static void calculateDistance(int currentStation) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentStation);

        while (!queue.isEmpty()) {
            currentStation = queue.remove();
            for (Integer nextStation : info.get(currentStation)) {
                if (!visit[nextStation]) {
                    visit[nextStation] = true;
                    if (!isCycle[nextStation]) {
                        distInfo[nextStation] = distInfo[currentStation] + 1;
                    }
                    queue.add(nextStation);
                }
            }
        }
    }

    private static void findCycle16947(Stack<Integer> stack, int currentStation) {

        for (Integer nextStation : info.get(currentStation)) {
            // toDo : calculate result;
            if (visit[nextStation] && Math.abs(distInfo[nextStation] - distInfo[currentStation]) >= 2) {
                int endCycle = nextStation;
                int endIndex = stack.size() - 1;
                isCycle[endCycle] = true;
                while (stack.contains(endCycle) && stack.get(endIndex) != endCycle) {
                    isCycle[stack.get(endIndex)] = true;
                    endIndex--;
                }
                return;
            }

            if (!visit[nextStation]) {
                distInfo[nextStation] = distInfo[currentStation] + 1;
                visit[nextStation] = true;
                stack.add(nextStation);
                findCycle16947(stack, nextStation);
                stack.pop();
            }
        }
    }
}
