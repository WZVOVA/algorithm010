package examsTest.week6;

/**
 * @program: algorithm
 * @description: 最少路径
 * @author: wuzheb
 * @create: 2020-07-19 17:25
 **/
public class TheMinimumPath {



    /**
     * @Author             wuzhen
     * @Description         暴力法
     * @Date              2020/7/19 17:42
     * @Param             [grid]
     * @return            int
     */
    public static int minPathSum(int[][] grid) {

        return calculateResult(grid, 0 , 0);

    }



    private static int calculateResult(int[][] grid, int level, int length) {
        // terminator
        if (level == grid.length || length == grid[0].length) return Integer.MAX_VALUE;

        if (level == grid.length - 1 && length == grid[0].length - 1) return grid[level][length];

        // process

        return grid[level][length] + Math.min(calculateResult(grid, level+1, length), calculateResult(grid, level, length+1));

    }


    public static void main(String[] args) {
        int[][] grid = new int[0][0];
        minPathSum2(grid);
    }




    /**
     * @Author             wuzhen
     * @Description        动态规划
     * @Date              2020/7/19 17:44
     * @Param             [grid]
     * @return            void
     */
    public static int minPathSum2(int[][] grid) {

        return 0;
    }
}
