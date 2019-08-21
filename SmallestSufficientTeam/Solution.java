package SmallestSufficientTeam;

import java.util.*;

/**
 * In a project, you have a list of required skills req_skills, and a list of people.  The i-th person people[i] contains a list of skills that person has.

 Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill.  We can represent these teams by the index of each person: for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].

 Return any sufficient team of the smallest possible size, represented by the index of each person.

 You may return the answer in any order.  It is guaranteed an answer exists.



 Example 1:

 Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 Output: [0,2]
 Example 2:

 Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 Output: [1,2]
 */

public class Solution {
    List<Integer> solutions = new ArrayList<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int N = req_skills.length, idx = 0;

        Map<String, Integer> mapping = new HashMap<>();
        for (String req_skill : req_skills) {
            mapping.put(req_skill, idx ++);
        }

        int[] pe = new int[people.size()];

        idx = 0;
        for (;idx < people.size();++ idx) {
            for (String skill : people.get(idx)) {
                pe[idx] += 1 << mapping.get(skill);
            }

        }

        dfs(0, N, pe, new ArrayList<>());

        int[] results = new int[solutions.size()];

        for (int i = 0;i < results.length;++ i) {
            results[i] = solutions.get(i);
        }

        return results;
    }

    private void dfs(int curr, int N, int[] pe, List<Integer> temp) {
        if (curr == (1 << N) - 1) {
            if (solutions.size() == 0 ||  temp.size() < solutions.size()) {
                solutions = new ArrayList<>(temp);
            }

            return;
        }

        if (solutions.size() != 0 && temp.size() >= solutions.size()) return;

        int zeroBit = 0 ;
        while (((curr >> zeroBit) & 1) == 1) {
            zeroBit ++;
        }

        for (int i = 0;i < pe.length;++ i) {
            int per = pe[i];

            if (((per >> zeroBit) & 1) == 1) {
                temp.add(i);
                dfs(curr | per, N, pe, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
