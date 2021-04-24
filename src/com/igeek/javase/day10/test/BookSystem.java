package com.igeek.javase.day10.test;

import java.util.*;

/**
 * @version 1.0
 * @Description 图书管理系统
 * @Author chenmin
 * @Date 2020/11/16 10:08
 */
public class BookSystem {

    //图书管理系统的容器  key是书本的类型  value是当前类型的图书信息
    private static final Map<String, List<Book>> BOOK_STORE = new LinkedHashMap<>();
    private static final Scanner MY_SCANNER = new Scanner(System.in);;

    //初始化界面
    public static void show(){
        System.out.println("-------欢迎来到图书管理系统--------");
        System.out.println("query命令：查询所有图书");
        System.out.println("insert命令：添加图书");
        System.out.println("update命令：修改图书");
        System.out.println("delete命令：删除图书");
        System.out.println("exit命令：退出图书系统");
        System.out.println("请输入您的命令：");
        String line = MY_SCANNER.nextLine();
        switch (line){
            case "query":
                queryBooks();
                break;
            case "insert":
                insertBook();
                break;
            case "update":
                updateBook();
                break;
            case "delete":
                deleteBook();
                break;
            case "exit":
                System.out.println("欢迎下次光临！");
                System.exit(0);
            default:
                System.out.println("您输入的命令有误，请重新输入：");
        }
        //递归调用
        show();
    }

    /**
     * 删除书本信息
     */
    private static void deleteBook() {
        System.out.println("----------欢迎删除书本----------");
        if(BOOK_STORE.size()==0){
            System.out.println("当前图书系统中没有书，请先购买");
            return;
        }else{
            while(true){
                System.out.println("请输入更新书本的类型：");
                String type = MY_SCANNER.nextLine();
                if(BOOK_STORE.containsKey(type)){
                    //类型存在
                    if(BOOK_STORE.get(type).size()==0){
                        //当前类型下没有图书信息
                        System.out.println("您输入的书本类型 "+type+" 下，未发现图书信息！");
                        return;
                    }else{
                        while(true){
                            System.out.println("请输入删除书本的名称：");
                            String name = MY_SCANNER.nextLine();
                            Book book = queryBookByTypeAndName(type, name);
                            if(book==null){
                                //未查询到书本信息
                                System.out.println("您输入的书本类型 "+type+" 下，没有与 "+name+" 匹配的图书信息！");
                            }else{
                                //删除
                                BOOK_STORE.get(type).remove(book);
                                System.out.println("删除成功");
                                return;
                            }
                        }
                    }
                }else{
                    //类型不存在
                    System.out.println("您输入的书本类型不存在");
                }
            }
        }
    }

    /**
     * 更新图书信息
     */
    private static void updateBook() {
        System.out.println("----------欢迎更新书本----------");
        if(BOOK_STORE.size()==0){
            System.out.println("当前图书系统中没有书，请先购买");
            return;
        }else{
            while(true){
                System.out.println("请输入更新书本的类型：");
                String type = MY_SCANNER.nextLine();
                if(BOOK_STORE.containsKey(type)){
                    //类型存在，请更新书本信息
                    if(BOOK_STORE.get(type).size()==0){
                        //当前类型下没有图书信息
                        System.out.println("您输入的书本类型 "+type+" 下，未发现图书信息！");
                        return;
                    }else{
                        while(true){
                            //当前类型下有图书信息
                            System.out.println("请输入更新书本的名称：");
                            String name = MY_SCANNER.nextLine();
                            Book book = queryBookByTypeAndName(type,name);
                            if(book==null){
                                //未查询到书本信息
                                System.out.println("您输入的书本类型 "+type+" 下，没有与 "+name+" 匹配的图书信息！");
                            }else{
                                //查询到书本信息，更新
                                System.out.println("请输入更新后书本的名称：");
                                String newName = MY_SCANNER.nextLine();
                                System.out.println("请输入更新后书本的价格：");
                                String newPrice = MY_SCANNER.nextLine();
                                //更新
                                book.setName(newName);
                                book.setPrice(Double.valueOf(newPrice));
                                System.out.println("更新成功！");
                                return;
                            }
                        }
                    }
                }else{
                    //类型不存在
                    System.out.println("您输入的书本类型不存在");
                }
            }
        }
    }

    /**
     * 通过类型和名称获取书本信息
     * @return  书本信息
     */
    private static Book queryBookByTypeAndName(String type,String name) {
        List<Book> books = BOOK_STORE.get(type);
        for (Book book : books) {
            if(book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }


    /**
     * 查询所有书本信息
     */
    private static void queryBooks() {
        System.out.println("----------欢迎查询书本----------");
        if(BOOK_STORE.size()==0){
            System.out.println("当前图书系统中没有书，请先购买");
            return;
        }else{
            //迭代显示书本信息
            System.out.println("类型\t\t\t\t书名\t\t\t\t价格");
            BOOK_STORE.forEach((type,books)->{
                System.out.println(type);
                books.forEach(book -> {
                    System.out.println("\t\t\t\t"+book.getName()+"\t\t"+book.getPrice());
                });
            });
        }
    }

    /**
     * 插入书本信息
     */
    private static void insertBook() {
        System.out.println("----------欢迎添加书本----------");
        System.out.println("请输入需要添加书本的类型：");
        String type = MY_SCANNER.nextLine();
        //存储书本的集合
        List<Book> books = null;
        if(BOOK_STORE.containsKey(type)){
            //当前类型存在
            books = BOOK_STORE.get(type);
        }else{
            //当前类型不存在
            books = new ArrayList<>();
            //先要进行添加类型
            BOOK_STORE.put(type,books);
        }
        System.out.println("请输入添加书本的名称：");
        String name = MY_SCANNER.nextLine();
        System.out.println("请输入添加书本的价格：");
        String price = MY_SCANNER.nextLine();
        Book book = new Book(name,Double.parseDouble(price));
        //将书本存进去对应的类型中
        books.add(book);
    }


    public static void main(String[] args) {
        show();
    }


}
