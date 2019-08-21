package StatisticsfromaLargeSample;

/**
 * We sampled integers between 0 and 255, and stored the results in an array count:  count[k] is the number of integers we sampled equal to k.

 Return the minimum, maximum, mean, median, and mode of the sample respectively, as an array of floating point numbers.  The mode is guaranteed to be unique.

 (Recall that the median of a sample is:

 The middle element, if the elements of the sample were sorted and the number of elements is odd;
 The average of the middle two elements, if the elements of the sample were sorted and the number of elements is even.)


 Example 1:

 Input: count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 Output: [1.00000,3.00000,2.37500,2.50000,3.00000]
 Example 2:

 Input: count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 Output: [1.00000,4.00000,2.18182,2.00000,1.00000]
 */
public class Solution {
    public double[] sampleStats(int[] count) {
        double min = -1, max = 0, mean = 0, median = 0, mode = 0, sum = 0;
        int total = 0;

        for (int i = 0;i < 256;++ i) {
            if (count[i] > 0) {
                if (min < 0) min = i;
                max = i;
                total += count[i];
                sum += count[i] * i;
                if (count[i] > count[(int)mode])
                    mode = i;
            }
        }

        mean = sum / total;
        if (total == 1) {
            median = sum;
        } else {
            int m1 = (total + 1) / 2, m2 = total / 2 + 1;
            for (int i = 0, cnt = 0;i < 256;++ i) {

                if (cnt < m1 && cnt + count[i] >= m1)
                    median += (double) i / 2;

                if (cnt < m2 && cnt + count[i] >= m2)
                    median += (double) i / 2;

                cnt += count[i];
            }
        }

        return new double[]{min, max, mean, median, mode};
    }
}
