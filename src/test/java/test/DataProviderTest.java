package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;
import servers.App;

/**
 * @author ceshi_chen
 * @version $Id: DataProviderTest,  2019/9/5 20:03 ceshi_chen Exp$
 * 该类用来测试一下参数化
 */
public class DataProviderTest {


    App app = new App();

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {

        return new Object[][] { { 10, 20 }, { 100, 110 }, { 200, 210 } };
    }
    @Step("正确的用例,参数化用例第1步、、第二步")
    @Test(dataProvider ="provideNumbers")
    public void testAdd_a(int a,int b){
       int reslut =  app.add(a,b);
        Assert.assertEquals(reslut,a+b);

    }
    @Title("测试减法")
    @Test(dataProvider = "provideNumbers")
    public void testSub_a(int a,int b){
        int result =app.sub(b,a);
        Assert.assertEquals(result,b-a);
    }
    @Test(dataProvider = "provideNumbers",description = "测试参数化的乘法")
    public void  testMul_a(int a,int b){
        int result = app.mul(a,b);
        Assert.assertEquals(result,a*b);
    }

}
