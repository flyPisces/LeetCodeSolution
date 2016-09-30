package NextPermutation;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place, do not allocate extra memory.

    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
    
 * @author alshen
 *
 */


public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int pivot = 0;
        for (int i = nums.length - 2;i >= 0;-- i) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        int q = 0;
        for (int i = nums.length - 1;i > pivot;-- i) {
            if (nums[i] > nums[pivot]) {
                q = i;
                break;
            }
        }
        
        if (pivot ==0 && q == 0) {
            reverse(0, nums.length - 1, nums);
            return;
        }
        
        swap(pivot, q, nums);
        reverse(pivot + 1, nums.length - 1, nums);
    }
    
    public void reverse(int start, int end, int[] nums) {
        while (start < end) {
            swap(start, end, nums);
            
            start ++;
            end --;
        }
    }
    
    public void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;        
    }
}
