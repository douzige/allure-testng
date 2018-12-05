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
    public void testAdd1() {
        int a = app.add(2, 3);
        assertEquals(a, 5);
    }
    @Test
    public void testAdd() {
        int a = app.add(2, 3);
        assertEquals(a, 6);
    }

    @Test
    public void testsub1() {
        int a = app.sub(8, 3);
        assertEquals(a, 5);
    }
    @Test
    public void testsub() {
        int a = app.sub(8, 3);
        assertEquals(a, 4);
    }

    @Test
    public void testmul1() {
        int a = app.mul(2, 3);
        assertEquals(a, 6);

    }
    @Test
    public void testmul() {
        int a = app.mul(2, 3);
        assertEquals(a, 7);

    }
    @Test
    public void testdlv1() {
        int a = app.div(6, 2);
        assertEquals(a, 3);

    }

    @Test
    public void testdlv() {
        int a = app.div(6, 1);
        assertEquals(a, 6);

    }
}