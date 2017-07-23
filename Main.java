


import WildcardMatching.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String expression = "-1/2+1/2";
        String[] splits = expression.split("(?=[+/-])");
        for (int i = 0;i < splits.length;++ i) {
            System.out.println(splits[i]);
        }
    }
}
