package HIndexTwo;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 *
 * Created by aoshen on 6/18/16.
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;

        int min = 0;
        int max = citations.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (citations[mid] < citations.length - mid) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return citations.length - min;
    }
}
