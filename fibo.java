public class fibo {
    public static void main(String[] args) {
        int[] memo = new int[100]; // 최대 깊이를 지정해준다.
        int res = Fibo(memo, 4);
        System.out.println(res);

    }

    static int Fibo(int[] memo, int a) {
        if (a <= 1) {
            return a;
        } else if (memo[a] > 0) {
            return memo[a];
        }
        return Fibo(memo, a - 1) + Fibo(memo, a - 2);
    }
}
