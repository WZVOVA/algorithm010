package examsTest.week9;

/**
 * @program: algorithm
 * @description: 反转字符串
 * @author: wuzheb
 * @create: 2020-08-10 01:14
 **/
public class ReverseString {

    public void reverseString(char[] s) {

        if (s == null) return;

        for (int i = 0, j = s.length-1; i < j; i++, j--) {

            char temp = s[i];

            s[i] = s[j];

            s[j] = temp;
        }
    }
}
