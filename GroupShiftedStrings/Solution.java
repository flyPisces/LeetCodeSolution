package GroupShiftedStrings;

import java.rmi.MarshalledObject;
import java.util.*;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

    "abc" -> "bcd" -> ... -> "xyz"
    Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

    For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
    A solution is:

    [
    ["abc","bcd","xyz"],
    ["az","ba"],
    ["acef"],
    ["a","z"]
    ]

 * Created by aoshen on 7/9/16.
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> results = new ArrayList<>();

        if (null == strings || strings.length == 0) return results;
        Map<String, List<String>> helperMapping = new HashMap<>();

        for (String str: strings) {
            char[] arr = str.toCharArray();

            if (arr.length > 0) {
                int diff = arr[0] - 'a';

                for (int i = 0;i < arr.length;++ i) {
                    if (arr[i] - diff < 'a') {
                        arr[i] = (char) (arr[i] -diff + 26);
                    } else {
                        arr[i] = (char) (arr[i] - diff);
                    }
                }
            }

            String ns = new String(arr);

            if (helperMapping.containsKey(ns)) {
                helperMapping.get(ns).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                helperMapping.put(ns, list);
            }
        }

        for (Map.Entry<String, List<String>> entry: helperMapping.entrySet()) {
            Collections.sort(entry.getValue());
        }

        results.addAll(helperMapping.values());

        return results;
    }
}
