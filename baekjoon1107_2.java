import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer> brokenButtoninfo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int n = sc.nextInt();
        brokenButtoninfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            brokenButtoninfo.add(sc.nextInt());
        }

        int res = Math.abs(100 - num);
        int plusNum = num;
        int minusNum = num;
        int channel = 1000000;

        while (true) {
            if (Math.min(Math.abs(plusNum - num), Math.abs(num - minusNum)) > res) {
                break;
            }
            if (plusNum <= 1_000_000 && isContainBrokenButton(plusNum)) {
                channel = plusNum;
                break;
            }
            if (minusNum >= 0 && isContainBrokenButton(minusNum)) {
                channel = minusNum;
                break;
            }
            plusNum += 1;
            minusNum -= 1;
        }
        int length = Integer.toString(channel).length();
        if (res > Math.abs(channel - num) + length) {
            res = Math.abs(channel - num) + length;
        }
        System.out.println(res);
    }

    private static boolean isContainBrokenButton(Integer buttonInfo) {
        String[] buttons = Integer.toString(buttonInfo).split("");
        for (String button : buttons) {
            if (brokenButtoninfo.contains(Integer.parseInt(button))) {
                return false;
            }
        }
        return true;
    }
}


