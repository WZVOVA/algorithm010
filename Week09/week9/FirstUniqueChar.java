package examsTest.week9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: algorithm
 * @description: 找出第一个不重复的字符
 * @author: wuzheb
 * @create: 2020-08-09 23:40
 **/
public class FirstUniqueChar {

    public int firstUniqueChar(String word) {

        if (word.length() == 1) return 0;

        Set<Character> set = new HashSet<>();

        // 暴力法

        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.charAt(i))) {
                continue;
            }


            if (!set.contains(word.charAt(i)) && i == word.length()-1) {
                return i;
            }


            if (set.contains(word.charAt(i)) && i == word.length() - 1) {
                return -1;
            }


            int j = i+1;

            for (; j < word.length() ; j++) {

                if (word.charAt(i) == word.charAt(j)) {

                    set.add(word.charAt(i));
                    break;
                }

                if (j == word.length() -1) {
                    return i;
                }
            }


        }

        return -1;

    }


    public int firstUniqueCh(String word) {

        // hash法

        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < word.length() ; i++) {

            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);

        }


        for (int i = 0; i < word.length(); i++) {

            if (map.get(word.charAt(i)) == 1) {

                return i;
            }

        }

        return -1;
    }



    public int firstUniqChar(String s) {
        int[] fre = new int[26];

        for (int i = 0; i < s.length(); i++) {

            fre[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {

            if (fre[s.charAt(i) - 'a'] == 1) {
                return i;
            }

        }

        return -1;
    }
}

