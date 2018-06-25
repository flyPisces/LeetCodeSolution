package ReachingPoints;

/**
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).

 Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

 Examples:
 Input: sx = 1, sy = 1, tx = 3, ty = 5
 Output: True
 Explanation:
 One series of moves that transforms the starting point to the target is:
 (1, 1) -> (1, 2)
 (1, 2) -> (3, 2)
 (3, 2) -> (3, 5)

 Input: sx = 1, sy = 1, tx = 2, ty = 2
 Output: False

 Input: sx = 1, sy = 1, tx = 1, ty = 1
 Output: True
 */
public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx = tx % ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty = ty % tx;
                else return (ty - sy) % tx == 0;
            }
        }

        return sx == tx && sy == ty;
    }
}
