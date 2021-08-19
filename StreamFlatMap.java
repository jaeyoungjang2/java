import java.util.Arrays;
import java.util.List;

public class StreamFlatMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("동해물과","백두산이","마르고 닳도록");
        list.stream().flatMap(data -> Arrays.stream(data.split(" ")).forEach(s -> System.out.println(s)););
    }
}
