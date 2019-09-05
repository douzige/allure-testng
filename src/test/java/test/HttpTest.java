package test;

import common.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;



import java.io.IOException;

/**
 * @author ceshi_chen
 * @version $Id: HttpTest,  2019/9/5 18:22 ceshi_chen Exp$
 */

public class HttpTest {
    private static final Logger logger = LoggerFactory.getLogger(HttpTest.class);
    /**
     * 测试http get请求，判断返回值长度>0
     */
    @Title("http的测试类,正确的请求")
    @Test(description = "测试http get 请求")
    public void  testGet(){
       String  url ="http://118.24.50.232:8080/demo/get/1";

       logger.info("请求地址"+url);
       String value = "";
        try {
            value = HttpUtils.httpGet(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("输出结果:"+value);
        Assert.assertTrue(value.length()>0);
    }

    /**
     * 忽略测试，该测试用例还没有准备好
     */
    @Test(enabled=false)
    public   void   testPost(){

    }

}
