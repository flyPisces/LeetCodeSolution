package FirstMissingPositive;

/**
 * Total Accepted: 97798
 Total Submissions: 385979
 Difficulty: Hard
 Contributor: LeetCode
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 * Created by aoshen on 6/13/17.
 */



    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Base case.
            int contains = 0;
            for (int i = 0; i < n; i++)
                if (nums[i] == 1) {
                    contains++;
                    break;
                }

            if (contains == 0)
                return 1;

            // nums = [1]
            if (n == 1)
                return 2;

            // Replace negative numbers, zeros,
            // and numbers larger than n by 1s.
            // After this convertion nums will contain
            // only positive numbers.
            for (int i = 0; i < n; i++)
                if ((nums[i] <= 0) || (nums[i] > n))
                    nums[i] = 1;

            // Use index as a hash key and number sign as a presence detector.
            // For example, if nums[1] is negative that means that number `1`
            // is present in the array.
            // If nums[2] is positive - number 2 is missing.
            for (int i = 0; i < n; i++) {
                int a = Math.abs(nums[i]);
                // If you meet number a in the array - change the sign of a-th element.
                // Be careful with duplicates : do it only once.
                if (a == n)
                    nums[0] = - Math.abs(nums[0]);
                else
                    nums[a] = - Math.abs(nums[a]);
            }

            // Now the index of the first positive number
            // is equal to first missing positive.
            for (int i = 1; i < n; i++) {
                if (nums[i] > 0)
                    return i;
            }

            if (nums[0] > 0)
                return n;

            return n + 1;


            /**
             *     int n = nums.length;
             *
             *     // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
             *     // (we can ignore those because if all number are > n then we'll simply return 1)
             *     for (int i = 0; i < n; i++) {
             *         if (nums[i] <= 0 || nums[i] > n) {
             *             nums[i] = n + 1;
             *         }
             *     }
             *     // note: all number in the array are now positive, and on the range 1..n+1
             *
             *     // 2. mark each cell appearing in the array, by converting the index for that number to negative
             *     for (int i = 0; i < n; i++) {
             *         int num = Math.abs(nums[i]);
             *         if (num > n) {
             *             continue;
             *         }
             *         num--; // -1 for zero index based array (so the number 1 will be at pos 0)
             *         if (nums[num] > 0) { // prevents double negative operations
             *             nums[num] = -1 * nums[num];
             *         }
             *     }
             *
             *     // 3. find the first cell which isn't negative (doesn't appear in the array)
             *     for (int i = 0; i < n; i++) {
             *         if (nums[i] >= 0) {
             *             return i + 1;
             *         }
             *     }
             *
             *     // 4. no positive numbers were found, which means the array contains all numbers 1..n
             *     return n + 1;
             */
        }
}

