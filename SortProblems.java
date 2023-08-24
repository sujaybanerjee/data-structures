package week8;

import adt.ListADT;
import adt.errors.TODOErr;
import adt.impl.JavaList;

public class SortProblems {

    /**
     * Read through the list in data and return true only if it's sorted.
     * 
     * @param data - a list of numbers.
     * @return true if they are sorted, false if not.
     */
    public static boolean isSorted(ListADT<Integer> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.getIndex(i) > data.getIndex(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Insert the value x in to the sorted list "target" in the correct position.
     * Helper for {@link #insertionSort}; complexity O(n).
     * 
     * @param x      - the new number to insert.
     * @param target - the sorted list to modify (might be empty!)
     */
    public static void insertSorted(int x, ListADT<Integer> target) {
        for (int i = 0; i < target.size(); i++) {
            if (target.getIndex(i) > x) {
                target.addIndex(i, x);
                return;
            }
        }
        target.addBack(x);

    }

    /**
     * Find the position of the minimum element of list starting at start. Helper
     * for selectionSort; complexity: O(n).
     * 
     * @param list  - the full list (NOT sorted)
     * @param start - where to start in list (don't look to the left).
     * @return the position (int greater than start) of the minimum element.
     */
    public static int findMinPosition(ListADT<Integer> list, int start) {
        assert (start < list.size()) : "There should be stuff in the list to the right of start!";
        int min = list.getIndex(start);
        for (int i = start; i < list.size(); i++) {
            if (min > list.getIndex(i)) {
                min = list.getIndex(i);

            }
        }
        for (int j = start; j < list.size(); j++) {
            if (list.getIndex(j) == min) {
                return j;
            }
        }
        return 0;
    }

    /**
     * InsertionSort: Create a new output list that contians all elements of input
     * but in sorted order. This is very short if you call {@link #insertSorted}.
     * 
     * @param input - the list to sort.
     * @return a new sorted list -- just use JavaList<>().
     */
    public static ListADT<Integer> insertionSort(ListADT<Integer> input) {
        ListADT<Integer> output = new JavaList<>();
        for (int i = 0; i < input.size(); i++) {
            insertSorted(input.getIndex(i), output);
        }
        return output;
    }

    /**
     * SelectionSort: Move through the input list left-to-right and swap the minimum
     * element of the list to the current position until you reach the end.
     * 
     * Helpful: - {@link #findMinPosition(ListADT, int)} -
     * {@link ListADT#swap(int, int)} is also really helpful :)
     * 
     * @param fixMe - the input and output of this method -- it modifies a list
     *              in-place.
     */
    public static void selectionSort(ListADT<Integer> fixMe) {
        for (int i = 0; i < fixMe.size(); i++) {
            fixMe.swap(i, findMinPosition(fixMe, i));
        }
    }
}
