package binarySearch;

/**
 * Created by yangw on 2019/7/9.
 * 这道题非常经典，主要是lc上case太多，其他的还好。核心算法是helperfunction
 */
public class DivideTwoInteger {
    public int divide(int diveend, int divisor){
        if (diveend == 0) return 0;
        int sign = 1;
        if (diveend > 0 && divisor <0){
            sign = -1;
        }
        if (diveend < 0 && divisor > 0) {
            sign = -1;
        }
        long dend = Math.abs((long)diveend);
        long dsor = Math.abs((long)divisor);

        long ans = getAnswer(dend,dsor);
        int res = 0;
        if (ans > Integer.MAX_VALUE){
            res = sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else {
            res = sign * (int)res;
        }
        return res;
    }
   // any number can be 1 +2 + 4+ 8 + 16 .....
    private long getAnswer(long dend, long dsor) {
        if (dend < dsor){
            return 0;
        }
        long sum = dsor;
        long mult = 1;
        while ((sum + sum) < dend){
            sum += sum;
            mult += mult;
        }
        return mult + getAnswer(dend,dsor);
    }


}
