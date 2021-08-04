public class LambdaEx {
    public static void main(String[] args) {
        LambdaInterface li = () -> {
            String str = "메서드 출력";
            System.out.println(str);
        };
    }
}

interface LambdaInterface {
    void print();
}