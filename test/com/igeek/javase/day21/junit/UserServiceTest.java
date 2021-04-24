package com.igeek.javase.day21.junit;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * 用户业务逻辑类的测试类
 *
 * Junit 框架
 * 1.Junit框架，单元测试的框架
 * 2.使用@Test来完成测试
 * 3.测试方法特点：没有返回值void ， 没有形参 ， 必须是public修饰的
 *
 * 如何运行测试方法
 *     * 选中方法名 --> 右键 --> Run '测试方法名'  运行选中的测试方法
 *     * 选中测试类类名 --> 右键 --> Run '测试类类名'  运行测试类中所有测试方法
 *     * 选中模块名 --> 右键 --> Run 'All Tests'  运行模块中的所有测试类的所有测试方法
 */
public class UserServiceTest {

    private UserService service;

    //@BeforeClass 随着类加载而加载，有且只执行一次，一般用于静态资源的初始化操作
    @BeforeClass
    public static void beforeClass(){
        System.out.println("@BeforeClass");
    }

    //@AfterClass  有且只执行一次，一般用于静态资源的关闭资源
    @AfterClass
    public static void afterClass(){
        System.out.println("@AfterClass");
    }

    //@Before  在调用每一个方法前，执行的逻辑，一般用于初始化操作
    @Before
    public void setUp() throws Exception {
        System.out.println("@Before");
        service = new UserService();
    }

    //@After  在调用每一个方法后，执行的逻辑，一般用于释放资源
    @After
    public void tearDown() throws Exception {
        System.out.println("@After");
    }

    @Test
    public void login() {
        boolean flag = service.login("zhangsan", "123");
        System.out.println("flag = "+flag);
        /**
         * Assert  断言
         * assertEquals(String,Object,Object)
         * 第一个参数：与预期结果不一致时，异常信息
         * 第二个参数：期望值
         * 第三个参数：实际值
         */
        Assert.assertEquals("登录失败",true,flag);
    }

    @Test
    public void selectOne() {
        service.selectOne("lisi123");
    }
}