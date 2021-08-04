import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionToStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동", "김유신", "이순신", "유관순");
        Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.println(s));
    }
}
