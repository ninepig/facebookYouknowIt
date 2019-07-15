package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/8.
 */
public class combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res, cur, 1, n, k);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int pos, int n, int k) {
        if (cur.size() == k){
            res.add(new ArrayList<>(cur));
        }else{
            for (int i = pos ; i <= n ; i++){
                cur.add(i);
                helper(res,cur,i+1,n,k);
                cur.remove(cur.size()-1);
            }
        }
    }
}
