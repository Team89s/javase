package com.igeek.javase.day07.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description 正则表达式爬取数据
 * @Author chenmin
 * @Date 2020/11/5 16:08
 */
public class RegexDemo5 {

    public static void main(String[] args) {

        String str = "你好，若有问题请联系手机12345678900 或者 联系座机0510-2258779 或者 05102258779；" +
                "若发生重大事情，请直接电邮给我们：123456@qq.com .欢迎随时骚扰：8008208820 或者 800-820-8820";
        //正则表达式
        String regex = "(1[3-9]\\d{9})" +
                "|(\\w{5,}@\\w{2,}(\\.[a-z]{2,}){1,2})" +
                "|(0\\d{2,3}-?\\d{7})" +
                "|((\\d{3}-?){2}\\d{4})";

        //将正则表达式给创建成为规则
        Pattern pattern = Pattern.compile(regex);
        //用刚创建的规则去匹配上述字符串
        Matcher matcher = pattern.matcher(str);
        //发现是否有匹配
        while(matcher.find()){
            //获得到匹配规则的字符串，并且输出
            System.out.println(matcher.group());
        }

    }

}
