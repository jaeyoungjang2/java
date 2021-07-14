public class ExceptionEx {
    public static void main(String[] args) {
        try {
            int[] ary = { 1, 2, 3 };
            System.out.println(ary[3]);
            System.out.println(3 / 0);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없음");
            // TODO: handle exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 범위 초과");
        } catch (Exception e) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("무조건 실행");
        }
    }

}
