package JumpGameIV;

import java.util.*;

/**
 *
 Given an array of integers arr, you are initially positioned at the first index of the array.

 In one step you can jump from index i to index:

 i + 1 where: i + 1 < arr.length.
 i - 1 where: i - 1 >= 0.
 j where: arr[i] == arr[j] and i != j.
 Return the minimum number of steps to reach the last index of the array.

 Notice that you can not jump outside of the array at any time.



 Example 1:

 Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 Output: 3
 Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 Example 2:

 Input: arr = [7]
 Output: 0
 Explanation: Start index is the last index. You don't need to jump.
 Example 3:

 Input: arr = [7,6,9,6,9,6,9,7]
 Output: 1
 Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 Example 4:

 Input: arr = [6,1,9]
 Output: 2
 Example 5:

 Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 Output: 3
 */
public class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> neighborsMap = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            neighborsMap.putIfAbsent(arr[i], new ArrayList<>());
            neighborsMap.get(arr[i]).add(i);
        }

        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; ++k) {
                int top = queue.poll();
                if (top == arr.length - 1) {
                    return result;
                }

                List<Integer> neighbors = neighborsMap.get(arr[top]);
                neighbors.add(top - 1);
                neighbors.add(top + 1);
                for (int neighbor : neighbors) {
                    if (neighbor >= 0 && neighbor < arr.length && !visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
                neighbors.clear();
            }

            result ++;
        }

        return -1;
    }
}
