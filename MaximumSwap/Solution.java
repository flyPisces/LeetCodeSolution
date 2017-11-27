package MaximumSwap;


/**
 Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 Return the maximum valued number you could get.

 Example 1:
 Input: 2736
 Output: 7236
 Explanation: Swap the number 2 and the number 7.
 Example 2:
 Input: 9973
 Output: 9973
 Explanation: No swap.
 */
public class Solution {
    public int maximumSwap(int num) {
        char[] arrs = String.valueOf(num).toCharArray();

        int[] buckets= new int[10];
        for (int i = 0;i < arrs.length;++ i) {
            buckets[arrs[i] - '0'] = i;
        }

        for (int i = 0;i < arrs.length;++ i) {
            for (int k = 9;k > arrs[i] - '0';-- k) {
                if (buckets[k] > i) {
                    char tmp = arrs[i];
                    arrs[i] = arrs[buckets[k]];
                    arrs[buckets[k]] = tmp;

                    return Integer.valueOf(new String(arrs));
                }
            }
        }

        return num;
    }
}
