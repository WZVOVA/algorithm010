package examsTest.week2;

import java.util.*;

/**
 * @program: algorithm
 * @description: 前k个频率大的元素
 * @author: wuzheb
 * @create: 2020-06-21 00:14
 **/
public class TheFrequentestKElement {

    /**
     * @Author             wuzhen
     * @Description         大顶堆方案，存储键值对，然后取出前k个，优先队列构建要O(n)，取出要klog(n)，综合为O(n)时间复杂度，O(n)的空间复杂度
     * @Date              2020/6/21 0:16
     * @Param             [nums, k]
     * @return            int[]
     */

    public int[] topKFrequent1(int[] nums, int k) {


        if (nums.length == 1) return nums;
        if (nums.length == 0) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((v1, v2) -> v2.getValue() - v1.getValue());

        while (entries.hasNext()) {
            queue.offer(entries.next());
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> currentEntry = queue.poll();
            ans[i] = currentEntry.getKey();
        }


        return ans;

    }

    /**
     * @Author             wuzhen
     * @Description        小顶堆法
     * @Date              2020/6/21 0:37
     * @Param             [nums, k]
     * @return            int[]
     */
    public int[] topKFrequent2(int[] nums, int k) {


        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1, b1) -> map.get(a1) - map.get(b1));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素

        int[] res = new int[k];

        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }

        return res;



    }
}
