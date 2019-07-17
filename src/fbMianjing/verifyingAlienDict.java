package fbMianjing;

/**
 * Created by yangw on 2019/7/10.
 */
public class verifyingAlienDict {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0){
            return false;
        }
        int[] alienMap = new int[26];
        for (int i = 0 ; i < order.length() ; i++){
            alienMap[order.charAt(i)-'a'] = i;
        }

        for (int i = 1 ; i < words.length ; i++){
            if (compare(words[i-1],words[i],alienMap)>0){
                return false;
            }
        }
        return true;
    }

    private int compare(String word, String word1, int[] alienMap) {
        int n = word.length() , m = word1.length();
        int cmp = 0;
        for (int i = 0 , j = 0 ; i < n && j < m && cmp == 0 ; i++,j++){
            cmp = alienMap[word.charAt(i) - 'a'] - alienMap[word1.charAt(j)-'a'];
        }
        return cmp == 0 ? n - m : cmp;
    }
}
