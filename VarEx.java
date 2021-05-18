public class VarEx {
    public static void main(String[] args) {
        // 클래스 변수 사용
        System.out.println("Avante 제조사 : " + Avante.company);

        // 객체 생성
        Avante a1 = new Avante();
        Avante a2 = new Avante();

        // 인스턴스 변수의 값 변경
        a1.color = "흰색";
        a2.color = "검정";

        // 인스턴스 변수 출력
        System.out.println(a1.color);
        System.out.println(a2.color);

        // 클래스 변수를 인스턴스 객체로 출력
        System.out.println(a1.company);
        System.out.println(a2.company);

        // 클래수 변수의 값 변경
        a1.company = "기아";

        // 클래스 변수의 값 변경 후 클래스 변수와 인스턴스 변수 출력
        System.out.println(Avante.company);
        System.out.println(a1.company);
        System.out.println(a2.company);
    }
}

class Avante {
    String color; // 인스턴스 변수
    static String company = "현대"; // 클래스 변수
}