package examsTest.week9;

/**
 * @program: algorithm
 * @description: 爬楼顶晋级
 * @author: wuzheb
 * @create: 2020-08-05 07:56
 **/
public class NUpstairs {

    public static int nStep(int n) {


        // 初始步数

        int maxStep = 5;

        int[] mem = new int[n + 1];

        mem[1] = 1;
        mem[2] = 2;
        mem[0] = 1;


        for (int i = 3; i <= n; i++) {

            for (int j = 1; j <= 5 && (i - j) >= 0 ; j++) {

                mem[i] += mem[i-j];

            }

        }

        return mem[n];


    }


    public static void main(String[] args) {

        System.out.println(nStep(5));

    }
}
