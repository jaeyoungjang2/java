
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class web3 {
    public static void main(String[] args) {
        // String s = "aaaaabbbbb";
        // String t = "ab";
        // String s = "aabcbcd";
        // String t = "abc";
        // String s = "aabbcd";
        // String t = "abc";
        String s = "";
        String t = "a";

        Pattern pattern = Pattern.compile(t);
        int result = 0;
        String s_front;
        String s_end;
        Matcher matcher;
        while (true) {
            matcher = pattern.matcher(s);
            if (matcher.find() == false) {
                break;
            }
            s_front = s.substring(0, matcher.start());
            s_end = s.substring(matcher.end(), s.length());
            s = s_front + s_end;
            result++;
        }
        if (result == 0) {
            result = -1;
        }
        System.out.println(result);
    }
}
