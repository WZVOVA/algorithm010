package examsTest.week7;

/**
 * @program: algorithm
 * @description: 数独解决
 * @author: wuzheb
 * @create: 2020-07-26 23:47
 **/
public class Sudoku {


    public void solveSudoku(char[][] board) {

        if (board == null || board.length == 0) return;

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, i, j, c)) {

                            board[i][j] = c;

                            if (solve(board)) {

                                return true;    // 如果填满则返回成功

                            } else {

                                board[i][j] = '.'; // 复原
                            }

                        }
                    }

                    return false;
                }
            }

        }

        return true;

    }

    private boolean isValid(char[][] board, int column, int row, char c) {

        for (int i = 0; i < 9; i++) {

            // 列重复
            if (board[i][column] != '.' && board[i][column] == c) return false;

            // 行重复
            if (board[row][i] != '.' && board[row][i] == c) return false;

            if (board[3*(row/3) + (i/3)][3*(column/3) + (i%3)] != '.' &&

            board[3*(row/3) + (i/3)][3*(column/3) + (i%3)] == c) return false;

        }

        return true;


    }
}
