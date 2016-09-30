package Flatten2DVector;

import java.util.*;

/**
 * Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

 * Created by aoshen on 7/25/16.
 */
public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> it;
    Iterator<Integer> curr;

    public Vector2D(List<List<Integer>> vec2d) {
        it = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return curr.next();
    }

    @Override
    public boolean hasNext() {
        while ((curr == null || !curr.hasNext()) && it.hasNext()) {
            curr = it.next().iterator();
        }

        return curr != null && curr.hasNext();
    }
}
