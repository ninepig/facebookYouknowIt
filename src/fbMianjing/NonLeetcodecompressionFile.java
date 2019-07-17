package fbMianjing;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/17.
 */
public class NonLeetcodecompressionFile {
/*

上来一个印度小哥，简单2分钟的寒暄就上题了
说有一串数组代表文件大小（A）， 还有一串数组代表这些文件被压缩后的大小（B）， 其中A和B的元素数目相同。 还有一个数组S，代表想最终处理后所有文件的大小，包括有些文件压缩，有些文件不压缩。
求问最少压缩几个文件能达到所有文件大小为S？

A = [12, 16, 30]
B = [4,   15,  3 ]
S= 30

在这个题里面我们的输出是2，因为我们需要压缩A[2]->B[2] = 30 -> 3, 节省27个单位的大小，再压缩A[1]->B[1] = 16 -> 15，节约了1个单位的大小. From 1point 3acres bbs
所以最终的结果就是output[12, 15, 3] = 12 + 15 +3 = 30(S的大小）
 */
    //    我会用max heap来做，其中的元素是A与B的差。
// 步骤如下：1）算出A中所有元素的加和cur_sum；
// 2）while 循环判断cur_sum是否大于S，若是，则从最大堆中取出最大值m，cur_sum-=m

public int minFileNumberToCompressFile(int[] A , int[] B , int k) {
    if(A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length || k  <= 0) return -1;
    // MaxHeap
    PriorityQueue<Integer> pq = new PriorityQueue<>(A.length,(a,b)->(b - a ));
    int curSum = 0;
    for (int i = 0 ; i < A.length ; i++){
        pq.offer(A[i]-B[i]);
        curSum += A[i];
    }
    int res = 0;
    while (curSum > k && !pq.isEmpty()){
        curSum -= pq.poll();
        res++;
    }
    if (curSum > k){
        return -1;
    }
    return res;
}

}
