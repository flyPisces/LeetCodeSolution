package TimeNeededtoInformAllEmployees;

import java.util.*;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.
 *
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.
 *
 * The head of the company wants to inform all the employees of the company of an urgent piece of news. He will inform his direct subordinates and they will inform their subordinates and so on until all employees know about the urgent news.
 *
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).
 *
 * Return the number of minutes needed to inform all the employees about the urgent news.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
 * Output: 0
 * Explanation: The head of the company is the only employee in the company.
 */
public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result = 0;

        List<Integer>[] neighbors = new List[n];
        for (int i = 0;i < n;++ i) {
            neighbors[i] = new ArrayList<>();
        }

        for (int i = 0;i < n;++ i) {
            if (i == headID) continue;
            neighbors[manager[i]].add(i);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {headID, 0});

        while (!queue.isEmpty()) {
            int id = queue.peek()[0], w = queue.poll()[1];
            result = Math.max(result, w);
            for (int neighbor : neighbors[id]) {
                queue.offer(new int[] {neighbor, informTime[id] + w});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.numOfMinutes(6, 2, new int[] {2,2,-1,2,2,2}, new int[] {0,0,1,0,0,0});
    }
}
