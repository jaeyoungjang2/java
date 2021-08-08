import java.util.stream.Stream;

public class StreamByBuilder {
    public static void main(String[] args) {
        Stream stream = Stream.builder().add("HI").add("bye").build();
        stream.forEach(s -> System.out.println(s));
    }
}
