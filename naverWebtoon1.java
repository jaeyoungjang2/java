import java.util.*;

public class naverWebtoon1 {
    public static void main(String[] args) {
        // int[] prices = { 32000, 18000, 42500 };
        // int[] discounts = { 50, 20, 65 };
        int[] prices = { 13000, 88000, 10000 };
        int[] discounts = { 30, 20, 0, 0 };

        int newPrice;
        int currPrice;
        // discounts를 다 적용할 때 까지
        Arrays.sort(discounts);
        Arrays.sort(prices);
        int index = 0;
        int disProduct = 0;
        for (int i = discounts.length - 1; i >= 0; i--) {
            if (disProduct == prices.length) {
                break;
            }
            currPrice = prices[prices.length - 1 - index];
            newPrice = currPrice - (currPrice * discounts[i] / 100);
            prices[prices.length - 1 - index] = newPrice;
            index++;
            disProduct++;
        }

        int totalPrice = 0;
        for (int i : prices) {
            System.out.println(i);
            totalPrice += i;
        }
        System.out.println(totalPrice);
    }
}
