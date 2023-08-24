package week4;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a collection of static methods.
 * You run it by going to {@link ListProblemsTest}.
 */
public class ListProblems {

    /**
     * Make a list with the strings "A", "B", "C", and "D".
     * 
     * @return a mutable list (no List.of for you)
     */
    public static List<String> makeABCD() {
        List<String> out = new ArrayList<>();
        out.add("A");
        out.add("B");
        out.add("C");
        out.add("D");
        return out;

    }

    /**
     * Create a new list that is a reversed copy of the input list.
     * 
     * @param input a list of strings.
     * @return a new list containing the reversed input.
     */
    public static List<String> reverseList(List<String> input) {
        List<String> reversed = new ArrayList<>();
        for (int i = input.size() - 1; i >= 0; i--) {
            reversed.add(input.get(i));
        }
        return reversed;
    }

    /**
     * Given a list, find the index of its minimum value.
     * 
     * @param numbers - a list of doubles, e.g., [3.0, 2.0, 1.0]
     * @return the position of the minimum value, e.g., 2.
     */
    public static int findMinimumPosition(List<Double> numbers) {
        if (numbers.isEmpty() == false) {
            Double min = numbers.get(0);
            for (int i = 0; i < numbers.size(); i++) {
                if (min >= numbers.get(i)) {
                    min = numbers.get(i);
                }
            }
            return numbers.indexOf(min);
        } else {
            return -1;
        }
    }

    /**
     * Create a new list multiplying each element by 'multiple'
     * 
     * @param numbers  the input list. e.g., [1,2,3]
     * @param multiple the scale to multiply each number by, e.g., 2
     * @return a list with multiplied values, e.g., [2, 4, 6]
     */
    public static List<Integer> multiplyItems(List<Integer> numbers, int multiple) {
        List<Integer> multiplied = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            multiplied.add(numbers.get(i) * multiple);
        }
        return multiplied;
    }
}
