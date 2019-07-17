package dp;

import java.util.Arrays;

/**
 * Created by yangw on 2019/7/2.
 */
public class coinChange {
    public int coinChangeBFS(int[] coins , int amount){
        if(amount < 1) return 0;
        // initial state
        int[] dp = new int[amount + 1];
        int sum = 0 ;
        while (++sum <= amount){
            int min = -1;
            for (int coin : coins){
                if(sum >= coin && dp[sum - coin] != -1){
                    int temp = dp[sum - coin] + 1;
                    // if min never be set, use temp value otherwise get the smaller value.
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0; i<=amount; i++){
            if(dp[i]==Integer.MAX_VALUE){
                continue;
            }

            for(int coin: coins){
                if(i<=amount-coin){ //handle case when coin is Integer.MAX_VALUE
                    // Translate : dp[i+coin] = dp[i] + one coin or it is original
                    dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];
    }
}
