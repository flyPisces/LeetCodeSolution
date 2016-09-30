package IntersectionofTwoArrays;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.

 * Created by aoshen on 6/1/16.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (null == nums1 || null == nums2 || nums1.length == 0 || nums2.length == 0) {
            int[] res = new int[0];
            return res;
        }

        for (int i = 0;i < nums1.length;++ i) {
            if (i == 0 || (i != 0 && nums1[i] != nums1[i - 1])) {
                if (Arrays.binarySearch(nums2, nums1[i]) > - 1) {
                    result.add(nums1[i]);
                }
            }
        }

        int size = result.size();
        int[] res = new int[size];
        int index = 0;
        for (Integer i : result) {
            res[index ++] = i;
        }

        return res;
    }
}
