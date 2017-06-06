package ArrayNesting;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].

 Sets S[K] for 0 <= K < N are defined as follows:

 S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

 Sets S[K] are finite for each K and should NOT contain duplicates.

 Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

 Example 1:
 Input: A = [5,4,0,3,1,6,2]
 Output: 4
 Explanation:
 A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

 One of the longest S[K]:
 S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

 * Created by aoshen on 5/29/17.
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[nums.length];

        for (int i = 0;i < nums.length;++i) {
            if (visited[i]) {
                continue;
            }

            max = Math.max(max, calcLen(nums, visited, i));
        }

        return max;
    }

    private int calcLen(int[] nums, boolean[] visited, int start) {
        int count = 0, i = start;

        while (count == 0 || i != start) {
            visited[i] = true;
            i = nums[i];
            count ++;
        }

        return count;
    }
}
