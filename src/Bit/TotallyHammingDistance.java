package Bit;

/**
 * Created by yangw on 2019/7/8.
 *  * hamming distance 可以等于 每一位的0 和 1 的总数相乘，所以只要循环32次，每次计算一位的0 和 1 的数量。
 * 计算pairs 总和即可
 * 分别观察每一位，比如所有数的最后一位，假设有m个1，n个0， 那么这一位产生的海明距离之和应该为 m * n（易证）
 */
public class TotallyHammingDistance {
    public int totallyHammingDistance(int[] nums){
        int total = 0 , n = nums.length;
        for (int i = 0 ; i <32;i++){
            int bitCount = 0;
            for (int j = 0 ; j < n ; j++){
                // 计算几位bit
                bitCount += (nums[j]>>i)&1;
            }
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
