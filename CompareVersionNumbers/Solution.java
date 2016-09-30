package CompareVersionNumbers;

/**
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 *
 * Created by aoshen on 5/26/16.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] splits1 = version1.split("\\.");
        String[] splits2 = version2.split("\\.");

        int i = 0;
        for (;i < splits1.length && i < splits2.length;++ i) {
            int val1 = Integer.parseInt(splits1[i]);
            int val2 = Integer.parseInt(splits2[i]);

            if (val1 < val2)
                return -1;
            if (val1 > val2)
                return 1;
        }

        for (;i < splits1.length;++ i) {
            int val = Integer.parseInt(splits1[i]);

            if (val != 0)
                return 1;
        }
        for (;i < splits2.length;++ i) {
            int val = Integer.parseInt(splits2[i]);

            if (val != 0)
                return -1;
        }

        return 0;
    }
}
