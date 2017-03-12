package thirdTask;

/**
 * Created by Алексей on 11.03.2017.
 */
public class Recursions {
    /*
    * need to find a group of int's
    * with sum given if such exist's
    * */
    public boolean groupSum(int start, int[] nums, int target){
        if(target == 0)
            return true;
        if (start == nums.length)
            return false;
        if(groupSum(start+1,nums,target - nums[start]))
            return true;
        return groupSum(start+1, nums, target);
    }


}
