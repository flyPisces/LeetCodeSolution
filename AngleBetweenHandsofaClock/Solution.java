package AngleBetweenHandsofaClock;

/**
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 */
public class Solution {
    public double angleClock(int hour, int minutes) {
        double angle1 = (hour % 12) * 30 + ((double)minutes / 60 * 30);
        double angle2 = (double) minutes * 6;

        double angle = Math.abs(angle1 - angle2);

        if (angle > 180) angle = 360 - angle;

        return angle;
    }
}
