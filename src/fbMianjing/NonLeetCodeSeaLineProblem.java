package fbMianjing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/7/17.
 */
public class NonLeetCodeSeaLineProblem {
/**
 * ，第一题是给你一堆楼房高度整数数组，海在最右边。有的楼房能看到海，有的被挡住了就不能，最后返回能看到海的下标。
 * 不知道有没有人见过原题。楼主想不出来于是暴力解。然后跟我说代码有错误，想了半天发现原来相同高度也是看不到的。
 * 于是面试官问能否一次扫描解决。我说在想有没有什么数据结构可以做，面试官说不用，解不出来，还请大神指教了。
 *
 * 用stack就行。从左往右扫。栈顶遇到高的就pop。遇到低的直接放入。最后栈里元素就是答案
 */
    public List<Integer> seeShareSide(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < a.length) {
            if (stack.isEmpty() || a[stack.peek()] > a[i]) {
                stack.push(i++);
            } else {
                while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                    stack.pop();
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
