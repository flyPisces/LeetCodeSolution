package FindtheCelebrity;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

 Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

 You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

 * Created by aoshen on 8/1/16.
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int start = 0, end = n - 1;

        while (start < end) {
            if (knows(start, end)) {
                start ++;
            } else {
                end --;
            }
        }

        for (int i = 0;i < n;++ i) {
            if (i == start) continue;
            if (knows(start, i) || !knows(i, start)) return -1;
        }

        return start;
    }
}
