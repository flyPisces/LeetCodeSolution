package NextClosestTime;

import java.util.*;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.

 You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
 "1:34", "12:9" are all invalid.

 Example 1:

 Input: "19:34"
 Output: "19:39"
 Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 It is not 19:33, because this occurs 23 hours and 59 minutes later.

 Example 2:

 Input: "23:59"
 Output: "22:22"
 Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class Solution {
    public String nextClosestTime(String time) {
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);

        Set<String> timeSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        String candidate = ""+digits[i]+""+digits[j]+":"+digits[k]+""+digits[l];
                        if (isValidTime(candidate)) timeSet.add(candidate);
                    }
                }
            }
        }

        List<String> timeList = new ArrayList<>();
        timeList.addAll(timeSet);
        Collections.sort(timeList);
        int index = timeList.indexOf(time);
        return index==timeList.size()-1 ? timeList.get(0) : timeList.get(index+1);

    }

    public boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }
}
