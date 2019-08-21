package BraceExpansionII;

import java.util.*;

/**
 * Under a grammar given below, strings can represent a set of lowercase words.  Let's use R(expr) to denote the set of words the expression represents.

 Grammar can best be understood through simple examples:

 Single letters represent a singleton set containing that word.
 R("a") = {"a"}
 R("w") = {"w"}
 When we take a comma delimited list of 2 or more expressions, we take the union of possibilities.
 R("{a,b,c}") = {"a","b","c"}
 R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
 When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
 R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
 R("{a{b,c}}{{d,e}f{g,h}}") = R("{ab,ac}{dfg,dfh,efg,efh}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
 Formally, the 3 rules for our grammar:

 For every lowercase letter x, we have R(x) = {x}
 For expressions e_1, e_2, ... , e_k with k >= 2, we have R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 For expressions e_1 and e_2, we have R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}, where + denotes concatenation, and × denotes the cartesian product.
 Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.



 Example 1:

 Input: "{a,b}{c{d,e}}"
 Output: ["acd","ace","bcd","bce"]
 Example 2:

 Input: "{{a,z},a{b,c},{ab,z}}"
 Output: ["a","ab","ac","z"]
 Explanation: Each distinct word is written only once in the final answer.
 */
public class Solution {
    public List<String> braceExpansionII(String expression) {
        char pre = ',';
        String s = expression;

        Stack<List<String>> stack = new Stack<>();

        for (int i = 0;i < expression.length();++ i) {
            char c = s.charAt(i);

            if (c == '{') {
                int j = i, p = 1;

                while (s.charAt(j) != '}' || p != 0) {
                    j ++;
                    if (s.charAt(j) == '{') p ++;
                    if (s.charAt(j) == '}') p --;
                }

                List<String> sList = braceExpansionII(s.substring(i + 1, j));

                if (pre == '*') {
                    stack.push(merge(stack.pop(), sList));
                } else {
                    stack.push(sList);
                }

                i = j;
                pre = '*';
            } else if (Character.isLetter(c)) {
                List<String> slist = new ArrayList<>();
                slist.add("" + c);

                if (pre == '*') {
                    stack.push(merge(stack.pop(), slist));
                } else {
                    stack.push(slist);
                }

                pre = '*';
            }

            if (c == ',' || i == expression.length() - 1) {
                pre = ',';
            }
        }

        Set<String> set = new HashSet<>();
        while (!stack.isEmpty()) {
            for (String str : stack.pop()) {
                if (!set.contains(str)) set.add(str);
            }
        }

        List<String> results = new ArrayList<>(set);
        Collections.sort(results);

        return results;
    }

    private List<String> merge(List<String> list1, List<String> list2) {
        List<String> results = new ArrayList<>();

        for (String str1 : list1) {
            for (String str2 : list2) {
                results.add(str1 + str2);
            }
        }

        return results;
    }
}
