package examsTest.week7;

/**
 * @program: algorithm
 * @description: 快速法
 * @author: wuzheb
 * @create: 2020-07-27 00:30
 **/
public class Sudo2 {


    public void solveSudoku(char[][] board) {

        if (board == null || board.length == 0) return;

        solve(board, 0);
    }

    private boolean solve(char[][] board, int cur) {
        while (cur < 81 && board[cur / 9][cur % 9] != '.') cur++;
        if (cur == 81) return true;
        int i = cur / 9, j = cur % 9;
        for (char c = '1'; c <= '9'; ++c) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (solve(board, cur + 1))
                    return true;
                else
                    board[i][j] = '.';
            }
        }

        return false;

    }

    private boolean isValid(char[][] board, int column, int row, char c) {

        int blkrow = (row / 3) * 3, blkcol = (column / 3) * 3;
        for (int i = 0; i < 9; i++)
            if (board[i][column] == c || board[row][i] == c ||
                    board[blkrow + i / 3][blkcol + i % 3] == c)
                return false;
        return true;


    }
}
