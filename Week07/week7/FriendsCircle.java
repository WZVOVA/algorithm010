package examsTest.week7;

import examsTest.week6.UnionFind;

/**
 * @program: algorithm
 * @description: 朋友圈
 * @author: wuzheb
 * @create: 2020-07-26 22:13
 **/
public class FriendsCircle {


    public int findCircleNum(int[][] M) {

        UnionFind unionFind = new UnionFind(M.length);

        for (int i = 0; i < M.length; i++) {

            for (int j = 0; j < i; j++) {

                if (M[i][j] == 1) {

                    unionFind.union(i,j);
                }


            }
        }

        return unionFind.count;

    }
}
