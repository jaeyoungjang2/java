public class Operation1Main {
    public static void main(String[] args) {
        for (Operation operation : Operation.values()) {
            System.out.printf("%s %s %s = %s%n", "4", operation, "6", operation.apply(4, 6));
        }

        for (Operation1 operation : Operation1.values()) {
            System.out.printf("%s %s %s = %s%n", "4", operation, "6", operation.apply(4, 6));
        }

    }
}
