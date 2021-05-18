public class CarMain {
    public static void main(String[] args) {
        Car tico = new Car();
        Car pride = new Car();

        tico.color = "흰색";
        tico.company = "현대";
        tico.type = "경차";
        pride.color = "검정";
        pride.company = "기아";
        pride.type = "소형";

        System.out.println(tico.color);
        System.out.println(tico.company);
        System.out.println(tico.type);
        System.out.println(pride.color);
        System.out.println(pride.company);
        System.out.println(pride.type);

    }
}
