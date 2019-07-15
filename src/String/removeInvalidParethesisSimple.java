package String;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/11.
 */
public class removeInvalidParethesisSimple {
    public String removeInvalid(String input) {
        if (input == null || input.length() == 0){
            return input;
        }
        StringBuilder sb  = new StringBuilder(input);
        int left = 0;
        for (int i = 0 ; i < sb.length(); i++){
            if (sb.charAt(i) == '('){
                left++;
            }else if (sb.charAt(i) == ')'){
                if (left == 0){
                    sb.deleteCharAt(i);
                }else {
                    left--;
                }
            }
        }
        int right = 0;
        for (int i = sb.length() - 1 ; i >= 0 ; i--){
            if (sb.charAt(i) == ')'){
                right++;
            }else if(sb.charAt(i) == '('){
                if (right == 0){
                    sb.deleteCharAt(right);
                }else {
                    right--;
                }
            }
        }
        return sb.toString();
    }
    // 把所有illegal的position 记录下来
    public static String removeInvalidOnePass(String input) {
        if (input == null || input.length() == 0) return input;
        Stack<Integer> s = new Stack<>();
        for (int i = 0 ; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '('){
                s.push(i);
            }else if (c == ')'){
                if (s.isEmpty()||input.charAt(s.peek())!='('){
                    s.push(i);
                }else {
                    s.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder(input);
        while (!s.isEmpty()){
            sb.deleteCharAt(s.pop());
        }
        return sb.toString();
    }
}
