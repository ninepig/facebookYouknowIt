package dp;

/**
 * Created by yangw on 2019/7/2.
 * 1纬 dp， 保存到Sum的全部square数量
 * 初始化，全部是max
 * 如果可以直接平方， 就是 1
 * 如果不是则算
 * 状态转移是 自己看。
 */
public class perfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1 ; i<= n ;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1 ; i<=n ; i++){
            int sqrt = (int) Math.sqrt(i);
            if(sqrt*sqrt == i){
                dp[i] = 1 ;
                continue;
            }
            for(int j = 1 ; j <= sqrt ; j++){
                int dif = i - j*j;
                dp[i] = Math.min(dp[i],(dp[dif] + 1));
            }
        }
        return dp[n];
    }
}
