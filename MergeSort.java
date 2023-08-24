package week8;

import adt.ListADT;
import adt.errors.TODOErr;
import adt.impl.JavaList;
import week7.SLLQ;

public class MergeSort {
    /**
     * This method walks through two sorted input lists and creates an output list
     * that contains all elements from the two inputs.
     * 
     * @param lhs - a sorted list.
     * @param rhs - a sorted list.
     * @return a sorted list containing all of the items from lhs and rhs.
     */
    public static ListADT<Integer> combineTwoSortedLists(ListADT<Integer> lhs, ListADT<Integer> rhs) {
        ListADT<Integer> combined = new JavaList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < lhs.size() && j < rhs.size()) {
            if (lhs.getIndex(i) < rhs.getIndex(j)) {
                combined.addIndex(k, lhs.getIndex(i));
                k++;
                i++;
            } else {
                combined.addIndex(k, rhs.getIndex(j));
                k++;
                j++;
            }
        }
        while (i < lhs.size()) {
            combined.addIndex(k, lhs.getIndex(i));
            k++;
            i++;
        }
        while (j < rhs.size()) {
            combined.addIndex(k, rhs.getIndex(j));
            k++;
            j++;
        }
        return combined;
    }

    /**
     * Recursively sort this list by breaking it in half and piecing it back
     * together. You will need to call
     * {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
     *
     * @param input - the input list.
     * @return a new list containing the sorted output.
     */
    public static ListADT<Integer> doMergeSortRecursively(ListADT<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }
        int mid = input.size() / 2;
        ListADT<Integer> lhs = doMergeSortRecursively(input.slice(0, mid));
        ListADT<Integer> rhs = doMergeSortRecursively(input.slice(mid, input.size()));
        return combineTwoSortedLists(lhs, rhs);

        // slice two halves and do merge sort on each half then combone
    }

    /**
     * Iteratively sort this list by breaking into lists of size 1 and adding them
     * to a ListADT<ListADT<Integer>> todo; The ``todo`` list only ever contains
     * sorted lists. We can now take two of them at a time, and combine them until
     * we only have 1 sorted list remaining; this is our output.
     * 
     * You will need to call {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
     * 
     * @param input - the input list.
     * @return a new list containing the sorted output.
     */
    public static ListADT<Integer> doMergeSortIteratively(ListADT<Integer> input) {
        // Create singleton lists as "work" queue.
        SLLQ<ListADT<Integer>> work = new SLLQ<>();
        while (!input.isEmpty()) {
            ListADT<Integer> job = new JavaList<>();
            job.addBack(input.removeFront());
            work.enqueue(job);
        }
        ListADT<ListADT<Integer>> todo = new JavaList<>();
        while (!work.isEmpty()) {
            todo.addBack(work.dequeue());
        }
        while (!todo.isEmpty() && todo.getFront() != todo.getBack()) {
            todo.addBack(combineTwoSortedLists(todo.removeFront(), todo.removeFront()));
        }
        return todo.getFront();
    }
}
