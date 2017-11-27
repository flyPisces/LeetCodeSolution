package MaximumBinaryTree;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 Construct the maximum tree by the given array and output the root node of this tree.

 Example 1:
 Input: [3,2,1,6,0,5]
 Output: return the tree root node representing the following tree:

 6
 /   \
 3     5
 \    /
 2  0
 \
 1
 Note:
 The size of the given array will be in the range [1,1000].

 * Created by aoshen on 8/6/17.
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int idx = start;
        int max = nums[start];

        for (int i = start + 1;i <= end;++ i) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, start, idx - 1);
        root.right = helper(nums, idx + 1, end);

        return root;
    }
}
