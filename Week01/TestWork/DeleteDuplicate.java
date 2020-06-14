package examsTest.TestWork;

/**
 * @program: algorithm
 * @description:
 * @author: wuzhen
 * @create: 2020-06-09 23:45
 **/
public class DeleteDuplicate {

    public static int removeDuplicates(int[] nums) {

        int leftlimit = 0;

        for (int i = 1; i < nums.length ; i++) {

            if (nums[i] != nums[leftlimit]) {
                if (i-leftlimit > 1) {
                    nums[++leftlimit] = nums[i];
                } else {
                    leftlimit++;
                }
            }

        }

        return ++leftlimit;

    }
}
