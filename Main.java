


import WildcardMatching.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("abbaa", "ab*a*c*a"));

        System.out.println("aab".matches("c*a*b"));

    }
}
