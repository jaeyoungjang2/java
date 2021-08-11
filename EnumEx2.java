public class EnumEx2 {
    public static void main(String[] args) {
        for (Planet planet : Planet.values()) {
            System.out.println(planet);
            System.out.println(planet.mass());
            System.out.println(planet.radius());
            System.out.println();
        }
    }
}
