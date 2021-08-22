import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class wadid2 {
    public static void main(String[] args) {
        String[] code = { "a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b",
                "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a" };

        Map<Integer, Stack<Integer>> blockIndexMap = new HashMap<>();
        Map<Integer, Stack<Integer>> blockValueMap = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            blockIndexMap.put(i, new Stack<>());
            blockValueMap.put(i, new Stack<>());
        }
        // System.out.println((int) 'b' - 97);

        for (String string : code) {
            System.out.println(string);
            int currentBlock = countChar(string, '.');
            boolean isPrint = isCmdPrint(string, "print");

            if (!isPrint) {
                int cmdIndex = string.indexOf("=") - 1;
                int numOfPop = 0;
                char cmd = string.charAt(cmdIndex);
                int cmdValue = Integer.parseInt(string.split("=")[1]);
                // 처음 들어오는 명령어 이거나, 하위 블락인 경우
                Stack<Integer> blockIndexStack = blockIndexMap.get((int) cmd - 97);
                Stack<Integer> blockValueStack = blockValueMap.get((int) cmd - 97);
                if (blockIndexStack.isEmpty() || blockIndexStack.peek() < currentBlock) {
                    blockIndexStack.add(currentBlock);
                    blockValueStack.add(cmdValue);
                    blockIndexMap.put((int) cmd - 97, blockIndexStack);
                    blockValueMap.put((int) cmd - 97, blockValueStack);
                } else if (blockIndexStack.contains(currentBlock) && blockIndexStack.peek() > currentBlock) {
                    while (blockIndexStack.peek() != currentBlock) {
                        blockIndexStack.pop();
                        blockValueStack.pop();
                    }
                }
            }

            if (isPrint) {
                String[] cmdStringArray = string.split(" ");
                char cmd = cmdStringArray[1].charAt(0);
                Stack<Integer> blockIndexStack = blockIndexMap.get((int) cmd - 97);
                Stack<Integer> blockValueStack = blockValueMap.get((int) cmd - 97);
                System.out.println(blockIndexStack.size());
                System.out.println(blockIndexStack);
                if (!blockIndexStack.contains(currentBlock)) {
                    System.out.println("error");
                } else if (blockIndexStack.peek() == currentBlock) {
                    System.out.println(blockValueStack.peek());
                } else if (blockIndexStack.peek() > currentBlock) {
                    while (blockIndexStack.peek() != currentBlock) {
                        blockIndexStack.pop();
                        blockValueStack.pop();
                    }
                    System.out.println(blockValueStack.peek());
                }
            }
        }
    }

    static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    static boolean isCmdPrint(String str, String ch) {
        return str.contains(ch);
    }
}
