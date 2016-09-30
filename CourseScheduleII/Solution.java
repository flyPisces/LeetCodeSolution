package CourseScheduleII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

 * Created by aoshen on 6/15/16.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return null;
        }

        int len = prerequisites.length;
        int[] orders = new int[numCourses];
        int noPreCount = 0;
        int index = 0;

        Queue<Integer> queue = new LinkedList<>();
        int[] preCount = new int[numCourses];

        for (int i = 0;i < len;++ i) {
            int[] arr = prerequisites[i];
            preCount[arr[0]] ++;
        }

        for (int i = 0;i < numCourses;++ i) {
            if (preCount[i] == 0) {
                queue.add(i);
                orders[index++] = i;
                noPreCount ++;
            }
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();

            for (int i = 0;i < len;++ i) {
                int[] arr = prerequisites[i];

                if (top == arr[1]) {
                    preCount[arr[0]] --;

                    if (preCount[arr[0]] == 0) {
                        queue.add(arr[0]);
                        orders[index++] = arr[0];
                        noPreCount ++;
                    }
                }
            }
        }

        if (noPreCount == numCourses) {
            return orders;
        }

        return new int[0];
    }
}
