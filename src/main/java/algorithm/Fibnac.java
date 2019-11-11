package algorithm;

import java.util.Arrays;

/**
 * @author shanyb@uxsino.com
 * @title: Fibnac
 * @ticketNO: #
 * @description: 斐布那切数列
 * @create: 2019-10-29 11:38
 */
public class Fibnac {
    private static int[]  result = new int[10];
    public static int fib(int n){

        if(n == 0) {
            result[0] =1;
            return  1;
        }
        if(n == 1 ) {
            result[1] =1;
            return 1;
        }

        if(result[n] > 0 ){
            return result[n];
        }
        result[n] = fib(n-1)+fib(n-2);
        return result[n];

    }


    public static void main(String[] args) {

        for (int i = 0; i < result.length-1; i++) {
            result[i] = 0;
        }
        fib(result.length-1);

        System.out.println(Arrays.toString(result));

    }


}
