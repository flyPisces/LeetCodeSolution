package ImplementRand10UsingRand7;

/**
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
 *
 * Do NOT use system's Math.random().
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: [7]
 * Example 2:
 *
 * Input: 2
 * Output: [8,4]
 * Example 3:
 *
 * Input: 3
 * Output: [8,1,10]
 */
public class Solution {
    public int rand7() {
        return 0;
    }

    public int rand10() {
        int result = 40;

        while (result >= 40) {
            result = (rand7() - 1) * 7 + (rand7() - 1);
        }

        return result % 10 + 1;
    }
}
