package examsTest.TestWork;

/**
 * @program: algorithm
 * @description: 加一输入
 * @author: wuzheb
 * @create: 2020-06-14 00:39
 **/
public class Addq {


    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/14 0:46
     * @Param             [digits]
     * @return            int[]
     */
    public int[] plus1 (int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            digits[i]++;

            digits[i] %= 10;

            if (digits[i] != 0) return digits;
        }

        digits = new int[digits.length + 1];

        digits[0] = 1;

        return digits;
    }
}
