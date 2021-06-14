public class MethodCall {
    public static void main(String[] args) {
        printHi();

        Method.printNmae();

        Method m = new Method();
        m.printEmail();
    }

    static void printHi() {
        System.out.println("HI");
    }

}

class Method {
    static void printNmae() {
        System.out.println("printName() 실행");
    }

    void printEmail() {
        System.out.println("printEmail() 실행");
        printId(); // 다른 메서드 실행
    }

    void printId() {
        System.out.println("printId() 실행");
    }
}