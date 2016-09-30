package GasStation;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 * Created by aoshen on 4/25/16.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }

        int total = 0;
        int sum = 0;
        int index = 0;

        for (int i = 0;i != gas.length;++ i) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];

            if (sum < 0) {
                sum = 0;
                index = i + 1;
            }
        }

        if (total < 0) {
            return -1;
        }

        return index;
    }
}
