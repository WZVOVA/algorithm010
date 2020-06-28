package examsTest.week3;

import java.util.Stack;

/**
 * @program: algorithm
 * @description: 验证二叉搜索树
 * @author: wuzheb
 * @create: 2020-06-27 18:59
 **/
public class IsValidBST {


    public boolean isValidBST(TreeNode root) {


        return helper(root, null, null);





    }

    private boolean helper(TreeNode root, Double lower, Double upper) {


        // terminator

        if (root == null) return true;


        if (lower != null && lower >= root.val) return false;

        if (upper != null && upper <= root.val) return false;




        // process current status

        // drill down


        if (helper(root.left, lower,root.val) && helper(root.right, root.val, upper)) return true;

        return false;
    }


    public class TreeNode {
        double val;
        TreeNode left;
        TreeNode right;
        TreeNode(double x) { val = x; }
    }



    /**
     * 栈保存法
     *
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/27 21:30
     * @Param             [root]
     * @return            boolean
     */
    public boolean isValidBST2(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();

        double inorder = -Double.MAX_VALUE;


        while (!stack.isEmpty() || root != null) {

            // 压入左节点，先压入最小值
            while (root != null) {

                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            double val = root.val;

            if (val <= inorder) return false;


            inorder = val;

            root = root.right;
        }

        return true;




    }

}
