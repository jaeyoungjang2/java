public class CarMain3 {
    public static void main(String[] args) {
        // Car 타입의 배엵객체 생성
        Car[] Cars = new Car[3];

        // 모든 인덱스에 tico 객체 저장
        for (int i = 0; i < Cars.length; i++) {
            Car tico = new Car();
            tico.color = "흰색";
            tico.company = "현대";
            tico.type = "경차";
            Cars[i] = tico;
        }
        System.out.println("0번 인덱스 color : " + Cars[0].color);
        System.out.println("1번 인덱스 color : " + Cars[1].color);
        System.out.println("2번 인덱스 color : " + Cars[2].color);
        Cars[0].color = "검정";
        System.out.println("0번 인덱스 color : " + Cars[0].color);
        System.out.println("1번 인덱스 color : " + Cars[1].color);
        System.out.println("2번 인덱스 color : " + Cars[2].color);
    }
}
