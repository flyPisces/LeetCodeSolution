package ZumaGame;

import java.util.*;

/**
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W).
 * You also have several balls in your hand.

 Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place).
 Then, if there is a group of 3 or more balls in the same color touching, remove these balls.
 Keep doing this until no more balls can be removed.

 Find the minimal balls you have to insert to remove all the balls on the table.
 If you cannot remove all the balls, output -1.

 Examples:

 Input: "WRRBBW", "RB"
 Output: -1
 Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW

 Input: "WWRRBBWW", "WRBRW"
 Output: 2
 Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty

 Input:"G", "GGGGG"
 Output: 2
 Explanation: G -> G[G] -> GG[G] -> empty

 Input: "RBYYBBRRB", "YRBGB"
 Output: 3
 Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty

 Note:
 You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
 The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
 The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
 Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.

 * Created by aoshen on 1/15/17.
 */
public class Solution {
    public int findMinStep(String board, String hand) {
        List<Character> boardList = new ArrayList<Character>();
        for (char c : board.toCharArray()) {
            boardList.add(c);
        }
        Map<Character,Integer> handMap = new HashMap<>();
        handMap.put('R',0);
        handMap.put('Y',0);
        handMap.put('B',0);
        handMap.put('G',0);
        handMap.put('W',0);
        for (char h : hand.toCharArray()) {
            handMap.put(h, handMap.get(h) + 1);
        }

        return find(boardList, handMap);
    }

    private int find(List<Character> board, Map<Character, Integer> hand) {
        cleanUpBoard(board);
        if (board.size() == 0) return 0;
        if (isEmpty(hand)) return -1;

        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0;i < board.size();++ i) {
            char c = board.get(i);
            count ++;
            if (i == board.size() - 1 || board.get(i + 1) != c) {
                int missing = 3 - count;
                if (hand.get(c) >= missing) {
                    hand.put(c, hand.get(c) - missing);
                    List<Character> smallerBoard = new ArrayList<>(board);
                    for (int j = 0;j < count;++ j) {
                        smallerBoard.remove(i - j);
                    }
                    int smallerFind = find(smallerBoard, hand);
                    if (smallerFind != -1) {
                        min = Math.min(min, smallerFind + missing);
                    }
                    hand.put(c, hand.get(c) + missing);
                }
                count = 0;
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private void cleanUpBoard(List<Character> board) {
        boolean cleaned = false;
        int count = 0;

        for (int i = 0;i < board.size();++ i) {
            char c = board.get(i);
            count ++;

            if (i == board.size() - 1 || board.get(i + 1) != c) {
                if (count >= 3) {
                    for (int j = 0;j < count;++ j) {
                        board.remove(i - j);
                    }

                    cleaned = true;
                    break;
                }

                count = 0;
            }
        }

        if (cleaned) {
            cleanUpBoard(board);
        }
    }

    private boolean isEmpty(Map<Character, Integer> hand) {
        for (int val : hand.values()) {
            if (val > 0) return false;
        }

        return true;
    }
}
