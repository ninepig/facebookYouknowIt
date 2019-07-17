package dp;

/**
 * Created by yangw on 2019/7/2.
 */
public class editDistance {
    public int minDistance(String word1, String word2) {
        if(word1==null&&word2==null){
            return 0;
        }
        //state:
        int lengthA = word1.length();
        int lengthB = word2.length();
        int[][] minDistance = new int[lengthA+1][lengthB+1];

        //initial
        for(int i = 0; i <= lengthA;i++){
            minDistance[i][0] = i;
        }
        for (int j = 0 ; j<= lengthB;j++){
            minDistance[0][j] = j;
        }

        //state transfer
        /*
        Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

        f(i, j) = f(i - 1, j - 1)

        Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

        f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }

        f(i, j - 1) represents insert operation
        f(i - 1, j) represents delete operation
        f(i - 1, j - 1) represents replace operation
         */
        for(int i = 1 ; i <= lengthA;i++){
            for (int j = 1 ; j <= lengthB ; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    minDistance[i][j] = minDistance[i-1][j-1];
                }else {
                    minDistance[i][j] = Math.min(minDistance[i-1][j-1],Math.min(minDistance[i-1][j],minDistance[i][j-1]))+1;
                }
            }
        }

        return minDistance[lengthA][lengthB];
    }
}
