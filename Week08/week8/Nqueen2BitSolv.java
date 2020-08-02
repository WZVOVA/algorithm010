package examsTest.week8;

/**
 * @program: algorithm
 * @description: 位运算
 * @author: wuzheb
 * @create: 2020-08-02 17:31
 **/
public class Nqueen2BitSolv {


    private int size;

    private int count;

    private void sovle(int row, int ld, int rd) {

        // 当11111 == 11111，及到达最后一行，
        if (row == size) {
            count++;
            return;
        }

        int pos = size & (~(row | ld | rd)); // 获得所有可落Q的位置，1代表可落子，0代表不可落子

        while (pos != 0) {
            int p = pos & (-pos); // 获得最后一位1后面的数

            pos -= p; // pos &= pos - 1  落子，将最后一位的1位置Q,

            // row代表每行的落子，每深入一行，代表下一行落子的区域，0001代表下一行中最后一位不可落子，

            // ld代表pie的位置0010，第二个1代表这个位置不可选，
            // rd代表na的位置0000，代表都可选。

            sovle(row | p,(ld | p) << 1, (rd | p) >> 1);
        }
    }


    public int totalQueens(int n) {
        count = 0;
        size = (1 << n) - 1;

        sovle(0, 0, 0);

        return count;
    }
}
