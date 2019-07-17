package design;

import java.util.Random;
import java.util.TreeMap;

/**
 * Created by yangw on 2019/7/17.
 */

//[1,2,3]->{1:0, 3:1, 6:2}
//        Say if rnd=4, it should return 2, because ceiling(4)=6 in our map, whose corresponding index is 2.
public class randomPickWithWeight {
    int cnt=0;
    TreeMap<Integer, Integer> map= new TreeMap<>();
    Random rnd= new Random();
    public randomPickWithWeight(int[] w) {
        for (int idx=0; idx<w.length; idx++){
            cnt+=w[idx];
            map.put(cnt, idx);
        }
    }

    public int pickIndex() {
        // int key= map.ceilingKey(rnd.nextInt(cnt)+1); don't forget to +1, because rand.nextInt(cnt) generate random integer in range [0,cnt-1]
        int key= map.higherKey(rnd.nextInt(cnt));
        return map.get(key);
    }
}
