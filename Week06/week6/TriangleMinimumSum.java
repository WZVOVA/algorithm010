package examsTest.week6;

import java.util.List;

/**
 * @program: algorithm
 * @description: 三角形最小和
 * @author: wuzheb
 * @create: 2020-07-19 21:55
 **/
public class TriangleMinimumSum {


    /**
     * @Author             wuzhen
     * @Description        dp方案
     * @Date              2020/7/19 22:01
     * @Param             [triangle]
     * @return            int
     */

    public static int getMinimunSum(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size() + 1];
        for (int j = triangle.size() - 1; j >= 0; --j) {

            for (int i = 0; i < triangle.get(j).size(); ++i) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(j).get(i);
            }

        }

        return dp[0];
    }


    /**
     * @Author             wuzhen
     * @Description           dfs方法
     * @Date              2020/7/19 22:10
     * @Param             [triangle]
     * @return            int
     */
    public static int method2(List<List<Integer>> triangle) {

        return dfs(0, 0, triangle);



    }

    private static int dfs(int level, int index, List<List<Integer>> triangle) {

        // terminator

        if (level >= triangle.size() - 1) {

            return triangle.get(level).get(index);
        }

        // process and drill down

        int left = dfs(level + 1, index, triangle);
        int right = dfs(level+1, index+1, triangle);


        return Math.min(left, right) + triangle.get(level).get(index);
    }

}
