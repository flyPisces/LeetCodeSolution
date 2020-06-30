package HTMLEntityParser;

import java.util.*;

/**
 * HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.
 *
 * The special characters and their entities for HTML are:
 *
 * Quotation Mark: the entity is &quot; and symbol character is ".
 * Single Quote Mark: the entity is &apos; and symbol character is '.
 * Ampersand: the entity is &amp; and symbol character is &.
 * Greater Than Sign: the entity is &gt; and symbol character is >.
 * Less Than Sign: the entity is &lt; and symbol character is <.
 * Slash: the entity is &frasl; and symbol character is /.
 * Given the input text string to the HTML parser, you have to implement the entity parser.
 *
 * Return the text after replacing the entities by the special characters.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "&amp; is an HTML entity but &ambassador; is not."
 * Output: "& is an HTML entity but &ambassador; is not."
 * Explanation: The parser will replace the &amp; entity by &
 * Example 2:
 *
 * Input: text = "and I quote: &quot;...&quot;"
 * Output: "and I quote: \"...\""
 * Example 3:
 *
 * Input: text = "Stay home! Practice on Leetcode :)"
 * Output: "Stay home! Practice on Leetcode :)"
 * Example 4:
 *
 * Input: text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * Output: "x > y && x < y is always false"
 * Example 5:
 *
 * Input: text = "leetcode.com&frasl;problemset&frasl;all"
 * Output: "leetcode.com/problemset/all"
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 10^5
 * The string may contain any possible characters out of all the 256 ASCII characters.
 */
public class Solution {
    public String entityParser(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < text.length();++ i) {
            if (text.charAt(i) == '&') {
                String sub1 = i + 4 <= text.length() ? text.substring(i, i + 4) : null;
                String sub2 = i + 5 <= text.length() ? text.substring(i, i + 5) : null;
                String sub3 = i + 6 <= text.length() ? text.substring(i, i + 6) : null;
                String sub4 = i + 7 <= text.length() ? text.substring(i, i + 7) : null;

                if (map.containsKey(sub1)) {
                    sb.append(map.get(sub1));
                    i += 3;
                } else if (map.containsKey(sub2)) {
                    sb.append(map.get(sub2));
                    i += 4;
                } else if (map.containsKey(sub3)) {
                    sb.append(map.get(sub3));
                    i += 5;
                } else if (map.containsKey(sub4)) {
                    sb.append(map.get(sub4));
                    i += 6;
                } else {
                    sb.append('&');
                }
            } else {
                sb.append(text.charAt(i));
            }
        }

        return sb.toString();
    }
}
