package com.igeek.javase.stu;

//POW(X,N);

/**
 * @version 1.0
 * @Description 幂次方
 * @Author 周遇吉
 * @Date 2020/11/25 13:32
 */
public class PowTest {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 9));
        System.out.println(myPow(2, 9));
        System.out.println(myPow1(2, 9));
    }

    public static double myPow(double x, int n) {
        //当n<0,x=1/x，n=-n；
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        //n为0时，所有值为1
        if (n == 0) {
            return 1;
        }
        //当为0时所有值为0
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }
        return myPow(x, n - 1) * x;


    }

    public static double myPow1(double x, int n) {
        //当n为0时，所有值为1
        if (n == 0) {
            return 1;
        }
        //当为0时所有值为0
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            x = 1 / x;
        }

        double half = myPow1(x, n / 2);
        double rest = myPow1(x, n % 2);
        return rest * half * half;
    }
}


