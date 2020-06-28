package examsTest.week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 翻转树
 * @author: wuzheb
 * @create: 2020-06-27 17:17
 **/
public class RevertTree {



    /**
     * 递归
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/27 17:30
     * @Param             [root]
     * @return            examsTest.week3.RevertTree.TreeNode
     */
    public TreeNode invertTree(TreeNode root) {


        // terminator

        if (root == null) {
            return root;
        }

        // process logic

//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        root.right = left;
//        root.left = right;

        // drill down
        TreeNode tempRight = root.right;

        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);

        return root;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }



    /**
     * 栈保存法
     *
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/27 17:31
     * @Param             [root]
     * @return            examsTest.week3.RevertTree.TreeNode
     */

    public TreeNode invertTree2(TreeNode root) {


        if (root == null) return null;


        Queue<TreeNode> stack = new LinkedList<>();


        stack.offer(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.poll();

            TreeNode left = node.left;

            node.left = node.right;

            node.right = left;


            if (node.left != null) {

                stack.offer(node.left);
            }


            if (node.right != null) {
                stack.offer(node.right);
            }
        }


        return root;

    }
}
