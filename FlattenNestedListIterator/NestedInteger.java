package FlattenNestedListIterator;

import java.util.*;

/**
 * Created by aoshen on 7/21/16.
 */
public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    public List<NestedInteger> getList();
}
