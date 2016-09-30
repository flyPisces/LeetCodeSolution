package StrobogrammaticNumber;

import java.util.*;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Write a function to determine if a number is strobogrammatic. The number is represented as a string.

    For example, the numbers "69", "88", and "818" are all strobogrammatic.

 * Created by aoshen on 7/19/16.
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        
        Map<Character, Character> strobogrammaticMap = new HashMap<>();
        strobogrammaticMap.put('1', '1');
        strobogrammaticMap.put('0', '0');
        strobogrammaticMap.put('8', '8');
        strobogrammaticMap.put('6', '9');
        strobogrammaticMap.put('9', '6');

        int left = 0,right = num.length() - 1;

        while (left <= right) {
            char cleft = num.charAt(left);
            char cright = num.charAt(right);

            if (!strobogrammaticMap.containsKey(cleft) || !strobogrammaticMap.get(cleft).equals(cright)) {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
