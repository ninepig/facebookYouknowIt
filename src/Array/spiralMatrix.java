package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/17.
 */
public class spiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> res = new ArrayList<>();
            if(matrix == null || matrix.length == 0) return res;

            int rowBegin = 0 , colounmBegin = 0, rowEnd = matrix.length - 1 , coloumEnd = matrix[0].length - 1;

            while (rowBegin <= rowEnd && colounmBegin <= coloumEnd){
                // Travel to right!
                for (int i = colounmBegin ; i <= coloumEnd ; i++){
                    res.add(matrix[rowBegin][i]);
                }
                rowBegin++;

                // Travel to down!
                for (int i = rowBegin ; i <= rowEnd ; i++){
                    res.add(matrix[i][coloumEnd]);
                }
                coloumEnd--;

                // Travel to left!
                if (rowBegin <= rowEnd) {
                    for (int i = coloumEnd; i >= colounmBegin; i--) {
                        res.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd--;

                // Travel to up!
                if (colounmBegin <= coloumEnd) {
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        res.add(matrix[i][colounmBegin]);
                    }
                    colounmBegin++;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int value = 1;
            int left = 0 , right = n-1, top = 0 , bottom = n-1;
            while(left < right && top < bottom){
                for(int i = left ; i < right ; i++) res[top][i] = value++;
                for(int i = top ; i < bottom ; i++) res[i][right] = value++;
                for(int i = right ; i > left ; i-- ) res[bottom][i] = value++;
                for(int i = bottom; i > top ; i--) res[i][left] = value++;
                left++;
                right--;
                top++;
                bottom--;
            }
            if(n%2 != 0) res[n/2][n/2] = value;
            return res;
        }
    }
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        if (r0 < 0 || r0 >=R || c0 < 0 || c0 >= C) return new int[][]{};
        int[][] dirt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // east, south, west, north
        List<int[]> res = new ArrayList<>();
        int len = 0, d = 0; // move <len> steps in the <d> direction
        res.add(new int[]{r0, c0});
        while (res.size() < R * C) {
            if (d == 0 || d == 2) len++; // when move east or west, the length of path need plus 1
            for (int i = 0; i < len; i++) {
                r0 += dirt[d][0];
                c0 += dirt[d][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) // check valid
                    res.add(new int[]{r0, c0});
            }
            d = (d + 1) % 4; // turn to next direction
        }
        return res.toArray(new int[R * C][2]);
    }
}
