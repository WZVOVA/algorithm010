package examsTest.week8;

import java.util.BitSet;

/**
 * @program: algorithm
 * @description: 布隆过滤器
 * @author: wuzheb
 * @create: 2020-08-02 23:53
 **/
//Java
public class BloomFilter {
    private static final int DEFAULT_SIZE = 2 << 24;
    // 哈希种子

    private static final int[] seeds = new int[] { 5, 7, 11, 13, 31, 37, 61 };

    private BitSet bits = new BitSet(DEFAULT_SIZE);

    // 存放哈希函数

    private SimpleHash[] func = new SimpleHash[seeds.length];

    // 初始化哈希函数
    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }
    public void add(String value) {

        // 一个值有6个位置，6个下标值为1
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    // 判断，如果6个位置都是1通过，如果有一个不存在在，说明不存在。
    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }
    // 内部类，simpleHash 获得哈希值
    public static class SimpleHash {
        // 容量
        private int cap;
        // 哈希种子
        private int seed;
        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        //哈希函数
        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                // 对每一个字符进行运算， 获得每个字符ASCII值，第一个是ASCII值，第二个是种子和上一个的相乘然后加上第二个。
                result = seed * result + value.charAt(i);
            }

            // 最后结果再和容量与运算获得其中一个下标位置。
            return (cap - 1) & result;
        }
    }
}
