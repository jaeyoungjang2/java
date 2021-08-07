public class LambdaEx4 {
    public static void main(String[] args) {
        LambdaInterface4 ie = (x, y) -> {
            return x * y;
        };

        System.out.println(" 두 수의 곱 : " + ie.cal(3, 2));
        ie = (x, y) -> x + y;
        System.out.println(" 두 수의 합 : " + ie.cal(3, 2));
        ie = (x, y) -> x / y;
        System.out.println(" 두 수의 몫 : " + ie.cal(5, 2));
        ie = (x, y) -> x % y;
        System.out.println(" 두 수의 나머지 : " + ie.cal(5, 2));
        ie = (x, y) -> sum(x, y);
        System.out.println(" 두 수의 합(x,y) : " + ie.cal(3, 2));
    }

    static int sum(int x, int y) {
        return x + y;
    }
}

@FunctionalInterface
interface LambdaInterface4 {
    int cal(int x, int y);
}