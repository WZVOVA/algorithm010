package examsTest.TestWork;

/**
 * @program: algorithm
 * @description: 旋转数组
 * @author: wuzheb
 * @create: 2020-06-11 08:02
 **/
public class RotateArray {

    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;

        if (k == 0) return;
        int count = 0;


        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public void rotate3(int[] nums, int k) {
        int temp,prev;
        for (int i = 0; i < k; i++) {
            prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }

    }


    public void rotate4(int[] nums, int k) {

        k %= nums.length;

        if (k == 0) return;

        int exchange = 0;

        for (int start = 0; exchange < nums.length; start++) {

            int current = start;

            int pre = nums[start];

            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                exchange++;
                current = next;

            }while (current != start);

        }

    }


    public void rotate5(int[] nums, int k) {
        int[] news = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int fast = (i + k) % nums.length;

            news[fast] = nums[i];

        }

        for (int i = 0; i < news.length ; i++) {

            nums[i] = news[i];

        }
    }
}
