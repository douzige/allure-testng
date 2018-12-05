package test;


import org.testng.annotations.Test;
import servers.App;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    App app = new App();

    @Test
    public void testAdd() {
        int a = app.add(2, 3);
        assertEquals(a, 5);
    }

    @Test
    public void testsub() {
        int a = app.sub(8, 3);
        assertEquals(a, 5);
    }

    @Test
    public void testmul() {
        int a = app.mul(2, 3);
        assertEquals(a, 6);

    }

    @Test
    public void testdlv() {
        int a = app.div(6, 0);
        assertEquals(a, 0);

    }
}