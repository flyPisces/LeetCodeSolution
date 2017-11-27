package RangeModule;

public class Interval implements Comparable<Interval> {
    int left;
    int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Interval that){
        if (this.right == that.right) {
            return this.left - that.left;
        }

        return this.right - that.right;
    }
}
