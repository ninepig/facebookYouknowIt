package Array;

/**
 * Created by yangw on 2019/7/2.
 * /*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 */

public class rotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int length = matrix.length;
        // Vertical flip
        // key is just flip to half.
        for(int i = 0 ; i < length/2; i++){
            for(int j = 0 ; j < length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][j];
                matrix[length-1-i][j] = temp;
            }
        }

        // Symmetry flip
        for(int i = 0 ; i < length ; i++){
            // Key is j = i.
            for(int j = i ; j < length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
