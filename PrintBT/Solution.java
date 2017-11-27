package PrintBT;

import java.util.*;

/**
 * Print a binary tree in an m*n 2D string array following these rules:

 The row number m should be equal to the height of the given binary tree.
 The column number n should always be an odd number.
 The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 Each unused space should contain an empty string "".
 Print the subtrees following the same rules.
 Example 1:
 Input:
 1
 /
 2
 Output:
 [["", "1", ""],
 ["2", "", ""]]
 Example 2:
 Input:
 1
 / \
 2   3
 \
 4
 Output:
 [["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
 Example 3:
 Input:
 1
 / \
 2   5
 /
 3
 /
 4
 Output:

 [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]

 * Created by aoshen on 8/7/17.
 */
public class Solution {
    int rows = 0;

    public List<List<String>> printTree(TreeNode root) {
        if (null == root) return null;

        rows = getHeight(root);
        int columns = (1 << rows) - 1;
        Map<String, String> marks = new HashMap<>();
        mark(root, 0, 0, columns - 1, marks);

        List<List<String>> results = new ArrayList<>();
        for (int i = 0;i < rows;++ i) {
            List<String> result = new ArrayList<>();

            for (int j = 0;j < columns;++ j) {
                if (marks.containsKey(i + "," + j)) {
                    result.add(marks.get(i + "," + j));
                } else {
                    result.add("");
                }
            }

            results.add(result);
        }

        return results;
    }

    private void mark(TreeNode root, int level, int left, int right, Map<String, String> marks) {
        if (level == rows) return;

        if (root != null) {
            int idx = (left + right) / 2;

            marks.put(level + "," + idx, root.val + "");

            mark(root.left, level + 1, left, idx - 1, marks);
            mark(root.right, level + 1, idx + 1, right, marks);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
