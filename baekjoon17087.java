import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon17087 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        Stack<Integer> bro = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            bro.add(Math.abs(sc.nextInt() - c));
        }

        int gcd = bro.pop();
        while (bro.size() > 0) {
            gcd = GCD(gcd, bro.pop());
        }
        System.out.println(gcd);
    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

}
