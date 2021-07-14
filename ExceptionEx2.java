public class ExceptionEx2 {
    public static void main(String[] args) {
        try {
            throw new Exception("예외발생 예외발생 긴급상황");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("예외를 강제로 발생시킨 상황입니다.");
            e.getMessage();
        }
        System.out.println("프로그램 종료");
    }

}
// 예외를 강제로 발생시킨 상황입니다.
// 프로그램 종료