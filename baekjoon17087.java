import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numb = br.readLine().split(" ");
        int n = Integer.parseInt(numb[0]);
        int s = Integer.parseInt(numb[1]);

        numb = br.readLine().split(" ");
        int[] bro = new int[numb.length];
        for (int i = 0; i < n; i++) {
            bro[i] = Integer.parseInt(numb[i]);
        }

        int res = 1000000000;
        for (int i = 0; i < bro.length; i++) {
            int length = s - bro[i];
            if (length < 0) {
                length = -length;
            }
            if (length < res) {
                res = length;
            }
        }
        System.out.println(res);

    }

    static int GCD(int a, int b){
        if (b == 0) {
            return a
        }
        return GCD(b, a%b)
    }
    
}

