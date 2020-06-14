package examsTest.TestWork;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 合并两个数组
 * @author: wuzheb
 * @create: 2020-06-13 23:39
 **/
public class MergeTwoArray {


    /**
     * 时间复杂度是（n + m）* lg(n+m)
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/13 23:54
     * @Param             [num1, m, num2, n]
     * @return            void
     */
    public void merge(int[] num1, int m, int[] num2, int n) {

        System.arraycopy(num2, 0, num1, m, n);

        Arrays.sort(num1);

    }

    /**
     * 节省空间的归并
     *
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/14 0:01
     * @Param             [num1, m, num2, n]
     * @return            void
     */
    public void merge1(int[] num1, int m, int[] num2, int n) {

        int m1 = m - 1;
        int n1 = n - 1;
        int end = m + n - 1;

        while (m1 >= 0 && n1 >= 0) {
            num1[end--] = num1[m1] < num2[n1] ? num2[n1--] : num1[m1--];
        }

        System.arraycopy(num2, 0, num1, 0, n1 + 1);
    }


    /**
     * 消耗空间的归并
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/14 0:02
     * @Param             [num1, m, num2, n]
     * @return            void
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] copyNums1 = new int[m];
        System.arraycopy(nums1,0 , copyNums1, 0, m);

        int p1 = 0, p2 = 0, p = 0; // p1 对应复制num1，p2 对应num2，p是num1

        while ((p1 < m) && (p2 < n))
            nums1[p++] = copyNums1[p1] < nums2[p2] ? copyNums1[p1++] : nums2[p2++];


        if (p1 < m)

            System.arraycopy(copyNums1, p1, nums1, p, n+m-p);

        if (p2 < n)

            System.arraycopy(nums2, p2, nums1, p,n+m-p);



    }


}
