package GroupAnagrams;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.

    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Return:

    [
    ["ate", "eat","tea"],
    ["nat","tan"],
    ["bat"]
    ]
    Note:

    For the return value, each inner list's elements must follow the lexicographic order.
    All inputs will be in lower-case.
 *
 * Created by aoshen on 5/7/16.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return results;
        }

        Map<String, List<String>> hm = new HashMap<>();

        for (String str : strs) {
            if (str != null) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String sortedStr = new String(arr);

                if (hm.containsKey(sortedStr)) {
                    hm.get(sortedStr).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    hm.put(sortedStr, list);
                }
            }
        }

        for (List<String> result: hm.values()) {
            Collections.sort(result);
            results.add(result);
        }

        return results;
    }
}
