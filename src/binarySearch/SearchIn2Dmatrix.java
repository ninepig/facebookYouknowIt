package binarySearch;

/**
 * Created by yangw on 2019/7/10.
 * 矩阵， 利用二分特性，画图做。 利用sort 特性
 * i/ii 两题一个吊样。没区别
 */
public class SearchIn2Dmatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int y = 0 , x = matrix.length - 1;
        while (x >= 0 && y < matrix[0].length){

            if (matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                y++;
            }else {
                x--;
            }
        }
        return false;
    }

}
