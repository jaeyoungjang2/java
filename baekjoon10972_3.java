import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon10972_3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] info = new int[num];

        for (int i = 0; i < num; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        // 12345
        int endIndex = num - 1;

        if (num == 1) {
            System.out.println(-1);
            System.exit(0);
        }

        while (endIndex != 0 && info[endIndex - 1] > info[endIndex]) {
            endIndex--;
        }

        if (endIndex == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        int temp = info[endIndex];
        int tempIndex = endIndex;
        for (int i = endIndex + 1; i < num; i++) {
            if (info[i] > info[endIndex - 1] && info[i] < temp) {
                tempIndex = i;
                temp = info[i];
            }
        }

        info[tempIndex] = info[endIndex - 1];
        info[endIndex - 1] = temp;

        for (int i = 0; i < endIndex; i++) {
            System.out.print(info[i] + " ");
        }

        for (int i = num - 1; i >= endIndex; i--) {
            System.out.print(info[i] + " ");
        }
    }
}
