package com.igeek.javase.day08.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 15:20
 *
 * 校验方法重写中父子级关于异常的抛出问题
 */
public class Test2_01 {


}
class Father{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Father(){

    }

    public Father(String name){
        this.name = name;
    }

    public void work() throws MyException{
        System.out.println(name+"Father 正在工作...");
    }
}

class Son extends Father{
    /**
     * 方法重写关于抛出异常：
     * 1.子类抛出异常，不可以是父类抛出的同级别异常   throws My2报错
     * 2.子类抛出异常，不可以比父类抛出异常大   throws MyException报错
     * 3.子类抛出异常，可以抛出和父类同样的异常  throws My1正常
     * 4.子类抛出异常，可以抛出父类抛出异常的子类异常.  throws TestException正常
     * 5.子类抛出异常，可以抛出多个 "父类抛出异常的子类异常".  throws My1 , My2正常
     *
     * 注意：
     * 1.子类重写父类的方法时，若父类未抛出异常，但是子类throw new Exception()的情况,
     * 子类只能就地解决try...catch；若要强制进行抛出异常，则父类要求抛出同样异常。
     * if(true){
     *     try {
     *        throw new Exception();
     *     } catch (Exception e) {
     *        e.printStackTrace();
     *     }
     * }
     *
     * 2.在子类中，调用执行父类中的方法，必须要求要么就地解决，要么方法上抛出与父类同样的异常
     * try {
     *   super.work();
     * } catch (My1 my1) {
     *   my1.printStackTrace();
     * }
     */
    @Override
    public void work() throws My1 , My2{
        /*try {
            super.work();  //必须要求要么就地解决，要么方法上抛出与父类同样的异常
        } catch (My1 my1) {
            my1.printStackTrace();
        }*/
        /*if(true){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        System.out.println(this.getName()+"Son 正在工作...");
    }
}

class MyException extends Exception{

}
// My1 和 My2 同级
class My1 extends MyException{

}
class My2 extends MyException{

}
//TestException 是My1的子类
class TestException extends My1{

}

