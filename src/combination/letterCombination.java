package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/9.
 */
public class letterCombination {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return  null;
        List<String> res = new ArrayList<>();
        String[] map = {"","","abc","cde","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(0,new StringBuffer(),map,digits,res);
        return res;
    }

    private void helper(int pos, StringBuffer stringBuffer, String[] map, String digits, List<String> res) {
        if (stringBuffer.length() >= digits.length()){
            res.add(stringBuffer.toString());
        }else{
            char[] thisLevel = map[Character.getNumericValue(digits.charAt(pos))].toCharArray();
            for (char oneChar : thisLevel){
                stringBuffer.append(oneChar);
                helper(pos+1,stringBuffer,map,digits,res);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }
    }

}
