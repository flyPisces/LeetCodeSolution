package StampingTheSequence;

import java.util.*;

/**
 * You want to form a target string of lowercase letters.

 At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.

 On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.

 For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)

 If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.

 For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".

 Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.  Any answers specifying more than this number of moves will not be accepted.



 Example 1:

 Input: stamp = "abc", target = "ababc"
 Output: [0,2]
 ([1,0,2] would also be accepted as an answer, as well as some other answers.)
 Example 2:

 Input: stamp = "abca", target = "aabcaca"
 Output: [3,0,1]

 */
public class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int M = stamp.length(), N = target.length();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] done = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        List<Node> A = new ArrayList<>();

        for (int i = 0;i <= N - M;++ i) {
            Set<Integer> made = new HashSet<>();
            Set<Integer> todo = new HashSet<>();
            for (int j = 0;j < M;++ j) {
                if (target.charAt(i + j) == stamp.charAt(j)) {
                    made.add(i + j);
                } else {
                    todo.add(i + j);
                }
            }

            A.add(new Node(made, todo));

            if (todo.isEmpty()) {
                stack.push(i);
                for (int j = i;j < i + M;++ j) {
                    if (!done[j]) {
                        queue.add(j);
                        done[j] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int j = Math.max(0, i - M + 1);j <= Math.min(N - M, i);++ j) {
                if (A.get(j).todo.contains(i)) {
                    A.get(j).todo.remove(i);

                    if (A.get(j).todo.isEmpty()) {
                        stack.push(j);

                        for (int k : A.get(j).made) {
                            if (!done[k]) {
                                queue.add(k);
                                done[k] = true;
                            }
                        }
                    }
                }
            }
        }

        for (boolean b : done) {
            if (!b) {
                return new int[0];
            }
        }

        int[] ret = new int[stack.size()];
        int t = 0;
        while (!stack.isEmpty()) {
            ret[t ++] = stack.pop();
        }

        return ret;
    }
}

class Node {
    Set<Integer> made, todo;

    Node(Set<Integer> made, Set<Integer> todo) {
        this.made = made;
        this.todo = todo;
    }
}
