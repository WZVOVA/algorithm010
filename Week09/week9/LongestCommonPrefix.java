package examsTest.week9;

/**
 * @program: algorithm
 * @description: 最长公共前缀
 * @author: wuzheb
 * @create: 2020-08-10 01:03
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {


        // 非空判断
        if (strs == null || strs.length == 0) return "";

        // 行列式，先判断每列
        for (int i = 0; i < strs[0].length(); i++) {

            char c = strs[0].charAt(i);


            // 对每一行的同一列进行判断
            for (int j = 1; j < strs.length; j++) {

                // 不满足条件直接返回结果
                if (i == strs[j].length() || strs[j].charAt(i) != c) {

                    return strs[0].substring(0, i);
                }

            }
        }

        // 满足所有条件

        return strs[0];

    }
}
