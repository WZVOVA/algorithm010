package examsTest.week9;

import java.util.*;

/**
 * @program: algorithm
 * @description: 排列
 * @author: wuzheb
 * @create: 2020-08-07 00:57
 **/
public class Combina {

    private List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new LinkedList();

        permute(list,0, nums);

        return res;
    }

    public void permute(List<Integer> list, int start, int[] nums) {

        // terminator

        if (start == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // process

        for (int i = 0; i < nums.length; i++) {

            // 减枝过程
            if (!list.contains(nums[i])) {
                list.add(nums[i]);

                // drill down
                permute(list, start+1, nums);

                // reverse;
                list.remove(start);
            }

        }



    }

    public static void main(String[] args) {

        Combina combina = new Combina();
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(combina.permute(arr));

        int[] ints = Arrays.copyOf(arr, arr.length);


    }
}
