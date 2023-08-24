package week7;

import adt.ListADT;
import adt.errors.BadIndexError;
import adt.errors.TODOErr;

public class SinglyLinkedList<T> extends ListADT<T> {
    /**
     * The start of this list. Node is defined at the bottom of this file.
     */
    Node<T> start;

    @Override
    public T removeFront() {
        checkNotEmpty();
        if (start != null) {
            T temp = start.value;
            start = start.next;
            return temp;
        } else {
            return null;
        }

    }

    @Override
    public T removeBack() {
        checkNotEmpty();
        if (start.next == null) {
            return removeFront();
        }
        Node<T> beforeLast = null;
        Node<T> last = null;
        for (Node<T> n = this.start; n.next != null; n = n.next) {
            beforeLast = n;
            last = n.next;
        }
        beforeLast.next = null;
        return last.value;
    }

    @Override
    public T removeIndex(int index) {
        checkNotEmpty();
        if (index == 0) {
            return this.removeFront();
        }
        Node<T> before = this.start;
        int at = 0;
        // Find the node before index in order to delete the next.
        while (before != null) {
            if (at == index - 1) {
                if (before.next == null) {
                    break;
                }
                T deleted = before.next.value;
                Node<T> after = before.next.next;
                before.next = after;
                return deleted;
            }
            before = before.next;
            at++;
        }
        // Throw error if we could not find that index.
        throw new BadIndexError(index);
    }

    @Override
    public void addFront(T item) {
        this.start = new Node<T>(item, start);
    }

    @Override
    public void addBack(T item) {
        if (this.start == null) {
            addFront(item);
            return;
        }
        Node<T> last = null;
        for (Node<T> current = this.start; current != null; current = current.next) {
            last = current;
        }
        last.next = new Node<T>(item, null);
    }
    // if (this.start == null) {
    // addFront(item);
    // return;
    // }
    // Node<T> last = null;
    // for (Node<T> current = this.start; current != null; current = current.next) {
    // last = current;
    // }
    // assert (last.next == null);
    // last.next = new Node<T>(item, null);
    // throw new TODOErr("SLL.addBack");

    @Override
    public void addIndex(int index, T item) {
        checkNotEmpty();
        if (index == 0) {
            this.addFront(item);
            return;
        }
        Node<T> before = this.start;

        int at = 0;

        while (before != null) {
            if (at == index - 1) {
                Node<T> after = before.next;
                before.next = new Node<T>(item, null);
                before.next.next = after;
                return;
            }
            before = before.next;
            at++;
        }
        throw new BadIndexError(index);
    }

    @Override
    public T getFront() {
        checkNotEmpty();
        return start.value;
    }

    @Override
    public T getBack() {
        checkNotEmpty();
        Node<T> last = null;
        for (Node<T> n = this.start; n != null; n = n.next) {
            last = n;
        }
        return last.value;
    }

    @Override
    public T getIndex(int index) {
        checkNotEmpty();
        int at = 0;
        for (Node<T> n = this.start; n != null; n = n.next) {
            if (at++ == index) {
                return n.value;
            }
        }
        throw new BadIndexError(index);
    }

    @Override
    public void setIndex(int index, T value) {
        checkNotEmpty();
        int at = 0;
        for (Node<T> n = this.start; n != null; n = n.next) {
            if (at++ == index) {
                n.value = value;
                return;
            }
        }
        throw new BadIndexError(index);
    }

    @Override
    public int size() {
        int count = 0;
        for (Node<T> n = this.start; n != null; n = n.next) {
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return this.start == null;
    }

    /**
     * The node on any linked list should not be exposed. Static means we don't need
     * a "this" of SinglyLinkedList to make a node.
     * 
     * @param <T> the type of the values stored.
     */
    static class Node<T> {
        /**
         * What node comes after me?
         */
        public Node<T> next;
        /**
         * What value is stored in this node?
         */
        public T value;

        /**
         * Create a node with a friend.
         * 
         * @param value - the value to put in it.
         * @param next  - the friend of this node.
         */
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Alternate constructor; create a node with no friends.
         * 
         * @param value - the value to put in it.
         */
        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
