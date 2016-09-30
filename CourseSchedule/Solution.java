package CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 * Created by aoshen on 6/13/16.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (numCourses == 0 || len == 0) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] preCount = new int[numCourses];

        for (int i = 0;i < len;++ i) {
            int[] arr = prerequisites[i];
            preCount[arr[0]] ++;
        }

        for (int i = 0;i < numCourses;++ i) {
            if (preCount[i] == 0) {
                queue.add(i);
            }
        }

        int numNoPre = queue.size();

        while (!queue.isEmpty()) {
            int top = queue.poll();

            for (int i = 0;i < len;++ i) {
                int[] arr = prerequisites[i];

                if (top == arr[1]) {
                    preCount[arr[0]] --;

                    if (preCount[arr[0]] == 0) {
                        numNoPre ++;
                        queue.add(arr[0]);
                    }
                }
            }
        }

        return numCourses == numNoPre;
    }
}
