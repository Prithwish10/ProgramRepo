//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//
//Note:
//
//Your returned answers (both index1 and index2) are not zero-based.
//You may assume that each input would have exactly one solution and you may not use the same element twice.
//Example:
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
public class Two_Sum_2 {

	public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        int low = 0, high = n - 1;
        
        while(low < high){
            
            if(nums[low] + nums[high] == target)
                return new int[]{low + 1, high + 1};
            
            else if(nums[low] + nums[high] > target)
                high --;
            else
                low ++;
        }
        return new int[]{};
    }
}
