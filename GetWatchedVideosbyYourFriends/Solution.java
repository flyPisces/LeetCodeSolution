package GetWatchedVideosbyYourFriends;

import java.util.*;

/**
 *
 There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.

 Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all watched videos by people with the shortest path equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). For videos with the same frequency order them alphabetically from least to greatest.


 Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 Output: ["B","C"]
 Explanation:
 You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
 Person with id = 1 -> watchedVideos = ["C"]
 Person with id = 2 -> watchedVideos = ["B","C"]
 The frequencies of watchedVideos by your friends are:
 B -> 1
 C -> 2
 */
public class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer> levelIds = new ArrayList<>();
        levelIds.add(id);

        boolean[] visited = new boolean[friends.length];
        visited[id] = true;

        for (int i = 0;i < level;++ i) {
            List<Integer> newLevelIds = new ArrayList<>();

            for (int playerId : levelIds) {
                for (int friend : friends[playerId]) {
                    if (!visited[friend]) {
                        newLevelIds.add(friend);
                        visited[friend] = true;
                    }
                }
            }

            levelIds.clear();
            levelIds = newLevelIds;
        }

        Map<String, Integer> freqMap = new HashMap<>();
        for (int friend : levelIds) {
            for (String video : watchedVideos.get(friend)) {
                freqMap.putIfAbsent(video, 0);
                freqMap.put(video, freqMap.get(video) + 1);
            }
        }

        List<String> results = new ArrayList<>(freqMap.keySet());

        results.sort((a, b) -> {
            int fa = freqMap.get(a);
            int fb = freqMap.get(b);

            if (fa != fb) {
                return fa - fb;
            } else {
                return a.compareTo(b);
            }
        });

        return results;
    }
}
