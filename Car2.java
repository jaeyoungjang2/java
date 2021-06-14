public class Car2 {
    String name;
    String color;
    String company;

    Car2() {
        this("모닝", "흰색", "기아");
    }

    Car2(String name, String color, String company) {
        this.name = name;
        this.color = color;
        this.company = company;
    }

    @Override
    public String toString() {
        return name + " " + color + " " + company;
    }
}
