package MinimizeMaxDistancetoGastation;

/**
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

 Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

 Return the smallest possible value of D.

 Example:

 Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 Output: 0.500000
 */
public class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double low = 0, high = 1e8;

        while (high - low > 1e-6) {
            double mid = (high + low) / 2;
            if (possible(mid, stations, K)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    private boolean possible(double D, int[] stations, int K) {
        int used = 0;

        for (int i = 0;i < stations.length - 1;++ i) {
            used += ((stations[i + 1] - stations[i]) / D);
        }

        return used <= K;
    }
}