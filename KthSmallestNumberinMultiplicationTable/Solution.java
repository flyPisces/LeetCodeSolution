package KthSmallestNumberinMultiplicationTable;

/**
 * Nearly every one have used the Multiplication Table.
 * But could you find out the k-th smallest number quickly from the multiplication table?

 Given the height m and the length n of a m * n Multiplication Table, and a positive integer k,
 you need to return the k-th smallest number in this table.

 Example 1:
 Input: m = 3, n = 3, k = 5
 Output:
 Explanation:
 The Multiplication Table:
 1	2	3
 2	4	6
 3	6	9

 The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 Example 2:
 Input: m = 2, n = 3, k = 6
 Output:
 Explanation:
 The Multiplication Table:
 1	2	3
 2	4	6

 The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 */
public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start = 1, end = m * n;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (count(m, n, mid) >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    private int count(int m, int n, int v) {
        int sum = 0;

        for (int i = 1;i <= m;++ i) {
            sum += Math.min(n, v / i);
        }

        return sum;
    }
}
