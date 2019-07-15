package String;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/10.
 * 最小的添加数量 让parethesis valid
 * 用一个stack 以及一个count 来做
 * 如果先出现( 那就push ，出现） 如果stack是空的 那就要加一个count
 * 如果不为空则pop 出(
 * 最后统计stack得size 以及count得数量即可
 */
public class minAddToMakeValidParethesis {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;
        int count = 0;
        Stack<Character> s= new Stack();
        for (int i = 0 ; i < S.length() ; i++){
            if (S.charAt(i) == '('){
                s.push('(');
            }else if (S.charAt(i) == ')'){
                if (s.isEmpty()){
                    // illegal for right )
                    count++;
                }else {
                    s.pop();
                }
            }
        }
        return s.size() + count;
    }
}
