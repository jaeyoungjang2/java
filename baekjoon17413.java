import java.util.Scanner;

public class baekjoon17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;

        String tempString = "";
        for (int i = 0; i < inputString.length(); i++) {
            Character tempCharacter = inputString.charAt(i);
            if (tempCharacter.equals(' ') && !isTag) {
                sb.append(makeReverseString(tempString) + ' ');
                tempString = "";
                continue;
            } else if (tempCharacter.equals('<')) {
                sb.append(makeReverseString(tempString));
                tempString = "";
                isTag = true;
                sb.append('<');
                continue;
            } else if (tempCharacter.equals('>')) {
                isTag = false;
                sb.append(tempString);
                sb.append('>');
                tempString = "";
                continue;
            }
            tempString += tempCharacter;
        }
        if (tempString.length() > 0) {
            sb.append(makeReverseString(tempString));
        }
        System.out.println(sb);
    }

    static String makeReverseString(String tempString) {
        String reverseString = "";
        for (int i = tempString.length() - 1; i >= 0; i--) {
            reverseString += tempString.charAt(i);
        }
        return reverseString;
    }
}
