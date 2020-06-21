package examsTest.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm
 * @description: 前序遍历
 * @author: wuzheb
 * @create: 2020-06-21 00:40
 **/
public class PreOrderTraversalBinaryTree {

    public List<Integer> preOrder(InOrderTraversalBinaryTree.TreeNode root) {

        List<Integer> integers = new ArrayList<>();

        //preorder1(integers, root);

        preOrderTraversal(root, integers);
        return integers;


    }




    /**
     * @Author             wuzhen
     * @Description        递归法
     * @Date              2020/6/21 0:35
     * @Param             [integers, root]
     * @return            void
     */
    private void preorder1(List<Integer> integers, InOrderTraversalBinaryTree.TreeNode root) {
        if (root == null) {

            return;
        }

        integers.add(root.val);

        preorder1(integers, root.left);

        preorder1(integers, root.right);

    }



    public static class TreeNode {
        int val;
        InOrderTraversalBinaryTree.TreeNode left;
        InOrderTraversalBinaryTree.TreeNode right;
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
        InOrderTraversalBinaryTree.TreeNode node;
        String color;

        public ColorNode(InOrderTraversalBinaryTree.TreeNode node, String color){
            this.node = node;
            this.color = color;
        }
    }

    public void preOrderTraversal(InOrderTraversalBinaryTree.TreeNode root, List<Integer> res) {
        if(root == null) return;

        Stack<InOrderTraversalBinaryTree.ColorNode> stack = new Stack<>();
        stack.push(new InOrderTraversalBinaryTree.ColorNode(root,"white"));

        while(!stack.empty()){
            InOrderTraversalBinaryTree.ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                if(cn.node.right != null) stack.push(new InOrderTraversalBinaryTree.ColorNode(cn.node.right,"white"));
                stack.push(new InOrderTraversalBinaryTree.ColorNode(cn.node,"gray"));
                if(cn.node.left != null)stack.push(new InOrderTraversalBinaryTree.ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }

    }
}

