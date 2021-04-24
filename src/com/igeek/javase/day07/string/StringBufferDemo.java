package com.igeek.javase.day07.string;

/**
 * @version 1.0
 * @Description StringBuffer类
 * @Author chenmin
 * @Date 2020/11/5 15:18
 *
 * String类
 * 1.不可变的字符序列  private final char value[];
 * 2.拼接很占用内存，比较浪费资源  String str = "a"+"b"; "a"  "b"  "ab"
 *
 * StringBuffer类   多线程操作可变字符序列
 * 1.可变的字符序列
 * 2.线程安全的，执行效率相对低一些   方法上synchronized关键字
 * 3.初始容量是16
 *
 * StringBuilder类  单线程操作可变字符序列
 * 1.可变的字符序列
 * 2.线程不安全的，执行效率相对高一些
 * 3.初始容量是16
 */
public class StringBufferDemo {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        //追加的方法
        sb.append(false);
        System.out.println("sb = "+sb);  //false
        System.out.println("容量："+sb.capacity()); //16
        System.out.println("长度："+sb.length()); //5  真实的字符数

        //追加
        System.out.println("sb = "+sb.append(1));  //false1

        //char charAt(int index)  返回指定索引在这个序列的 char价值。
        System.out.println("charAt(index):"+sb.charAt(1));  //a

        //StringBuffer delete(int start, int end) 删除的字符在字符串序列分析。 end取不到
        System.out.println("sb = "+sb.delete(1,3)); //fse1

        //int indexOf(String str) 返回指数在这个字符串指定的子字符串中第一个出现的。
        //int lastIndexOf(String str) 返回指数在这个字符串的指定子字符串最右边的发生。
        System.out.println(sb.indexOf("s"));  //1
        System.out.println(sb.lastIndexOf("1")); //3

        //StringBuffer insert(int offset, long l)  插入的 long参数的字符串表示形式进入这个序列。
        System.out.println(sb.insert(3,343434L));  //fse3434341

        //StringBuffer replace(int start, int end, String str) 在一个字符串中替换指定的 String字符这个序列的特征。
        System.out.println(sb.replace(3,9,"000000000022222222")); //fse00000000001
        System.out.println("容量："+sb.capacity()); //旧容量*2+2 = 34

        //StringBuffer reverse()  使这个字符序列被序列的反转所取代。
        System.out.println("反转："+sb.reverse()); //1222222220000000000esf

        //String substring(int start, int end)  返回一个包含目前包含在这个序列的子序列特征的新 String。
        System.out.println("截取："+sb.substring(1,9));  //22222222
    }

}
