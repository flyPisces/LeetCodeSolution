package ParallelCourses;

import java.util.*;

/**
 * There are N courses, labelled from 1 to N.
 *
 * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
 *
 * In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
 *
 * Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.
 */
public class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        int[] degree = new int[N + 1];
        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int[] relation : relations) {
            if (!dependencies.containsKey(relation[0])) {
                dependencies.put(relation[0], new ArrayList<>());
            }

            dependencies.get(relation[0]).add(relation[1]);
            ++ degree[relation[1]];
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1;i <= N;++ i) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        int semester = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size();size > 0;-- size) {
                int top = queue.poll();
                -- N;

                List<Integer> next = dependencies.get(top);
                if (next == null) continue;

                for (int num : next) {
                    -- degree[num];
                    if (degree[num] == 0) {
                        queue.offer(num);
                    }
                }

                next.clear();
            }

            semester ++;
        }

        return N != 0 ? -1 : semester;
    }
}
