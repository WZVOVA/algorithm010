package examsTest.week7;

/**
 * @program: algorithm
 * @description: 并查集模型
 * @author: wuzheb
 * @create: 2020-07-26 22:37
 **/
public class UnionFindModel {

    public int count;

    // 容器
    private int[] container;

    public UnionFindModel (int n) {

        count = n;

        container = new int[n];

        for (int i = 0; i < n; i++) {

            container[i] = i;
        }
    }



    public int findAncestor(int sibling) {

        return noCompress(sibling);

    }

    private int compress(int sibling) {

        int dest = sibling;

        while (container[dest] != sibling) {

            dest = container[dest];
        }

        int ex = sibling;

        while (container[ex] != sibling) {

            int ori = ex;

            ex = container[ori];

            container[ori] = dest;
        }

        return dest;


    }

    /**
     * @Author             wuzhen
     * @Description       非压缩方法
     * @Date              2020/7/26 23:36
     * @Param             [sibling]
     * @return            int
     */
    private int noCompress(int sibling) {

        int p = sibling;

        while (container[p] != p) {

            container[p] = container[container[p]];

            p = container[p];
        }

        return p;
    }


    public void union(int member1, int member2) {

        int ancestor1 = findAncestor(member1);

        int ancestor2 = findAncestor(member2);

        if (ancestor1 != ancestor2) {

            container[ancestor1] = ancestor2;
            count--;
        }

    }

}
