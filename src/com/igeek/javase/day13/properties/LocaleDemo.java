package com.igeek.javase.day13.properties;

import java.util.Locale;

/**
 * @version 1.0
 * @Description Locale 地域
 * @Author chenmin
 * @Date 2020/11/19 9:40
 */
public class LocaleDemo {

    public static void main(String[] args) {
        //static Locale[] getAvailableLocales() 返回数组所有安装的场所。
        Locale[] locales = Locale.getAvailableLocales();

        //中国：CN --> 中文：zh
        //美国：US --> 英文：en
        for (Locale locale : locales) {
            System.out.println(locale.getDisplayCountry()+"："+locale.getCountry()
                    +" --> "+locale.getDisplayLanguage()+"："+locale.getLanguage());
        }

        //zh_CN
        System.out.println("本地默认的："+Locale.getDefault());
    }

}
