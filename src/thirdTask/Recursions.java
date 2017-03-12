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

    /*
    * equal to groupSum
    * all the 5 multiples must be included
    * */
    public boolean groupSum5(int start, int[] nums, int target){
        if(start >= nums.length){
            if(target == 0)
                return true;
            return false;
        }
        if(nums[start] % 5 == 0){
            if(start < nums.length - 1 && nums[start+1] == 1)
                return groupSum5(start + 2, nums, target - nums[start]);
            return groupSum5(start + 1, nums, target - nums[start]);
        }
        if(groupSum5(start+1,nums,target - nums[start]))
            return true;
        return groupSum5(start+1, nums, target);
    }

}
