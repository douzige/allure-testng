package test;


import org.testng.annotations.Test;
import servers.App;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    App app = new App();

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

    @Test(description = "测试乘法正确")
    public void testmul1() {
        int a = app.mul(2, 3);
        assertEquals(a, 6);

    }
    @Test(description = "测试乘法错误")
    public void testmul() {
        int a = app.mul(2, 3);
        assertEquals(a, 7);

    }
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
    @Test(description = "测试除法异常")
    public void testDlv2(){
        int a = app.div(100, 0);
        assertEquals(a,0);
    }
}