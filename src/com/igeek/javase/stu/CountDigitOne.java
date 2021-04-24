package com.igeek.javase.stu;

/**
 * @version 1.0
 * @Description TODO
 * @Author xujian
 * @Date 2020/12/11 13:30
 */
/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 例如：12    1  10  11  12   "1一共出现了5次
 *
 * 824883294-->767944060
 */

public class CountDigitOne {
    public static void main(String[] args) {
        System.out.println(f2(12));
        System.out.println(f2(824883294));
    }

    //方法一：暴力解法 遍历所有位数
    public static int f(int n){
        int count=0;
        //遍历所有数
        for (int i = 1; i < n + 1; i++) {
            String num = String.valueOf(i);
            //遍历所有位数
            for (int j = 0; j < num.length(); j++) {
                if (num.charAt(j)=='1'){
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 每一位数跟1比较，大于1，小于1 ，等于1
     * perNum代表遍历到该位前面的所有数
     * pow代表遍历该位的后面所有数的数量级
     * postNum代表遍历该位后面的所有数
     * a.大于1：   32456 第二位：2                      2256
     *           01000-01999   1000                   0100-0199   100
     *           11000-11999   1000                   2100-2199   100
     *           21000-21999   1000                   1100-1199   100
     *           31000-31999   1000
     *           "1"出现的所有可能：4*1000              3*100
     *                                 (perNum+1)*pow
     *
     * b.等于1：    31256  第二位：1
     *              01000-01999  1000 pow
     *              11000-11999   pow
     *              21000-21999   pow
     *              31000-31256   256+1  postNum+1
     *            perNum*pow+postNum+1
     * c.小于1 ：    30456
     *               01000-01999  pow
     *               11000-11999 pow
     *               21000-21999 pow
     *              perNum*pow
     */
    //方法二，找规律
    public static int f1(int n ){
        String num = String.valueOf(n);
        //初始化数据
        int perNum=0;
        int pow=(int)Math.pow(10,num.length()-1);
        int postNum=Integer.parseInt(num.substring(1));
        //初始化计数器
        int count=0;
        for (int i = 0; i < num.length(); i++) {
            int x = num.charAt(i) - '0';
            //int x1=Integer.parseInt(String.valueOf(num.charAt(i)));
            if (x>1){
                count+=(perNum+1)*pow;
            }else if (x==1){
                count+=perNum*pow+postNum+1;
            }else {
                count+=perNum*pow;
            }

            //更新数据
            if (i<num.length()-1) {
                perNum = perNum * 10 + x;
                postNum = postNum - (num.charAt(i + 1)) * pow;
                pow = pow / 10;
            }
        }

        return count;
    }

    /**
     * 只看第一位数，跟1比较,只有两种情况：等于1 ，大于1（不等于1）
     *
     * 例如
     *      23546  10000
     *high代表第一位数   2
     *pow代表第一位所在的数量级  10000
     * last代表除了high，其它所有的数  3546
     *      0-9999        f(pow-1)
     *      10000-19999   pow+f(pow-1)
     *      20000-23546   f(last)
     *     high*f(pow-1)+f(last)+pow
     *
     * b.high=1:
     *      12345
     *      0-9999    f(pow-1)
     *      10000-12345  f(last)+last+1
     *    f(pow-1)+last+1+f(last)
     *
     */
    //方法三：递归算法
    public static int f2(int n ){
        //终止条件
        if (n<=0){
            return 0;
        }

        String num = String.valueOf(n);

        int high=num.charAt(0)-'0';
        int pow=(int)Math.pow(10,num.length()-1);
        int last=n-high*pow;

        if(high==1){
            return f2(pow-1)+last+1+f2(last);
        }else {
            return high*f2(pow-1)+f2(last)+pow;
        }

    }
}
