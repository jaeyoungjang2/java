import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon2667 {
    static char[][] infoAry;
    static ArrayList<Integer> ary = new ArrayList<>();
    static Queue<Integer> queueX = new LinkedList<>();
    static Queue<Integer> queueY = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> visit = new ArrayList<>();
    static int cycle;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cycle = sc.nextInt();
        infoAry = new char[cycle][cycle];

        for (int i = 0; i < cycle; i++) {
            visit.add(new ArrayList<>());
            String line = sc.next();
            for (int j = 0; j < cycle; j++) {
                infoAry[i][j] = line.charAt(j);
                visit.get(i).add(1);
            }
        }

        for (int i = 0; i < cycle; i++) {
            for (int j = 0; j < cycle; j++) {
                if (visit.get(i).get(j) == 1 && infoAry[i][j] == '1') {
                    visit.get(i).set(j, 0);
                    permutation(i, j);
                }
            }
        }
        System.out.println(ary.size());
        ary.sort(null);
        for (int lastRes : ary) {
            System.out.println(lastRes);
        }
    }

    static void permutation(int x, int y) {
        // System.out.println(x);
        // System.out.println(y);

        int currX;
        int currY;
        int count = 0;
        queueX.offer(x);
        queueY.offer(y);
        // queue가 있는 동안은 진행하여야 하며,
        // 거점마다 상 하 좌 우를 살펴봐야 함

        // 상하 좌우를 살필 때, row와 col은 항상 0보다 커야 하며,
        // 해당위치가 방문한 곳이면 (visit == 0) 큐를 추가하지 않는다.
        // 해당 위치가 방문하지 않은 곳 (visit == 1) 이면 큐에 추가

        // 큐에 들어가는 위치가 단지의 크기임을 알 수 있으며,
        // 최종 크기를 ary에 집어 넣음

        // ary의 최종 크기는 단지의 개수를 나타냄

        while (queueX.size() > 0) {
            currX = queueX.poll();
            currY = queueY.poll();
            // x, y 좌표는 0 이상이어야 한다.

            if (currX + 1 < cycle && visit.get(currX + 1).get(currY) == 1 && infoAry[currX + 1][currY] == '1') {
                visit.get(currX + 1).set(currY, 0);
                queueX.add(currX + 1);
                queueY.add(currY);
            }
            if (currX - 1 >= 0 && visit.get(currX - 1).get(currY) == 1 && infoAry[currX - 1][currY] == '1') {
                visit.get(currX - 1).set(currY, 0);
                queueX.add(currX - 1);
                queueY.add(currY);
            }
            if (currY + 1 < cycle && visit.get(currX).get(currY + 1) == 1 && infoAry[currX][currY + 1] == '1') {
                visit.get(currX).set(currY + 1, 0);
                queueX.add(currX);
                queueY.add(currY + 1);
            }
            if (currY - 1 >= 0 && visit.get(currX).get(currY - 1) == 1 && infoAry[currX][currY - 1] == '1') {
                visit.get(currX).set(currY - 1, 0);
                queueX.add(currX);
                queueY.add(currY - 1);
            }

            // 적합한 크기일 때 단지 크기를 늘려준다.
            count++;
        }
        // toDo: 최종 크기를 ary에 꼭 집어 넣어야 함
        // System.out.println("count: " + count);
        // System.out.println();
        ary.add(count);
    }

}
