package FizzBuzz;

import java.util.*;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

 Example:

 n = 15,

 Return:
 [
 "1",
 "2",
 "Fizz",
 "4",
 "Buzz",
 "Fizz",
 "7",
 "8",
 "Fizz",
 "Buzz",
 "11",
 "Fizz",
 "13",
 "14",
 "FizzBuzz"
 ]

 * Created by aoshen on 10/15/16.
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();

        if (n <= 0) return results;
        int index = 1;

        while (index <= n) {
            if (index % 3 == 0 && index % 5 == 0) {
                results.add("FizzBuzz");
            } else if (index % 3 == 0) {
                results.add("Fizz");
            } else if (index % 5 == 0) {
                results.add("Buzz");
            } else {
                results.add(String.valueOf(index));
            }

            ++ index;
        }

        return results;
    }
}
