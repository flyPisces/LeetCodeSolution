package HIndex;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

 * Created by aoshen on 6/18/16.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int result = 0;

        Arrays.sort(citations);
        for (int i = 0;i < citations.length;++ i) {
            int localResult = Math.min(citations[i], citations.length - i);
            result = Math.max(result, localResult);
        }

        return result;
    }
}
