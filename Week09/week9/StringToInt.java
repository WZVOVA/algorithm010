package examsTest.week9;

/**
 * @program: algorithm
 * @description: 装换字符串中的整数
 * @author: wuzheb
 * @create: 2020-08-10 00:52
 **/
public class StringToInt {

    public int strToInt(String str) {


        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces， bug 要先判断索引位置
        while(index < str.length() && str.charAt(index) == ' ')
            index++;

        if (index == str.length()) return 0;
        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total ||
                    Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;


            // 核心逻辑
            total = 10 * total + digit;

            index ++;
        }
        return total * sign;
    }
}
