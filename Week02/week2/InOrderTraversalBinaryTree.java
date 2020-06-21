package examsTest.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm
 * @description: 二叉树中序遍历
 * @author: wuzheb
 * @create: 2020-06-21 00:27
 **/
public class InOrderTraversalBinaryTree {

    public List<Integer> inorder(TreeNode root) {

        List<Integer> integers = new ArrayList<>();

        //inorder(integers, root);

        inorderTraversal(root, integers);
        return integers;


    }




    /**
     * @Author             wuzhen
     * @Description        递归法
     * @Date              2020/6/21 0:35
     * @Param             [integers, root]
     * @return            void
     */
    private void inorder(List<Integer> integers, TreeNode root) {
        if (root == null) {

            return;
        }

        inorder(integers, root.left);

        integers.add(root.val);

        inorder(integers, root.right);

    }



    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    /**
     * @Author             wuzhen
     * @Description        迭代法
     * @Date              2020/6/21 0:36
     * @Param             [integers, root]
     * @return            void
     */
    public static class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }

    public void inorderTraversal(TreeNode root, List<Integer> res) {
        if(root == null) return;

        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));

        while(!stack.empty()){
            ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }

    }
}
