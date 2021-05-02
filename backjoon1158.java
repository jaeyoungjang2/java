import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
// import java.util.StringTokenizer;

public class backjoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = br.readLine();
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // int k = Integer.parseInt(st.nextToken());
        String[] strAry = text.split(" ");
        int n = Integer.parseInt(strAry[0]);
        int k = Integer.parseInt(strAry[1]);
        Queue<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while (!list.isEmpty()) { // N명의 사람이 모두 제거될 때까지, 즉 큐가 빌 때까지 반복
            for (int j = 0; j < k; j++) { // K번째를 제거하기 위한 루프
                if (j == k - 1) { // K번째 순서 도착
                    sb.append(list.poll() + ", "); // K번을 제거
                } else {
                    list.add(list.poll()); // K번이 아닐 때에는 맨 뒤로 이동
                }
            }

        }

        bw.write((sb.substring(0, sb.length() - 2) + ">").toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
