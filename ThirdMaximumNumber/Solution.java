package ThirdMaximumNumber;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.

 * Created by aoshen on 10/25/16.
 */
public class Solution {
    public int thirdMax(int[] nums) {
        int res = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            res = Math.max(res,i);
            min = Math.min(min,i);
        }
        int one = min;
        int two = min;
        int three = min;

        for(int i : nums){
            if(i > one){
                three = two;
                two = one;
                one = i;
            }else if(i < one && i > two){
                three = two;
                two = i;
            }else if(i < two && i > three){
                three = i;
            }
        }
        if(one == two || two == three) return res;
        else return three;
    }
}
