package examsTest.week8;

import java.util.*;

/**
 * @program: algorithm
 * @description: 高频字母
 * @author: wuzheb
 * @create: 2020-07-28 00:38
 **/
public class FrequentKWord {



    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) ->
                map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b)
        );

        for (String key : map.keySet()) {
            // if (pq.size() < k) {
            //     pq.offer(key);
            // } else if (map.get(key) >= map.get(pq.peek())) {
            //     pq.poll();
            //     pq.offer(key);
            // }
            pq.offer(key);

            if (pq.size() > k) pq.poll();
        }

        List<String> res = new LinkedList();

        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }

        Collections.reverse(res);

        return res;
    }
}

