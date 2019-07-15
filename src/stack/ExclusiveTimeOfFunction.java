package stack;

import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/7/11.
 */
public class ExclusiveTimeOfFunction {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0){
            return new int[]{};
        }
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        //start time of interval
        int pre = 0;
        for (String log : logs){
            String[] arr = log.split(":");
            if (arr[1].equals("start")){
                if (!st.isEmpty()) {
                    // update previous command's time , then push the current command
                    res[st.peek()] += Integer.parseInt(arr[2]) - pre;
                }
                    st.push(Integer.parseInt(arr[0]));
                    pre = Integer.parseInt(arr[2]);
            }else {
                // if it is end , we finallized the command's end time , update time slot.
                res[st.pop()] += Integer.parseInt(arr[2]) - pre +1;
                pre = Integer.parseInt(arr[2])+1;
            }
        }
        return res;
    }
}
