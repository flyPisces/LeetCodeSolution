package Test;

import java.util.*;

public class Solution {
    List<Integer> lengthEachScene(List<Character> inputList)
    {
        List<Integer> partitionLenResults = new ArrayList<>();

        // if inputList is null or empty list, return empty list
        if (inputList == null || inputList.size() == 0) {
            return partitionLenResults;
        }

        // characterLastPosMap records last position of given character
        Map<Character, Integer> characterLastPosMap = new HashMap<>();
        for (int i = 0;i < inputList.size();++ i) {
            characterLastPosMap.put(inputList.get(i), i);
        }

        int start = 0;
        // records the maximum position of all visited characters so far
        int maxLastCharacterPos = 0;
        for (int i = 0;i < inputList.size();++ i) {
            maxLastCharacterPos = Math.max(i, characterLastPosMap.get(inputList.get(i)));

            // if current position is the same as maxLastCharacterPos, then partition is found
            if (maxLastCharacterPos == i) {
                partitionLenResults.add(i - start + 1);
                start = i + 1;
            }
        }

        return partitionLenResults;
    }

    public static void main(String[] args) {
        List<Character> inputList = new ArrayList<>();
        inputList.add('a');
        inputList.add('b');
        inputList.add('c');
        inputList.add('d');inputList.add('a');
        inputList.add('e');
        inputList.add('f');
        inputList.add('g');
        inputList.add('h');
        inputList.add('i');
        inputList.add('j');
        inputList.add('e');

        Solution solution = new Solution();
        System.out.println(solution.lengthEachScene(inputList));
    }
}
