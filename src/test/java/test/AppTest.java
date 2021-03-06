package test;


import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import servers.App;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
@Title("测试加法类")
public class AppTest {
    App app = new App();
    @Title("测试加法3+2")
    @Test(description = "测试加法2+5")
    public void testAdd1() {
        int a = app.add(2, 3);
        assertEquals(a, 5);
    }
    @Test(description = "测试加法")
    public void testAdd() {
        int a = app.add(20, 30);
        assertEquals(a, 60);
    }
    @Title("测试减法")
    @Test(description = "测试减法正确")
    public void testsub1() {
        int a = app.sub(8, 3);
        assertEquals(a, 5);
    }
    @Test(description = "测试减法失败")
    public void testsub() {
        int a = app.sub(8, 3);
        assertEquals(a, 4);
    }
    @Title("测试乘法")
    @Test(description = "测试乘法正确")
    public void testmul1() {
        int a = app.mul(2, 3);
        assertEquals(a, 6);

    }
    @Test(description = "测试乘法错误")
    public void testmul() {
        int a = app.mul(20, 3);
        assertEquals(a, 60);

    }
    @Title("测试除法")
    @Test(description = "测试除法正确")
    public void testdlv1() {
        int a = app.div(6, 2);
        assertEquals(a, 3);

    }

    @Test(description = "测试除法错误")
    public void testdlv() {
        int a = app.div(6, 1);
        assertEquals(a, 3);

    }

    @Test(expectedExceptions = ArithmeticException.class,description = "测试除数为0抛出算术异常")
    public void testDlv2(){
        int a = app.div(100, 0);
        assertEquals(a,0);
    }
}