package UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true

 * Created by aoshen on 7/13/16.
 */
public class Solution {

    private Map<String, Set<String>> abbrMapping = new HashMap<>();

    public Solution(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = word;

            if (word.length() > 2) {
                abbr = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
            }

            if (abbrMapping.containsKey(abbr)) {
                Set<String> sameAbbrWords = abbrMapping.get(abbr);
                sameAbbrWords.add(word);
            } else {
                Set<String> sameAbbrWords = new HashSet<>();
                sameAbbrWords.add(word);

                abbrMapping.put(abbr, sameAbbrWords);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = word;

        if (word.length() > 2) {
            abbr = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
        }

        if (!abbrMapping.containsKey(abbr)) return true;
        else return abbrMapping.get(abbr).contains(word) && abbrMapping.get(abbr).size() == 1;

    }
}
