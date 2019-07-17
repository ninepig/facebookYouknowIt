package fbMianjing;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/11.
 */
public class simplifyPath {
    public String simplifyPath(String path) {
        if(path == null|| path.length()==0){
            return path;
        }
        Stack<String> stack = new Stack();

        String[] split = path.split("/+");

        for(String s: split){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.equals(".")&&!s.equals("")){
                stack.push(s);
            }
        }

        String res ="";
        while(!stack.isEmpty()){
            res = "/"+stack.pop()+res;
        }

        return res.length()==0?"/":res;
    }
}
