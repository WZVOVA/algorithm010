package examsTest.week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: BST最大深度
 * @author: wuzheb
 * @create: 2020-06-27 22:18
 **/
public class MaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    /**
     * 递归法
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/27 22:19
     * @Param             [root]
     * @return            int
     */
    public int maxDepth(TreeNode root) {


        // terminator
        if (root == null) {
            return 0;
        }

        // process
        if (root != null) {

            // drill down
            int leftTree = maxDepth(root.left);
            int rightTree = maxDepth(root.right);

            // merge result
            return Math.max(leftTree, rightTree) + 1;
        }

        return 0;

    }


    /**
     * 队列保存，BFS
     *
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/27 22:20
     * @Param             [root]
     * @return            int
     */
    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }


        Queue<TreeNode> queue = new LinkedList<>();

        int depth = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();

                if (poll.left != null) queue.offer(poll.left);

                if (poll.right != null) queue.offer(poll.right);

            }
        }


        return depth;





    }
}
