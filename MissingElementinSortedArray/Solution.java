package MissingElementinSortedArray;

/**
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.



 Example 1:

 Input: A = [4,7,9,10], K = 1
 Output: 5
 Explanation:
 The first missing number is 5.
 Example 2:

 Input: A = [4,7,9,10], K = 3
 Output: 8
 Explanation:
 The missing numbers are [5,6,8,...], hence the third missing number is 8.
 Example 3:

 Input: A = [1,2,4], K = 3
 Output: 6
 Explanation:
 The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 */
public class Solution {
    public int missingElement(int[] nums, int k) {
        int N = nums.length, left = 0, right = N - 1;
        int missingNum = nums[right] - nums[left] + 1 - N;

        if (missingNum < k) {
            return nums[right] + k - missingNum;
        }

        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            int temp = (nums[mid] - nums[left] + 1) - (mid - left + 1);

            if (temp >= k) {
                right = mid;
            } else {
                k = k - temp;
                left = mid;
            }
        }

        return nums[left] + k;
    }
}
