package examsTest.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 生成有效的括号
 * @author: wuzheb
 * @create: 2020-06-27 16:01
 **/
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();


    /**
     * 递归模式解决
     *
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/27 16:02
     * @Param             [n]
     * @return            java.util.List<java.lang.String>
     */
    public List<String> generateParenthesis(int n) {

        recur(0, 0, n, "");
        return res;

    }

    private void recur(int leftLevel, int rightLevel, int max, String string) {

        // terminator
        if (leftLevel == max && rightLevel == max) {
            res.add(string);
            return;
        }

        // process the current logic

        if (leftLevel <= max) recur(leftLevel + 1, rightLevel, max, string + "(");

        if (rightLevel <= leftLevel) recur( leftLevel, rightLevel + 1, max, string + ")");


        // drill down

        // reverse states

    }

    public static void main(String[] args) {

        GenerateParenthesis generateParenthesis = new GenerateParenthesis();


        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
