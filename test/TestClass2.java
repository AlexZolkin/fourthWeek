import org.junit.Assert;
import org.junit.Test;
import thirdTask.Recursions;

/**
 * Created by Алексей on 11.03.2017.
 */
public class TestClass2 {
    Recursions recursions = new Recursions();

    @Test
    public void test(){
        int[] nums = new int[3];
        nums[0] = 2;
        nums[1] = 4;
        nums[2] = 8;
        Assert.assertTrue(recursions.groupSum(0, nums, 10));
    }
}
