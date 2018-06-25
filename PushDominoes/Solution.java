package PushDominoes;

/**
 * There are N dominoes in a line, and we place each domino vertically upright.

 In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

 After each second, each domino that is falling to the left pushes the adjacent domino on the left.

 Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

 When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

 For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

 Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

 Return a string representing the final state.

 Example 1:

 Input: ".L.R...LR..L.."
 Output: "LL.RR.LLRRLL.."
 Example 2:

 Input: "RR.L"
 Output: "RR.L"
 Explanation: The first domino expends no additional force on the second domino.
 */
public class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 1;j < dominoes.length();++ j) {
            if (dominoes.charAt(j) == '.') continue;
            if (i > 0) sb.append(dominoes.charAt(i));

            int middle = j - i - 1;

            if (dominoes.charAt(i) == dominoes.charAt(j)) {
                for (int k = 0;k < middle;++ k) {
                    sb.append(dominoes.charAt(i));
                }
            } else if (dominoes.charAt(i) == 'L' && dominoes.charAt(j) == 'R') { //LR
                for (int k = 0;k < middle;++ k) {
                    sb.append('.');
                }
            } else {  //RL
                for (int k = 0;k < middle / 2;++ k) {
                    sb.append('R');
                }
                if (middle % 2 == 1) {
                    sb.append('.');
                }
                for (int k = 0;k < middle / 2;++ k) {
                    sb.append('L');
                }
            }

            i = j;
        }

        return sb.toString();
    }

    public String pushDominoes1(String dominoes) {
        char[] a = dominoes.toCharArray();
        int L = -1, R = -1;//positions of last seen L and R
        for (int i = 0; i <= dominoes.length(); i++)
            if (i == a.length || a[i] == 'R') {
                if (R > L)//R..R, turn all to R
                    while (R < i)
                        a[R++] = 'R';
                R = i;
            } else if (a[i] == 'L')
                if (L > R || (R == -1 && L == -1))//L..L, turn all to L
                    while (++L < i)
                        a[L] = 'L';
                else { //R...L
                    L = i;
                    int lo = R + 1, hi = L - 1;
                    while (lo < hi) { //one in the middle stays '.'
                        a[lo++] = 'R';
                        a[hi--] = 'L';
                    }
                }
        return new String(a);
    }
}
