package Array;

/**
 * Created by yangw on 2019/7/13.
 */
public class maxSwap {
    public int maximumSwap(int num) {
        char[] digist = Integer.toString(num).toCharArray();

        int[] bucket = new int[digist.length];

        // Using bucket to store each digist's index
        for ( int i = 0 ; i < digist.length ; i++){
            bucket[digist[i] - 'a'] = i;
        }

        for ( int i = 0 ; i < digist.length ;i++){
            // find a bigger number than i ,
            for (int k = 9 ; k > digist[i] - '0';k--){
                // once we found a k bigger than i and his index is bigger than i , swap them to get a bigger number
                if (bucket[k] > i){
                    char temp = digist[i];
                    digist[i] = digist[bucket[k]];
                    digist[bucket[k]] = temp;
                    return Integer.valueOf(new String(digist));
                }
            }
        }
        return num;
    }
}
