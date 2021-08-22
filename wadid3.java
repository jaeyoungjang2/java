import java.util.Arrays;

public class wadid3 {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 4, 8, 4, 2, 1 };
        // int[] arr = { 1, 3, 5, 7, 6, 8, 9, 5, 1 };
        int[] arr = { 10, 0, 10, 0, 10, 0 };

        int[] res = new int[arr.length];
        int minNumber = 1;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (res[i] == arr[i]) {
                continue;
            } else {
                answer++;
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] < arr[i]) {
                        break;
                    } else {
                        res[j] = arr[i];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
