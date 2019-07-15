package dp;

/**
 * Created by yangw on 2019/7/14.
 */
public class stockSerial {
    //One transcation
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int lowest = prices[0];
        for (int i = 1 ; i < prices.length ; i++){
            if (prices[i] <= lowest){
                lowest = prices[i];
            }else
                max = Math.max(max, prices[i] - lowest);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0 ;
        for(int i = 1 ; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }


    public int maxProfitTwoTransaction(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    // DP
    /*
     如果 交易次数大于一半，则和2 一样
     反之，利用dp来做
     dp是二维数组，

     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    /*
     2个数组 维护买以及卖以后手上钱的情况
     */
    public int maxProfitTranscationFee(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int days = prices.length, buy[] = new int[days], sell[] = new int[days];
        buy[0]=-prices[0]-fee;
        for (int i = 1; i<days; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee); // keep the same as day i-1, or buy from sell status at day i-1
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]); // keep the same as day i-1, or sell from buy status at day i-1
        }
        return sell[days - 1];
    }
}
