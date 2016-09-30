package ShuffleanArray;

/**
 * Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();

 * Created by aoshen on 8/12/16.
 */
public class Solution {

    int[] originals;
    int[] shuffled;

    public Solution(int[] nums) {
        if (nums == null) {
            originals = null;
            shuffled = null;
            return;
        }

        originals = new int[nums.length];
        shuffled = new int[nums.length];

        System.arraycopy(nums, 0, originals, 0, nums.length);
        System.arraycopy(nums, 0, shuffled, 0, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        System.arraycopy(originals, 0, shuffled, 0, originals.length);
        return shuffled;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0;i < shuffled.length;++ i) {
            int next = i + (int)(Math.random() * (shuffled.length - i));

            int temp = shuffled[i];
            shuffled[i] = shuffled[next];
            shuffled[next] = temp;
        }

        return shuffled;
    }
}
