public class LambdaFunctionEx {
    public static void main(String[] args) {
        InterFaceEx ie = (int x, int y) -> x + y;
        System.out.println(ie.sum(1, 2));
    }
}

interface InterFaceEx {
    public int sum(int x, int y);
}