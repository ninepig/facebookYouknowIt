package fbMianjing;

/**
 * Created by yangw on 2019/7/17.
 */
public class leftMostOne {
    /**

     * @param arr: The 2-dimension array

     * @return: Return the column the leftmost one is located

     */
//    NLOGN
    // M+N
    public int getColumn(int[][] arr) {

        // Write your code here
        int minCol = Integer.MAX_VALUE;

        for (int[] row:arr) {

            int start = 0;

            int end = row.length - 1;

            while (start + 1 < end) {

                int mid = start + (end - start) / 2;

                if (row[mid] == 1) {

                    end = mid;

                } else {
                    start = mid;
                }
            }

            if (row[start] == 1) {

                return start;

            } else {

                if (row[end] == 1) {

                    minCol = Math.min(minCol, end);

                }

            }

        }
        return minCol;
    }
//o(m+n) 先找到有1的第一行，然后从这一行的最右侧往下找，如果下面是一 往左移，不是一继续往下找

    static int findLeftMostOne(int[][]matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return -1;
        }
        int firstRowHasOne = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0;i<matrix.length;i++){
            if (matrix[i][matrix[0].length-1]==1){
                firstRowHasOne = i;
                break;
            }
        }
//        System.out.println("first"+firstRowHasOne);
        if(firstRowHasOne==-1){
            return -1;
        }

        for (int j = firstRowHasOne;j<matrix.length;j++){
            for (int k  = matrix[0].length-1;k>=0;k--){
                if(matrix[j][k]==1){
                    res = Math.min(k,res);
                }else {
                    break;
                }
            }
        }
        return res;
    }
}
