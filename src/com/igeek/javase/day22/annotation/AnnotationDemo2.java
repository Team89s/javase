package com.igeek.javase.day22.annotation;

/**
 * @version 1.0
 * @Description 如何自定义一个注解 + 属性？
 * @Author chenmin
 * @Date 2020/12/16 14:41
 *
 * 注解中的属性：
 * 1.格式：
 *      方式一：数据类型  属性名();
 *      方式二：数据类型  属性名() default 默认值;
 *      方式三：数据类型  value();   // 特殊属性value
 *
 * 2.使用：
 *      方式一：@MyStu(属性名=值,属性名={值1,值2})
 *      方式二：默认值可以在使用注解时不进行赋值
 *      方式三：若注解中只提供一个value属性，则使用注解时无需写value属性名，可以直接写值；例如：@MyTeacher(值)
 *             若注解中不止提供value属性，则一切如常 “属性名 = 值”；；例如：@MyTeacher(属性名 = 值,属性名 = 值)
 *             若注解中不止提供value属性，其它属性皆有默认值，则使用注解时无需写value属性名，可以直接写值；例如：@MyTeacher(值)
 *
 * 总结：
 * - 如果属性有默认值，则使用注解的时候，这个属性可以不用赋值。
 * - 如果属性没有默认值，那么在使用注解时一定要给属性赋值。
 * - 如果注解中只有一个属性时，一般都会将该属性名命名为value
 */
@MyStu(name="zs",num="001",major = {"java","web"})
@MyTeacher("ww")
public class AnnotationDemo2 {

    @MyStu(name="lisi",num="002",age=22,major = {"mysql","spring"})
    public void study(){

    }

}
@interface MyStu{
    //声明属性
    String name();
    int age() default 20;
    String num();
    String[] major();
}
@interface MyTeacher{
    String value();  //特殊属性
    int age() default 50;
}
