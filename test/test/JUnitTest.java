
package test;

import AI.util.PID;

import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

/**
 *
 * @author X. Wang
 */
public class JUnitTest extends TestCase{
    @Test
    public void testPID(){
        PID pid = new PID(1, 1, 1);
        System.out.println("* JUnitTest: testPID()");
        double y = pid.Compute(1, 1, 1);
        assertEquals(y, - 3.0);
        y = pid.Compute(10, 20, 1);
        assertEquals(y, - 31.0);
        y = pid.Compute(20, 30, 1);
        assertEquals(y, -71.0);
        y = pid.Compute(50, 20, 1);
        assertEquals(y, - 150.0);
        y = pid.Compute(- 150, 20, 1);
        assertEquals(y, 150.0);
        y = pid.Compute(0, 20, 1);
        assertEquals(y, 69.0);
        y = pid.Compute(10, 10, 10);
        assertEquals(y, - 51.0);
        y = pid.Compute(10, 10, 10);
        assertEquals(y, - 150.0);
    }
}
