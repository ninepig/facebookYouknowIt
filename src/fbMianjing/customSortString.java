package fbMianjing;

/**
 * Created by yangw on 2019/7/10.
 * 和verifying alien dictionay 有异曲同工之妙
 * S has length at most 26, and no character is repeated in S.
 * 统计t的count数量 按照s的顺序来。
 */
public class customSortString {
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) return null;
        int[] map = new int[26];
        for (char c :T.toCharArray() ){
            map[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (char c: S.toCharArray()){
            while (map[c - 'a']-- > 0){
                res.append(c);
            }
        }
        // normal order
        for (char c = 'a'; c <= 'z' ;c++){
            while (map[c - 'a']-->0){
                res.append(c);
            }
        }
        return  res.toString();
    }
}
