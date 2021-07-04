import java.util.ArrayList;
import java.util.Arrays;

public class naverWebtoon2 {
    public static void main(String[] args) {
        String[] answer = {};
        // String s = "abcxyasdfasdfxyabc";
        // String s = "abcxyqwertyxyabc";
        // String s = "abcabcabcabc";
        // String s = "llttaattll";
        // String s = "zzzzzz";
        // String s = "abcdef";
        // String s = "zzzzzzz";
        String s = "abcdabc";

        ArrayList<String> ary = new ArrayList<>();
        int index = 1;
        int endCycle;
        if (s.length() % 2 == 1) {
            endCycle = (s.length()) / 2;
        } else {
            endCycle = (s.length() + 1) / 2;
        }

        System.out.println(endCycle);
        int currCycle = 0;
        String s_front = "";
        String s_end = "";
        while (true) {
            if (currCycle == endCycle) {
                break;
            }
            s_front = s.substring(0, index);
            s_end = s.substring(s.length() - index, s.length());

            if (s_front.equals(s_end)) {
                System.out.println(s);
                ary.add(s_front);
                s = s.substring(index, s.length() - index);
                index = 0;
                s_front = "";
                s_end = "";
            }
            index++;
            currCycle++;
        }

        if (s_front.length() > 0 || s.length() > 0) {
            answer = new String[ary.size() * 2 + 1];
        } else {
            answer = new String[ary.size() * 2];
        }

        int count = 0;
        for (int i = 0; i < ary.size(); i++) {
            answer[i] = ary.get(i);
            count++;
        }
        if (s_front.length() > 0 && s.length() > 0) {
            if (s.equals(s_front + s_end)) {
                answer[count] = s_front + s_end;
                count++;
            } else {
                answer[count] = s_front + s + s_end;
                count++;
            }
        } else if (s_front.length() > 0) {
            answer[count] = s_front + s_end;
            count++;
        } else if (s.length() > 0) {
            answer[count] = s;
            count++;
        }

        for (int i = 0; i < ary.size(); i++) {
            answer[i + count] = ary.get(ary.size() - i - 1);
        }
        System.out.println(Arrays.toString(answer));
    }
}
