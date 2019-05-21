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
    @Test
    public void testString(){
        String str = st.tolow("aBc");
        assertEquals(str,"ABC");
    }

}
