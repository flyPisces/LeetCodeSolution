package PowerXN;

/**
 * Implement pow(x, n).
 *
 * Created by aoshen on 4/9/16.
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double temp = power(x, n / 2);

        if (n % 2 == 0) {
            return  temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}
