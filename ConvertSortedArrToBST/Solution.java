package ConvertSortedArrToBST;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return recursiveBuild(nums, 0, nums.length - 1);
    }
    
    public TreeNode recursiveBuild(int[] nums, int start, int end) {
        
        if (start > end) {
            return null;
        }
        
        int middle = start + (end - start) / 2;
        
        TreeNode root = new TreeNode(nums[middle]);
        root.left = recursiveBuild(nums, start, middle -1);
        root.right = recursiveBuild(nums, middle + 1, end);
        
        return root;
    }
}
