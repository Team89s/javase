package com.igeek.javase.day17.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 14:12
 * 编写多线程同步程序，模拟3个人排除买票，张某、李某和赵某买电影票，
 * 售票员只有3张五元的钱，电影票5元一张。
 *
 * 张某拿20元一张的RMB排在李某的前面，
 * 李某排在赵某的前面拿一张10元的RMB买票，
 * 赵某拿一张5元的RMB买票。
 * 提示：
 * 1.Thread类的wait()方法：是指让当前线程处于等待状态，让释放线程锁对象，让其它线程能够获得锁对象，
 * 直到其它线程调用notify()或者notifyAll()方法唤醒后才能继续执行。
 * 2.Thread类的notifyAll()方法：是指唤醒所有正在等待锁对象的线程。
 *
 */
public class Test17_3_1 {
    public static void main(String[] args) throws InterruptedException {
        BuyTicket buyer1 = new BuyTicket(20,"张某");
        BuyTicket buyer2 = new BuyTicket(10,"李某");
        BuyTicket buyer3 = new BuyTicket(5,"赵某");

        buyer1.start();
        buyer2.start();
        buyer3.start();
    }
}
class BuyTicket extends Thread{
    //售票员有3张五5元的钱
    private static int money5 = 3;
    //售票员有0张10元
    private static int money10;
    //售票员有0张20元
    private static int money20;
    //购买票的钱
    private int money;

    public BuyTicket(int money,String name){
        super(name);
        this.money = money;
    }

    @Override
    public void run() {
        buy(money);
    }

    public synchronized static void buy(int money){
        if(money==5){
            //直接将票买走
            money5++;
            System.out.println(money5+","+money10+","+money20);
            System.out.println(Thread.currentThread().getName()+"您的钱刚好够买一张票，请直接拿走...");
        }else if(money==10){
            //判断当前售货员手里的5元钱是否有一张，若小于一张则直接进入等待状态
            if(money5<1){
                try {
                    System.out.println("李钱不够找");
                    BuyTicket.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            money5--;
            money10++;
            System.out.println(money5+","+money10+","+money20);
            System.out.println(Thread.currentThread().getName()+"您给的钱是10元，找你5元，将票取走...");
        }else if(money==20){
            //判断当前售货员手里的5元钱是否有三张，若小于三张则直接进入等待状态
            if(money5<3 && money10<1){
                try {
                    System.out.println("张钱不够找");
                    BuyTicket.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(money5>=3){
                money5-=3;
                money20++;
                System.out.println(money5+","+money10+","+money20);
                System.out.println(Thread.currentThread().getName()+"您给的钱是20元，找你15元，将票取走...");
            }else if(money10>=1 && money5>=1){
                money10-=1;
                money5-=1;
                money20++;
                System.out.println(money5+","+money10+","+money20);
                System.out.println(Thread.currentThread().getName()+"您给的钱是20元，找你15元，将票取走...");
            }
        }
        BuyTicket.class.notifyAll();
    }
}
