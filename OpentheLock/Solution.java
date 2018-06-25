package OpentheLock;

import java.util.*;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

 The lock initially starts at '0000', a string representing the state of the 4 wheels.

 You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

 Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

 Example 1:
 Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 Output: 6
 Explanation:
 A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 because the wheels of the lock become stuck after the display becomes the dead end "0102".
 Example 2:
 Input: deadends = ["8888"], target = "0009"
 Output: 1
 Explanation:
 We can turn the last wheel in reverse to move from "0000" -> "0009".
 Example 3:
 Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 Output: -1
 Explanation:
 We can't reach the target without getting stuck.
 Example 4:
 Input: deadends = ["0000"], target = "8888"
 Output: -1
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }

        if (target.equals("0000")) return 0;
        if (deads.contains("0000")) return -1;
        deads.add("0000");

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        for (int d = 1;!queue.isEmpty();++ d) {
            for (int n = queue.size();n > 0;-- n) {
                String curr = queue.poll();
                for (int i = 0;i < 4;++ i) {
                    for (int diff = 1;diff <= 9;diff = diff + 8) {
                        char[] arr = curr.toCharArray();
                        arr[i] = (char)((arr[i] - '0' + diff) % 10 + '0');
                        String newStr = new String(arr);
                        if (newStr.equals(target)) return d;
                        if (visited.contains(newStr) || deads.contains(newStr)) continue;
                        visited.add(newStr);
                        queue.add(newStr);
                    }
                }
            }
        }

        return -1;
    }
}
