package binarySearch;

/**
 * Created by yangw on 2019/7/10.
 */
public class sqrt {
    int mySqrt(int n){
        if(n <= 0) return 0;
        double l = 0 , r = n;
        while (l + 1 < r){
            double mid = l + (r - l )/2;
            if (mid*mid == n){
                return (int) mid;
            }else if (mid * mid < n){
                l = mid ;
            }else{
                r = mid ;
            }
        }
        if (l * l < n){
            return (int) r;
        }else{
            return (int)l;
        }
    }
}
