public class Overloading {
    public static void main(String[] args) {
        Operator op = new Operator();

        op.multiply(4, 5);
        op.multiply(4, 5.5);
    }
}

class Operator {
    void multiply(int x, int y) {
        System.out.println("int x, int y");
        System.out.println(x * y);
    }

    void multiply(int x, double y) {
        System.out.println("int x, double y");
        System.out.println(x * y);
    }
}