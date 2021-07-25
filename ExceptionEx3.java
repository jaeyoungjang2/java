public class ExceptionEx3 {
    public static void main(String[] args) {
        try {
            first();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("main class 에서 예외 처리중!!!");
        }

    }

    static void first() throws Exception {
        try {
            second();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("first class에서 예외 처리중!!!");
            System.out.println(e.getMessage());

        }
    }

    static void second() {
        // try {
        // throw new Exception("제가 강제로 예외 발생시켰어요!!!");
        // } catch (Exception e) {
        // System.out.println("second class에서 예외 처리중!!!");
        // throw e;
        // // TODO: handle exception
        // }
        System.out.println("Second class 예외발생");
        // throw new Exception("제가 강제로 예외 발생시켰어요!!!");
        throw new IllegalArgumentException("예외발생!");

    }
}

// second class에서 예외 처리중!!!
// first class에서 예외 처리중!!!
// 제가 강제로 예외 발생시켰어요!!!