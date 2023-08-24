package week6;

import java.util.ArrayList;

import adt.StackADT;
import adt.errors.EmptyListError;
import adt.errors.TODOErr;

/**
 * This class represents a stack by adding/removing to the back of a Java list.
 */
public class JavaStack<T> implements StackADT<T> {
    /**
     * This arraylist datastructure does all the real work.
     */
    ArrayList<T> inner;

    public JavaStack() {
        this.inner = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        // TODO: add to the back of the list
        inner.add(item);
    }

    @Override
    public T pop() {
        // TODO: remove from the back of the list
        if (inner.size() > 0) {
            return inner.remove(inner.size() - 1);
        } else {
            throw new EmptyListError();
        }
    }

    @Override
    public T peek() {
        // TODO: look at the most recently-pushed item
        // ... should be null if no such item.
        if (inner.size() > 0) {
            return inner.get(inner.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO: return true if this stack is empty;
        return inner.isEmpty();
    }

}
