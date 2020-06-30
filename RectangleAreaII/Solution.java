package RectangleAreaII;

import java.util.*;

/**
 *
 We are given a list of (axis-aligned) rectangles.  Each rectangle[i] = [x1, y1, x2, y2] ,
 where (x1, y1) are the coordinates of the bottom-left corner,
 and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.

 Find the total area covered by all rectangles in the plane.
 Since the answer may be too large, return it modulo 10^9 + 7.

 Example 1:

 Input: [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 Output: 6
 Explanation: As illustrated in the picture.
 Example 2:

 Input: [[0,0,1000000000,1000000000]]
 Output: 49
 Explanation: The answer is 10^18 modulo (10^9 + 7), which is (10^9)^2 = (-7)^2 = 49.
 */
class Solution {
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 1, CLOSE = -1;
        int[][] events = new int[rectangles.length * 2][];
        Set<Integer> Xvals = new HashSet();
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
            Xvals.add(rec[0]);
            Xvals.add(rec[2]);
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        Integer[] X = Xvals.toArray(new Integer[0]);
        Arrays.sort(X);
        Map<Integer, Integer> Xi = new HashMap();
        for (int i = 0; i < X.length; ++i)
            Xi.put(X[i], i);

        Node active = new Node(0, X.length - 1, X);
        long ans = 0;
        long cur_x_sum = 0;
        int cur_y = events[0][0];

        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
            ans += cur_x_sum * (y - cur_y);
            cur_x_sum = active.update(Xi.get(x1), Xi.get(x2), typ);
            cur_y = y;

        }

        ans %= 1_000_000_007;
        return (int) ans;
    }
}

class Node {
    int start, end;
    Integer[] X;
    Node left, right;
    int count;
    long total;

    public Node(int start, int end, Integer[] X) {
        this.start = start;
        this.end = end;
        this.X = X;
        left = null;
        right = null;
        count = 0;
        total = 0;
    }

    public int getRangeMid() {
        return start + (end - start) / 2;
    }

    public Node getLeft() {
        if (left == null) left = new Node(start, getRangeMid(), X);
        return left;
    }

    public Node getRight() {
        if (right == null) right = new Node(getRangeMid(), end, X);
        return right;
    }

    public long update(int i, int j, int val) {
        if (i >= j) return 0;
        if (start == i && end == j) {
            count += val;
        } else {
            getLeft().update(i, Math.min(getRangeMid(), j), val);
            getRight().update(Math.max(getRangeMid(), i), j, val);
        }

        if (count > 0) total = X[end] - X[start];
        else total = getLeft().total + getRight().total;

        return total;
    }

    /**
     *    public int rectangleArea(int[][] rectangles) {
     *
     *         int mod = (int)Math.pow(10,9)+7;
     *         long res = 0;
     *         List<int[]> recList = new ArrayList<>();
     *         for(int[] rec : rectangles)
     *             addRectangle(recList, rec, 0);
     *
     *         for(int[] rec: recList)
     *             res = (res+((long)(rec[2]-rec[0])*(long)(rec[3]-rec[1])))%mod;
     *
     *         return (int) res%mod;
     *     }
     *
     *     // Add new rectangle to the list. In case of overlap break up new rectangle into
     *     // non-overlapping rectangles. Compare the new rectanlges with the rest of the list.
     *     public void addRectangle(List<int[]> recList, int[] curRec, int start){
     *         if(start>=recList.size()){
     *             recList.add(curRec);
     *             return;
     *         }
     *
     *         int[] r = recList.get(start);
     *
     *         // No overlap
     *         if(curRec[2]<=r[0] || curRec[3]<=r[1] || curRec[0]>=r[2] || curRec[1]>=r[3]){
     *             addRectangle(recList, curRec, start+1);
     *             return;
     *         }
     *
     *         if( curRec[0]<r[0])
     *             addRectangle(recList, new int[]{curRec[0],curRec[1],r[0],curRec[3]},start+1);
     *
     *         if(curRec[2]>r[2])
     *             addRectangle(recList, new int[]{r[2],curRec[1],curRec[2],curRec[3]},start+1);
     *
     *         if(curRec[1]<r[1])
     *             addRectangle(recList, new int[]{Math.max(r[0],curRec[0]),curRec[1],Math.min(r[2],curRec[2]),r[1]},start+1);
     *
     *         if(curRec[3]>r[3])
     *             addRectangle(recList, new int[]{Math.max(r[0],curRec[0]),r[3],Math.min(r[2],curRec[2]),curRec[3]},start+1);
     *     }
     */
}
