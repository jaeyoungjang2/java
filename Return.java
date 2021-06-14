public class Return {
    public static void main(String[] args) {
        ReturnEx obj = new ReturnEx();

        System.out.println(obj.getName());
    }
}

class ReturnEx {
    String getName() {
        return "홍길동";
    }
}