package OptimalAccountBalancing;

import java.util.*;

/**
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

 Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

 Note:

 A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
 Example 1:

 Input:
 [[0,1,10], [2,0,5]]

 Output:
 2

 Explanation:
 Person #0 gave person #1 $10.
 Person #2 gave person #0 $5.

 Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
 Example 2:

 Input:
 [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

 Output:
 1

 Explanation:
 Person #0 gave person #1 $10.
 Person #1 gave person #0 $1.
 Person #1 gave person #2 $5.
 Person #2 gave person #0 $5.

 Therefore, person #1 only need to give person #0 $4, and all debt is settled.

 * Created by aoshen on 12/31/16.
 */
public class Solution {
    public int minTransfers(int[][] trans) {
        Map<Integer, Integer> net = new HashMap<>();
        for(int i = 0; i < trans.length; i++){
            net.put(trans[i][0], net.getOrDefault(trans[i][0], 0) - trans[i][2]);
            net.put(trans[i][1], net.getOrDefault(trans[i][1], 0) + trans[i][2]);
        }
        int res = 0;
        List<Integer> pos = new ArrayList<Integer>();
        List<Integer> neg = new ArrayList<Integer>();

        for(int i : net.values()){
            if(i > 0) pos.add(i);
            if(i < 0) neg.add(i);
        }
        int result = (pos.size() == 0) ? 0 : trans.length;

        for(int i = 0; i < pos.size(); i++){
            int first = pos.remove(0);
            pos.add(first);
            for(int j = 0; j < neg.size(); j++){
                int second = neg.remove(0);
                neg.add(second);
                result =Math.min(collapse(pos, neg), result);

            }
        }
        return result;
    }

    private int collapse(List<Integer> positive, List<Integer> negative){
        int count = 0;
        List<Integer> pos = new ArrayList<Integer>();
        pos.addAll(positive);
        List<Integer> neg = new ArrayList<Integer>();
        neg.addAll(negative);
        /*Optionally remove either one or both of the front element in 2 lists*/
        while(pos.size() != 0 && neg.size() != 0){
            if(pos.get(0) < Math.abs(neg.get(0))){
                neg.set(0, neg.get(0) + pos.get(0));
                pos.remove(0);
            }else if (pos.get(0) > Math.abs(neg.get(0))){
                pos.set(0, pos.get(0) + neg.get(0));
                neg.remove(0);
            }else{
                pos.remove(0);
                neg.remove(0);
            }
            count++;
        }
        return count;
    }
}
