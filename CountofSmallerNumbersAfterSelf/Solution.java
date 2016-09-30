package CountofSmallerNumbersAfterSelf;

import java.util.*;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

    Example:

    Given nums = [5, 2, 6, 1]

    To the right of 5 there are 2 smaller elements (2 and 1).
    To the right of 2 there is only 1 smaller element (1).
    To the right of 6 there is 1 smaller element (1).
    To the right of 1 there is 0 smaller element.
    Return the array [2, 1, 1, 0].
 *
 * Created by aoshen on 5/30/16.
 */
public class Solution {

    class TreeNode {
        int val = 0;
        int count  = 1;
        int leftSize = 0;
        int rightSize = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
            count = 1;
            leftSize = 0;
            rightSize = 0;
        }
    }


    private TreeNode insertTreeNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val == val) {
            root.count ++;
        } else if (root.val > val) {
            root.leftSize ++;
            root.left = insertTreeNode(root.left, val);
        } else {
            root.rightSize ++;
            root.right = insertTreeNode(root.right, val);
        }

        return root;
    }

    private int findSmallerNumber(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        if (root.val == val) {
            return root.leftSize;
        } else if (root.val > val) {
            return findSmallerNumber(root.left, val);
        } else {
            return root.leftSize + root.count + findSmallerNumber(root.right, val);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        int end = nums.length - 1;
        results.add(0);
        TreeNode root = new TreeNode(nums[end]);

        for (end = end - 1;end >= 0;-- end) {
            results.add(0, findSmallerNumber(root, nums[end]));
            insertTreeNode(root, nums[end]);
        }
        return results;
    }
}

