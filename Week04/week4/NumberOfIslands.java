package examsTest.week4;

/**
 * @program: algorithm
 * @description: 岛屿数量
 * @author: wuzheb
 * @create: 2020-06-29 22:55
 **/
public class NumberOfIslands {

    int length;
    int width;


    /**
     * dfs求岛屿数量
     *
     * @return int
     * @Author wuzhen
     * @Description
     * @Date 2020/6/29 22:56
     * @Param [grid]
     */
    public int numIslands(char[][] grid) {

        // 定义结果

        int result = 0;

        // 定义地形的长度和宽度

        length = grid.length;

        if (length == 0) return result;

        width = grid[0].length;

        // 枚举地形的每个方格

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < width; j++) {

                if (grid[i][j] == '1') {

                    ++result;
                    dfsMarked(grid, i, j);
                }
            }

        }

        // 返回最终结果

        return result;

    }

    private void dfsMarked(char[][] grid, int i, int j) {

        // terminator

        if (i < 0 || i >= length || j < 0 || j >= width || grid[i][j] == '0') {

            return;
        }

        // process
        grid[i][j] = '0';

        // drill down

        dfsMarked(grid,i+1, j);
        dfsMarked(grid,i-1, j);
        dfsMarked(grid, i,j+1);
        dfsMarked(grid, i,j-1);

        // reverse


    }

    private void dfsMarked2(char[][] grid, int i, int j) {


        // terminator
        //if (i < 0 || i >= length || j < 0 || j >= width || grid[i][j] != '1') return;
        if (grid[i][j] == '0') return;
        // process the current logic
        grid[i][j] = '0';

        // drill down;

        if (i - 1 >= 0) dfsMarked2(grid, i-1, j);
        if (i + 1 < length) dfsMarked2(grid, i+1, j);
        if (j - 1 >= 0) dfsMarked2(grid, i, j-1);
        if (j + 1 < width) dfsMarked2(grid, i, j + 1);
    }
}
