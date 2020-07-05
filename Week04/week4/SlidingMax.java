package examsTest.week4;

import java.util.PriorityQueue;

/**
 * @program: algorithm
 * @description: 滑动窗口最大值
 * @author: wuzheb
 * @create: 2020-07-03 23:35
 **/
public class SlidingMax {



    public int[] maxSlidingWindow(int[] nums, int k) {

        // 终止条件

        if (nums.length == 0 || k == 0) return new int[0];

        // proces logic


        // 结果数组

        int[] res = new int[nums.length - k + 1];

        // 需要一个数据结构保存滑动窗口的值
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a1, a2) -> a2 -a1);

        // 遍历整个数组

        for (int i = 0; i < nums.length; i++) {
            int start = i - k;
            // 前k个数内不断叠加,之后每次删除第一次压入的数
            if (start >= 0) {
                maxQ.remove(nums[start]);
            }

            maxQ.offer(nums[i]);

            if (maxQ.size() == k) {
                res[i-k+1] = maxQ.peek();
            }
        }

        return res;
    }


    public static void main(String[] args) {


        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingMax slidingMax = new SlidingMax();

        for (int i = 0; i < slidingMax.maxSlidingWindow(nums, 3).length; i++) {

            System.out.println(slidingMax.maxSlidingWindow(nums, 3)[i]);
        }
    }

}
