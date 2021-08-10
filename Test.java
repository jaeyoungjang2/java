import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[4];
        a[0] = 1;
        System.out.println(Arrays.toString(a));
        int[] copy = new int[4];
        copy = a.clone();
        copy[0] = 4;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(copy));

    }
}
