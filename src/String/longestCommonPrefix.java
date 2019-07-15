package String;

/**
 * Created by yangw on 2019/7/10.
 * 用第一个string和剩下的所有比。其实都是一样的
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length ==0)
            return "";
        int index = 0;
        StringBuilder sb = new StringBuilder();
        boolean ifTrue = true;
        while (ifTrue && index < strs[0].length()){
            for (int i = 0 ; i<strs.length ; i++){
                if (strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)){
                    ifTrue = false;
                    break;
                }
            }
            if (ifTrue){
                sb.append(strs[0].charAt(index));
                index++;
            }
        }
        return sb.toString();
    }
}
