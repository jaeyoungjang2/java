import java.util.HashMap;
import java.util.*;

public class naverWeb1 {
    public static void main(String[] args) {
        int[][] v = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
        HashMap<Integer, Integer> mapX = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapY = new HashMap<Integer, Integer>();

        for (int i = 0; i < v.length; i++) {
            mapX.put(v[i][0], 0);
            mapY.put(v[i][1], 0);
        }

        for (int i = 0; i < v.length; i++) {
            mapX.put(v[i][0], mapX.get(v[i][0]) + 1);
            mapY.put(v[i][1], mapY.get(v[i][1]) + 1);
        }

        int x1 = 0;
        int y1 = 0;

        for (int i = 0; i < v.length; i++) {
            if (mapX.get(v[i][0]) == 1) {
                System.out.println("HI");
                x1 = v[i][0];

            }
            if (mapY.get(v[i][1]) == 1) {
                System.out.println("HBYE");
                y1 = v[i][1];

            }
        }

        int[] answer = { x1, y1 };
    }
}
