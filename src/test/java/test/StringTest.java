package test;

import org.testng.annotations.Test;
import servers.StringTool;
import servers.StringToolImpl;

import static org.testng.Assert.assertEquals;

/**
 * @author ceshi_chen
 * @version $Id: StringTest,  2019/5/21 17:16 ceshi_chen Exp$
 */
public class StringTest {
    StringTool  st  = new StringToolImpl();
    @Test(description = "测试字符串转大写")
    public void testString(){
        String str = st.tolow("aBc");
        System.out.println(str);
        assertEquals(str,"ABC");
    }

}
