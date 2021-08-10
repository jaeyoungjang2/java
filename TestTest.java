import java.util.Arrays;

public class TestTest {
    public static void main(String[] args) {
        int[][] info = new int[2][2];
        info[0][0] = 1;
        info[0][1] = 1;
        info[1][0] = 1;
        info[1][1] = 1;
        int[][] copy = new int[2][2];
        for (int i = 0; i < 2; i++) {
            copy[i] = info[i].clone();
        }
        // copy = info.clone();
        copy[0][0] = 2;
        copy[0][1] = 2;
        copy[1][0] = 2;
        copy[1][1] = 2;
        System.out.println(Arrays.toString(info[0]));
        System.out.println(Arrays.toString(info[1]));
    }
}
