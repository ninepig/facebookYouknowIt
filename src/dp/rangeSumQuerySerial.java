package dp;

/**
 * Created by yangw on 2019/7/16.
 */
public class rangeSumQuerySerial {
    // Immutalable Array
    class NumArray {

        int[] sum;
        public NumArray(int[] nums) {
            if(nums==null||nums.length==0){
                return;
            }
            sum = new int[nums.length];
            sum[0] = nums[0];
            for(int i = 1; i<nums.length;i++){
                sum[i] = sum[i-1]+nums[i];
            }

        }

        public int sumRange(int i, int j) {

            return i==0 ? sum[j] : sum[j]-sum[i-1];
        }
    }

    class NumMatrix {

        private int[][] dp;
        public NumMatrix(int[][] matrix) {
            if(   matrix           == null
                    || matrix.length    == 0
                    || matrix[0].length == 0   ){
                return;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            dp = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int iMin = Math.min(row1, row2);
            int iMax = Math.max(row1, row2);

            int jMin = Math.min(col1, col2);
            int jMax = Math.max(col1, col2);

            return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
        }
    }

    class NumArrayM {
        private int[] tree;
        private int[] nums;
        public NumArrayM(int[] nums) {
            this.tree = new int[nums.length+1];
            this.nums = new int[nums.length];
            for(int i=0; i<nums.length; i++) update(i, nums[i]);
        }

        void adjust(int i, int val) {
            i ++;
            while (i<tree.length) {
                tree[i] += val;
                i += (i & -i);
            }
        }
        void update(int i, int val) {
            int adjust = val - nums[i];
            nums[i] = val;
            adjust(i, adjust);
        }

        int sum(int i) {
            i ++;
            int sum = 0;
            while (i>0) {
                sum += tree[i];
                i -= (i & -i);
            }
            return sum;
        }
        public int sumRange(int i, int j) {
            return sum(j)-sum(i-1);
        }
    }

//    O(M∗N)
    public class NumMatrixM {
        int[][] tree;
        int[][] nums;
        int m;
        int n;

        public NumMatrixM(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m+1][n+1];
            nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }
        public void update(int row, int col, int val) {
            if (m == 0 || n == 0) return;
            int delta = val - nums[row][col];
            nums[row][col] = val;
            // i + i & (-i) 代表着包含这个点的下一个树
            for (int i = row + 1; i <= m; i += i & (-i)) {
                for (int j = col + 1; j <= n; j += j & (-j)) {
                    tree[i][j] += delta;
                }
            }
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (m == 0 || n == 0) return 0;
            return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
        }

        public int sum(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= i & (-i)) {
                for (int j = col; j > 0; j -= j & (-j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }
    }
}
