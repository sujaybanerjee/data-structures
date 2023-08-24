package week8;

import adt.ListADT;
import adt.errors.TODOErr;

// TODO: comment this, complete methods; complete recursiveMin test.
//This method begins at int n and counts down until it reaches 0
// Prints done when reaches 0
public class RecursionProblems {
    public static void countDown(int n) {
        if (n > 0) {
            System.out.println("Count: " + n);
            countDown(n - 1);
        } else {
            System.out.println("Done!");
        }
    }

    // Resets the value of fact as it multiplies all the values from n to 0
    // int n is the input parameter and it returns fact which is the variable the
    // factorial get multiplied into
    public static long factorialLoop(int n) {
        long fact = 1;
        for (int i = n; i > 0; i--) {
            fact *= i;
        }
        return fact;
    }

    public static long recursiveFactorial(int n) {
        // long factorial = 1;
        if (n == 0) {
            return 1;
        } else {
            n *= recursiveFactorial(n - 1);
        }
        return n;
    }

    // Recurses and checks if the front is less than the rest
    // List ADT of numbers and the min of the numbers is checked and returned
    public static int recursiveMin(ListADT<Integer> numbers) {
        if (numbers.size() <= 1) {
            return numbers.getFront();
        }
        int first = numbers.getFront();
        int minRest = recursiveMin(numbers.slice(1, numbers.size()));
        return Math.min(first, minRest);
    }

    public static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        if ((word.charAt(0) != word.charAt(word.length() - 1))) {
            return false;
        } else {
            return isPalindrome(word.substring(1, word.length() - 1));
        }
    }

    public static void main(String[] args) {
        countDown(10);
        System.out.println("Check the tests for your recursive functions.");
    }
}
