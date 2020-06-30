package SearchInARotatedArray;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.

    Subscribe to see which companies asked this question
 *
 * Created by aoshen on 4/3/16.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int index = -1;

        if (nums == null || nums.length == 0) {
            return index;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (nums[mid] < nums[end]) {  // right half sorted
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {                      // left half sorted
                if (nums[mid] > target && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return index;


        /**
         *     int len;
         *     if(s==null || (len = s.length())==0) return 0;
         *     Stack<Integer> stack = new Stack<Integer>();
         *     int num = 0;
         *     char sign = '+';
         *     for(int i=0;i<len;i++){
         *         if(Character.isDigit(s.charAt(i))){
         *             num = num*10+s.charAt(i)-'0';
         *         }
         *         if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
         *             if(sign=='-'){
         *                 stack.push(-num);
         *             }
         *             if(sign=='+'){
         *                 stack.push(num);
         *             }
         *             if(sign=='*'){
         *                 stack.push(stack.pop()*num);
         *             }
         *             if(sign=='/'){
         *                 stack.push(stack.pop()/num);
         *             }
         *             sign = s.charAt(i);
         *             num = 0;
         *         }
         *     }
         *
         *     int re = 0;
         *     for(int i:stack){
         *         re += i;
         *     }
         *     return re;
         */
    }
}
