import org.junit.Assert;
import org.junit.Test;
import secondTask.TaskTwo;

/**
 * Created by Алексей on 11.03.2017.
 */
public class TestClass {
    TaskTwo taskTwo = new TaskTwo();
    @Test
    public void testChangePi(){
        Assert.assertEquals("x3.14x", taskTwo.changePi("xpix"));
    }
}