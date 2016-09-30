package NestedListWeightSumTwo;

import java.util.*;

/**
 * Created by aoshen on 8/16/16.
 */
public interface NestedInteger {

    //public NestedInteger();
    //public NestedInteger(int value);
    public boolean isInteger();


    public Integer getInteger();

    public void setInteger(int value);

    public void add(NestedInteger ni);

    public List<NestedInteger> getList();
}
