package dp;

/**
 * Created by yangw on 2019/7/2.
 */
public class uniquePath {
    public int uniquePaths(int m, int n) {
        if(m==1&&n==1){
            return 1;
        }
        //initial state
        int[][] dp = new int[m][n];

        //initial
        for(int i = 0; i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j<n;j++){
            dp[0][j] = 1;
        }

        //state transfer
        for(int i = 1 ; i<m;i++){
            for (int j = 1 ; j< n ; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0){
            return 0;
        }
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] sumPath = new int[height][width];

        for(int i = 0;i<height;i++){
            if(obstacleGrid[i][0]!=1){
                sumPath[i][0]=1;
            }else {
                break;
            }
        }
        for(int i = 0;i<width;i++){
            if(obstacleGrid[0][i]!=1){
                sumPath[0][i]=1;
            }else {
                break;
            }
        }

        for(int i = 1 ; i <height ; i++){
            for(int j = 1;j<width;j++){
                if(obstacleGrid[i][j]!=1){
                    sumPath[i][j]= sumPath[i-1][j]+sumPath[i][j-1];
                }else {
                    sumPath[i][j]=0;
                }
            }
        }

        return sumPath[height-1][width-1];
    }
}
