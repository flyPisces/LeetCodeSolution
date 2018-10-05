package OnlineElection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 In an election, the i-th vote was cast for persons[i] at time times[i].

 Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.

 Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.



 Example 1:

 Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 Output: [null,0,1,1,0,0,1]
 Explanation:
 At time 3, the votes are [0], and 0 is leading.
 At time 12, the votes are [0,1,1], and 1 is leading.
 At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 This continues for 3 more queries at time 15, 24, and 8.
 */
public class TopVotedCandidate {

    int leader = -1;
    int max = 0;
    List<Vote> results = new ArrayList<>();
    Map<Integer, Integer> mapping = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int N = persons.length;

        for (int i = 0;i < N;++ i) {
            int cnt = mapping.getOrDefault(persons[i], 0 );
            cnt += 1;

            mapping.put(persons[i], cnt);

            if (cnt >= max) {
                if (leader != persons[i]) {
                    leader = persons[i];
                    results.add(new Vote(persons[i], times[i]));
                }

                if (cnt > max) {
                    max = cnt;
                }
            }
        }
    }

    public int q(int t) {
        int low = 0, high = results.size() - 1;

        if (t >= results.get(high).time) {
            return results.get(high).person;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (t >= results.get(mid).time && t < results.get(mid + 1).time) {
                return results.get(mid).person;
            } else if (t < results.get(mid).time) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

class Vote {
    int person, time;

    public Vote(int person, int time) {
        this.person = person;
        this.time = time;
    }
}