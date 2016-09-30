package ReadNCharactersGivenRead4Two;

import java.util.*;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function may be called multiple times.

 * Created by aoshen on 7/10/16.
 */
public class Solution {

    private Queue<Character> queue = new LinkedList<>();

    public int read4(char[] tmp) {
        return 4;
    }

    public int read(char[] buf, int n) {
        int i = 0;

        while (i < n && !queue.isEmpty()) {
            buf[i] = queue.poll();
            ++ i;
        }

        for (;i < n;i += 4) {
            char[] tmp = new char[4];
            int len = read4(tmp);

            if (len > n - i) {
                System.arraycopy(tmp, 0, buf, i, n - i);

                for (int j = n - i;j < len;++ j) {
                    queue.offer(tmp[j]);
                }
            } else {
                System.arraycopy(tmp, 0, buf, i, len);
            }

            if (len < 4) return Math.min(n, i + len);
        }

        return n;
    }
}
