import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorEx {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[] { "홍길동", "김유신", "이순신", "유관순" });

        System.out.println("for 문 이용");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("iterator 사용");
        Iterator it = list.iterator();
        if (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("내부 반복자 사용");
        Stream st = list.stream();
        // st.forEach(System.out::println);
        st.forEach(s -> System.out.println(s));
    }
}
