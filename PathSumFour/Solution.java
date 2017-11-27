package PathSumFour;

/**
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

 For each integer in this list:
 The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 The units digit represents the value V of this node, 0 <= V <= 9.
 Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

 Example 1:
 Input: [113, 215, 221]
 Output: 12
 Explanation:
 The tree that the list represents is:
 3
 / \
 5   1

 The path sum is (3 + 5) + (3 + 1) = 12.
 Example 2:
 Input: [113, 221]
 Output: 4
 Explanation:
 The tree that the list represents is:
 3
 \
 1

 The path sum is (3 + 1) = 4.
 */

public class Solution {
    public int pathSum(int[] nums) {
        int[][] res = new int[5][8];
        for (int num : nums) {
            int i = num / 100;
            int j = (num % 100) / 10 - 1;
            int v = num % 10;

            res[i][j] = res[i - 1][j / 2] + v;
        }

        int sum = 0;

        for (int i = 1;i < 5;++ i) {
            for (int j = 0;j < 8;++ j) {
                if ((i == 4) || (res[i][j] != 0 && res[i + 1][2 * j] == 0 && res[i + 1][2 * j + 1] == 0)) {
                    sum += res[i][j];
                }
            }
        }

        return sum;
    }
}
