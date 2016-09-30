package SuperPow;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8
 Example2:

 a = 2
 b = [1,0]

 Result: 1024

 * Created by aoshen on 8/12/16.
 */
public class Solution {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    public int superPow(int a, int[] b, int index) {
        if (index < 0) return 1;
        a = a % 1337;

        int lastBit = b[index];

        return (superPow(superPow(a, b, index - 1), 10) * superPow(a, lastBit)) % 1337;
    }

    public int superPow(int a, int k) {
        if (k == 0) return 1;
        int ans = 1;
        for (int i = 1;i <= k;++ i) ans = (ans * a) % 1337;

        return ans;
    }
}
