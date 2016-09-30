package TwoSum;
import java.util.*;

/* Leetcode url: https://leetcode.com/problems/two-sum/ */

public class TwoSumSolution {
    
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        
        int[] arr = new int[2];
        
        Map<Integer, Integer> numPosMap = new HashMap<Integer, Integer>();
        for (int i = 0; i!= nums.length;++ i) {
            if (numPosMap.containsKey((nums[i]))) {
                arr[0] = numPosMap.get(nums[i]);
                arr[1] = i;
                
                break;
            } else {
                numPosMap.put(target - nums[i], i);
            }
        }
        
        return arr;
    }    
}
