package AnalyzeUserWebsiteVisitPattern;

import java.util.*;

/**
 *
 We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

 A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)

 Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.



 Example 1:

 Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 Output: ["home","about","career"]
 Explanation:
 The tuples in this example are:
 ["joe", 1, "home"]
 ["joe", 2, "about"]
 ["joe", 3, "career"]
 ["james", 4, "home"]
 ["james", 5, "cart"]
 ["james", 6, "maps"]
 ["james", 7, "home"]
 ["mary", 8, "home"]
 ["mary", 9, "about"]
 ["mary", 10, "career"]
 The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 */
public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> mapping  = new HashMap<>();

        for (int i = 0;i < username.length;++ i) {
            mapping.putIfAbsent(username[i], new ArrayList<>());
            mapping.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        Map<String, Integer> temp = new HashMap<>();
        String res = "";
        for (String key: mapping.keySet()) {
            Set<String> visited = new HashSet<>();
            List<Pair> paris = mapping.get(key);
            Collections.sort(paris, (a, b) -> a.time - b.time);

            for (int i = 0;i < paris.size();++ i) {
                for (int j = i + 1;j < paris.size();++ j) {
                    for (int k = j + 1;k < paris.size();++ k) {
                        String websites = paris.get(i).web  + " " + paris.get(j).web + " " + paris.get(k).web;

                        if (visited.add(websites)) {
                            temp.put(websites, temp.getOrDefault(websites, 0) + 1);
                        }

                        if (res.isEmpty() || (temp.get(websites) > temp.get(res)) || (temp.get(websites) == temp.get(res) && websites.compareTo(res) < 0)) {
                            res = websites;
                        }
                    }
                }
            }
        }

        String[] splits = res.split(" ");
        List<String> results = new ArrayList<>();
        results.add(splits[0]);
        results.add(splits[1]);
        results.add(splits[2]);

        return results;
    }

    class Pair {
        int time;
        String web;

        public Pair(int time, String web) {
            this.time = time;
            this.web = web;
        }
    }
}
