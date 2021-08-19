public enum Planet {
    MERCURY(3, 2), VENUS(4, 6), EARTH(5, 6);

    private final double mass; // 질량(단위: 킬로그램)
    private final double radius; // 반지름(단위: 미터)

    // 생성자
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }
}