import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon14226 {
    public static void main(String[] args) {
        // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
        // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
        // 화면에 있는 이모티콘 중 하나를 삭제한다.
        // 이모티콘 1개에서 시작
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int max = 2000;
        boolean visit[][] = new boolean[max][max];
        int result = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 1, 0, 0, 0 });

        while (!q.isEmpty()) {
            int[] info = q.remove();
            int position = info[0];
            int copy = info[1];
            int copyCount = info[2];
            int time = info[3];
            if (position == s) {
                result = time;
                break;
            }
            // 복사가 안되어 있는 경우
            // 복사를 진행하고 붙여넣기를 한다. 시간 + 2

            // 복사가 되어 있는 경우
            // 붙여 넣기를 진행한다. 시간 +1
            // 복사 붙여 넣기를 진행한다. 시간 + 2

            // 복사가 되어있는 경우 붙여넣기를 진행한다.
            if (position + copyCount < max && copy == 1 && visit[position + copyCount][copyCount] == false) {
                q.add(new int[] { position + copyCount, 1, copyCount, time + 1 });
                visit[position + copyCount][copyCount] = true;
            }
            //
            if (position - 1 >= 0 && visit[position - 1][copyCount] == false) {
                q.add(new int[] { position - 1, copy, copyCount, time + 1 });
                visit[position - 1][copyCount] = true;
            }

            // 복사가 되어있는 경우지만 새로운 복사를 진행하여 붙여넣기를 한다.
            // 복사가 안되어 있는 경우 복사를 진행 후 붙여넣기를 한다.
            if (2 * position < max && visit[position][position] == false) {
                q.add(new int[] { position, 1, position, time + 1 });
                visit[position][position] = true;
            }

        }
        System.out.println(result);

    }

}
