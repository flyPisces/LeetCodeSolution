package DayoftheYear;

/**
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.



 Example 1:

 Input: date = "2019-01-09"
 Output: 9
 Explanation: Given date is the 9th day of the year in 2019.
 Example 2:

 Input: date = "2019-02-10"
 Output: 41
 Example 3:

 Input: date = "2003-03-01"
 Output: 60
 Example 4:

 Input: date = "2004-03-01"
 Output: 61

 */
public class Solution {
    public int dayOfYear(String date) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] splits = date.split("-");

        int year = Integer.parseInt(splits[0]);
        int month = Integer.parseInt(splits[1]);
        int day = Integer.parseInt(splits[2]);
        boolean haoyue = isHaoyue(year);

        int sum = 0;
        for (int i = 1;i < month;++ i) {
            if (i == 2 && haoyue) {
                sum ++;
            }

            sum += days[i - 1];
        }

        return sum + day;
    }

    private boolean isHaoyue(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }

        return false;
    }
}
