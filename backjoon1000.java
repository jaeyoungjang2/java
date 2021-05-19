
import java.io.IOException;
import java.util.Scanner;

public class backjoon1000 {
    public static void main(String args[]) throws IOException {
        Scanner = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + b);

    }

}

bool prime(int n){
    if (n < 2) {
        return false;
    }
    for (int i=2; i*i<=n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}