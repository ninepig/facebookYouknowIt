package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/7/10.
 *  *我们可以更加巧妙的利用偏移字符串的特点，那就是字符串的每个字母和首字符的相对距离都是相等的，
 * 比如abc和efg互为偏移，对于abc来说，b和a的距离是1，c和a的距离是2，对于efg来说，f和e的距离是1，g和e的距离是2。
 * 再来看一个例子，az和yx，z和a的距离是25，x和y的距离也是25(直接相减是-1，这就是要加26然后取余的原因)，那么这样的话，
 * 所有互为偏移的字符串都有个unique的距离差，我们根据这个来建立映射就可以很好的进行单词分组了，这个思路真实太赞了
 * 利用offset 的字符串作为key
 */
public class goupStringShifting {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return null;
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for (String str : strings){
            String encode = encode(str);
            if(map.containsKey(encode)){
                map.get(encode).add(str);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(encode,newList);
            }
        }
        for (String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
     }
     String encode(String input){
        if (input.length() == 1){
            return "-1";
        }
        StringBuilder sb = new StringBuilder(input);
        for (int i = 1 ; i < sb.length() ; i++){
            int offset = (input.charAt(i) + 26 - input.charAt(i-1))%26;
            sb.append(offset);
        }
        return sb.toString();
     }
}