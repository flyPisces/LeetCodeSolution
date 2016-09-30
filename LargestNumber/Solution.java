package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

    For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

    Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Created by aoshen on 5/18/16.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        Integer[] ints = new Integer[nums.length];
        for (int i = 0;i != ints.length;++ i) {
            ints[i] = nums[i];
        }

        String result = "";

        Arrays.sort(ints, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2){
                String str1 = String.valueOf(n1);
                String str2 = String.valueOf(n2);
                return (str2 + str1).compareTo(str1 + str2);
            }
        });

        if (ints[0] == 0) {
            return "0";
        }

        for (int i = 0;i != ints.length;++ i) {
            result += ints[i];
        }

        return result;
    }
}
