import org.junit.Assert;
import org.junit.Test;
import secondTask.TaskTwo;

/**
 * Created by Алексей on 11.03.2017.
 */
public class TestClass {
    TaskTwo taskTwo = new TaskTwo();
    @Test
    public void test(){
        Assert.assertEquals(2, taskTwo.strCount("xyx", "x"));
    }
}
