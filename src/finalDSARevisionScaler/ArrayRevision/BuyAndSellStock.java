package src.finalDSARevisionScaler.ArrayRevision;

/**
 * Q50)Given an array prices[] of length N, representing the prices of the stocks on different days,
 * the task is to find the maximum profit possible by buying and selling the stocks on different days
 * when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell.
 * Note: Stock must be bought before being sold.
 */
public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min_price = prices[0];
        int max_profit = 0;
        for (int i =1; i < prices.length;i++){
            min_price = Math.min(min_price,prices[i]);

            max_profit = Math.max(max_profit,prices[i]-min_price);
        }
        return max_profit;
    }

    public static void main(String[] args) {
        BuyAndSellStock bs = new BuyAndSellStock();

        int A[] = {7, 10, 1, 3, 6, 9, 2};
        int ans = bs.maxProfit(A);
        System.out.println(ans);

    }
}
