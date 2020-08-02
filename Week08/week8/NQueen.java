package examsTest.week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: n皇后
 * @author: wuzheb
 * @create: 2020-07-28 00:39
 **/
public class NQueen {

    public List<List<String>> solveNQueens(int n) {

        // prepare空数据
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';

        // 定义解决方案
        List<List<String>> res = new ArrayList<List<String>>();


        // 深度优先解决
        dfs(board, 0, res);

        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {

        // terminator
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        // process current logic
        for(int i = 0; i < board.length; i++) {
            // 校验当前行是否可以落子
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';

                // drill down,继续落子
                dfs(board, colIndex + 1, res);

                // 第一行下完后，reverse state，进入第二行
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        // 行
        for(int i = 0; i < board.length; i++) {
            // 列
            for(int j = 0; j < y; j++) {
                                            // na           pie                 lie
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }


    // 构造棋盘
    private List<String> construct(char[][] board) {

        // board二维棋盘
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}




