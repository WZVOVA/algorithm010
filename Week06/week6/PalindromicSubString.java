package examsTest.week6;

/**
 * @program: algorithm
 * @description: 回文子串的数量
 * @author: wuzheb
 * @create: 2020-07-19 23:30
 **/
public class PalindromicSubString {


    public static int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
