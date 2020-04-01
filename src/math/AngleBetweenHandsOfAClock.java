package math;

/**
 * Date 01.04.2020.
 *
 *  1344. Angle Between Hands of a Clock
 *
 *  Given two numbers, hour and minutes.
 *  Return the smaller angle (in degrees) formed between the hour and the minute hand.
 *
 *  https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        int degreeBetweenHours = 360/12;

        double minutesDegree = (double) minutes/60 * 360;

        double hourDegree = degreeBetweenHours * (hour + (double) minutes/60);

        double res = Math.abs(minutesDegree - hourDegree);

        return res > 180 ? 360 - res : res;
    }
}
