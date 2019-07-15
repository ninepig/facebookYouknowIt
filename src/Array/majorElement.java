package Array;

/**
 * Created by yangw on 2019/7/13.
 * voting 算法
 */
public class majorElement{
    // 简单的就是排序，取中间数
    // voting 算法
    public int majorityElement(int[] num) {
        int major = num[0], count = 1;
        for ( int i = 1 ; i< num.length ;i++){
            if(count == 0){
                count++;
                major = num[i];
            }else if (major == num[i]) count++;
            else count--;
        }
        return major;
    }
}
