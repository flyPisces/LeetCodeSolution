package VerifyPreorderSequenceinBST;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

 You may assume each number in the sequence is unique.

 Follow up:
 Could you do it using only constant space complexity?

 *
 * Created by aoshen on 8/3/16.
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int i = -1;
        int min = Integer.MIN_VALUE;

        for (int num : preorder) {
            if (num < min) return false;

            while (i < preorder.length && num > preorder[i]) {
                min = preorder[i];
                i --;
            }

            preorder[++ i] = num;
        }

        return true;
    }
}
