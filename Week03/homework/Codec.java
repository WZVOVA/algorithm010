package examsTest.week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 序列化和反序列化
 * @author: wuzheb
 * @create: 2020-06-27 23:16
 **/
public class Codec {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.BFS解法
    public String serialize(TreeNode root) {


        StringBuilder res = new StringBuilder("[");

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);


        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();

            if (cur == null) {

                res.append("null,");

            } else {

                res.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        res.setLength(res.length() - 1);

        res.append("]");

        return res.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {


        // 获取数组字符值
        String[] nodes = data.substring(1, data.length() - 1).split(",");

        TreeNode root = getNode(nodes[0]);

        TreeNode parent = root;

        // 存放父节点
        Queue<TreeNode> parents = new LinkedList<>();

        boolean isLeft = true;

        for (int i = 1; i < nodes.length; i++) {

            TreeNode cur = getNode(nodes[i]);

            if (isLeft) {

                parent.left = cur;
            } else {
                parent.right = cur;
            }

            if (cur != null) {

                parents.offer(cur);
            }

            isLeft = !isLeft;

            if (isLeft) {

                parent = parents.poll();
            }

        }

        return root;






    }

    private TreeNode getNode(String node) {


        if (node.equals("null")) {

            return null;
        } else {

            return new TreeNode(Integer.parseInt(node));
        }
    }
}
