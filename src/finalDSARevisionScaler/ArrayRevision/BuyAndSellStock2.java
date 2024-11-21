package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q51)
 * Given an array prices[] of size n denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.
 * Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.
 */
public class BuyAndSellStock2 {

    /*
    This is two pointer approach for buy and sell
     */
    public int maximumProfit(int[] prices) {
        int n = prices.length;
        int lMin = prices[0];  // Local Minima
        int lMax = prices[0];  // Local Maxima
        int res = 0;

        int i = 0;
        while (i < n - 1) {

            // Find local minima
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            lMin = prices[i];

            // Local Maxima
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            lMax = prices[i];

            // Add current profit
            res += (lMax - lMin);
        }

        return res;
    }

    public static void main(String[] args) {
        BuyAndSellStock2 bs = new BuyAndSellStock2();

        int A[] = {100, 180, 260, 310, 40, 535, 695};
        int ans = bs.maximumProfit(A);
        System.out.println(ans);
    }
}
