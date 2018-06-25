package ExamRoom;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.TreeSet;

/**
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

 When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)

 Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.



 Example 1:

 Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 Output: [null,0,9,4,2,null,5]
 Explanation:
 ExamRoom(10) -> null
 seat() -> 0, no one is in the room, then the student sits at seat number 0.
 seat() -> 9, the student sits at the last seat number 9.
 seat() -> 4, the student sits at the last seat number 4.
 seat() -> 2, the student sits at the last seat number 2.
 leave(4) -> null
 seat() -> 5, the student​​​​​​​ sits at the last seat number 5.
 */
public class ExamRoom {
    int N;
    TreeSet<Integer> set;

    public ExamRoom(int N) {
        this.N = N;
        set = new TreeSet<>();
    }

    public int seat() {
        int student = 0;

        if (!set.isEmpty()) {
            int dist = set.first();
            Integer prev = null;

            for (Integer curr : set) {
                if (prev != null) {
                    if ((curr - prev) / 2 > dist) {
                        student = prev + (curr - prev) / 2;
                        dist = (curr - prev) / 2;
                    }
                }

                prev = curr;
            }

            if (N - 1 - set.last() > dist) {
                student = N - 1;
            }
        }

        set.add(student);
        return student;
    }

    public void leave(int p) {
        set.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom obj = new ExamRoom(10);
        System.out.println(obj.seat());
    }
}
