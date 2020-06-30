public class Test {
    public static void main(String[] args) {
        int m = 19, n = m;

        while (m > 0) {
            System.out.println(Integer.toBinaryString(m));
            m = (m - 1) & n;
        }
    }
}
