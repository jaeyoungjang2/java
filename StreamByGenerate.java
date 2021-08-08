import java.util.stream.Stream;

public class StreamByGenerate {
    public static void main(String[] args) {
        Stream stream = Stream.generate(() -> "next").limit(10);
        stream.forEach(s -> System.out.println(s));
    }
}
