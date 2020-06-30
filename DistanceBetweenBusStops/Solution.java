package DistanceBetweenBusStops;

/**
 *
 A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

 The bus goes along both directions i.e. clockwise and counterclockwise.

 Return the shortest distance between the given start and destination stops.
 */

public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sumFromStartToDest = 0, totalSum = 0;
        int min = Math.min(start, destination), max = Math.max(start, destination);

        for (int i = 0;i < distance.length;++ i) {
            totalSum += distance[i];

            if (i >= min && i < max) {
                sumFromStartToDest += distance[i];
            }
        }

        return Math.min(totalSum - sumFromStartToDest, sumFromStartToDest);
    }
}
